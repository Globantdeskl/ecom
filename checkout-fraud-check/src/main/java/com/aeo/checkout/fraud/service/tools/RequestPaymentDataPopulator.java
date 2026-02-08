package com.aeo.checkout.fraud.service.tools;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.aeo.checkout.fraud.model.AuthorizationDetails;
import com.aeo.checkout.fraud.model.CreditDebitTender;
import com.aeo.checkout.fraud.model.DigitalWalletTender;
import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.GiftCardTender;
import com.aeo.checkout.fraud.model.PaymentMethod;
import com.aeo.checkout.fraud.model.PaypalTender;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.ACIConstants.EBTServiceCode;
import com.aeo.checkout.fraud.model.aci.ACIConstants.MethodOfPaymentType;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class RequestPaymentDataPopulator implements FraudRequestDataPopulator {
	
	@Override
	public void populate(FraudRequest order, Map<LPTransactionProperty, String> requestMap) {

		CreditDebitTender creditCardPg = null;
		PaypalTender payPalPg = null;
		DigitalWalletTender altPayPg = null;
		List<GiftCardTender> giftCardPgs = new ArrayList<>();

		for (PaymentMethod pg : order.getPaymentMethods()) {
			if (pg.getCreditDebitTender() != null) {
				creditCardPg = pg.getCreditDebitTender();
			} else if (pg.getPaypalTender() != null) {
				payPalPg = pg.getPaypalTender();
			} else if (pg.getGiftCardTender() != null) {
				giftCardPgs.add(pg.getGiftCardTender());
			} else if (pg.getDigitalWalletTender() != null) {
				altPayPg = pg.getDigitalWalletTender();
			} else {
				log.warn("Unknown payment group: {}", order.getOrderId());
			}
		}

		boolean splitPayment = (creditCardPg != null && !giftCardPgs.isEmpty());
		
		// scenarios:
		// 1) One CC
		// 2) One PayPal
		// 3) One or more GC
		// 4) Split: One CC and one or more GC
		
		if (!splitPayment) {
			if (creditCardPg != null) {
				// add credit card
				populateCreditCardData(order, creditCardPg, requestMap);
			} else if (payPalPg != null) {
				// add paypal
				populatePayPalData(order, payPalPg, requestMap);
			} else if (altPayPg != null) {
				// add altpay
				populateAltPayData(order, altPayPg, requestMap);
			} else if (!giftCardPgs.isEmpty()) {
				// add gift card(s)
				populateGiftCardsData(order, giftCardPgs, requestMap);
			}
		} else {
			// add split payment
			populateSplitPaymentData(order, creditCardPg, giftCardPgs, requestMap);
		}
		
		requestMap.put(LPTransactionProperty.CUST_TYPE_CD, ACIConstants.BILLING_DETAILS_PRESENT);
	}
	
	private void populateCreditCardData(FraudRequest order, CreditDebitTender creditCardPg,
			Map<LPTransactionProperty, String> requestMap) {

		// MOP_TYPE_CD, TOKEN_ID, ACCT_NUM, CARD_EXP_DT, CARD_SEC_IND_CD,
		// RSP_CD, RSP_AVS_CD, RSP_SEC_CD, EBT_Service

		// MOP_TYPE_CD: method of payment type
		// we cannot decrypt the CC from BAMS encryption, so without a token, we cannot
		// proceed and should never have gotten here
		if (TransformerUtils.isNotBlank(creditCardPg.getFraudToken())) {
			// use the fraud token
			requestMap.put(LPTransactionProperty.TOKEN_ID, creditCardPg.getFraudToken());
			// we always set MOP_TYPE_CD to TK when passing a token
			requestMap.put(LPTransactionProperty.MOP_TYPE_CD, MethodOfPaymentType.TOKEN.code());
		} else {
			// this cannot happen as we validate and/or add token up-front
			log.warn("Fraud Token not Found: {}", order.getOrderId());
			return;
		}
		
		// using order submit date for the expire date of plcc credit card type
		if(order.getOrderMetaData().isHasPLCCPayment()) {
			log.debug("Is Order Placed with PLCC: {}", order.getOrderMetaData().isHasPLCCPayment());
			populateOneYearExpireDate(LocalDateTime.now().plusYears(1), requestMap);
		} else {
			requestMap.put(LPTransactionProperty.CARD_EXP_DT, 
				TransformerUtils.formatExpirationDate(creditCardPg.getCreditCardExpDate()));
		}
		// CARD_SEC_IND_CD (Card Security Indicator Code): 1 if CVV, 0 if not
		// We are not persisting the CVV (nor should we), so we will not have cvv on the
		// payment group. If we reload an order for retry we probably need to look at
		// the auth status CVV response to determine if we passed one after the fact.
		// Per Wiki and conversation with AJB team, if response has CVV response value
		// then the request contained a CVV
		boolean requestHadCVV = TransformerUtils.isNotBlank(creditCardPg.getCardVerificationNumber());

		// track approved (vs denied) for EBT_Service code later
		boolean approved = false;

		// default response code, if not approve or decline
		ACIConstants.AuthResponseCode respCode = ACIConstants.AuthResponseCode.ERROR;
		AuthorizationDetails authDtls = creditCardPg.getAuthorizationDtls();
		if (authDtls != null) {
			
			requestHadCVV = !requestHadCVV ? TransformerUtils.isNotBlank(authDtls.getCvvResponse()) : requestHadCVV;
			
			// RSP_CD (Auth Response Code): 00 for approve, 05 for decline, 96 for error
			if (authDtls.isTransactionSuccess()) {
				respCode = ACIConstants.AuthResponseCode.APPROVE;
				approved = true;
			} else if (ACIConstants.AJB_AUTH_DECLINED_MESSAGE.equals(authDtls.getErrorMessage())) {
				respCode = ACIConstants.AuthResponseCode.DECLINE;
			}
			
			// RSP_AVS_CD (AVS Response): avs code from auth status
			requestMap.put(LPTransactionProperty.RSP_AVS_CD, authDtls.getAvsCode());

			// RSP_SEC_CD (CIN/CVV Response): cvv response from auth status
			// if we get an X (service down, not a valid CVV response code for RedACI), we
			// map that to P (not processed)
			String cvvResponse = authDtls.getCvvResponse();
			if (TransformerUtils.isBlank(cvvResponse) 
					|| ACIConstants.AJB_CVV_PROVIDER_NO_RESPONSE.equalsIgnoreCase(cvvResponse)) {
				cvvResponse = ACIConstants.CINResponse.CIN_NOT_PROCESSED.code();
			}
			requestMap.put(LPTransactionProperty.RSP_SEC_CD, cvvResponse.toUpperCase());
			
		} else {
			log.warn("No credit card authorization status found for order "
					+ order.getCustomerOrder().getCustomerOrderId());
		}
		requestMap.put(LPTransactionProperty.RSP_CD, respCode.code());
		requestMap.put(LPTransactionProperty.CARD_SEC_IND_CD, requestHadCVV ? "1" : "0");

		if (order.getOrderMetaData().isHasPLCCPayment()) {
			requestMap.put(LPTransactionProperty.EBT_USER_DATA8, ACIConstants.ALT_PMT_TYPE_PRIVATE_LABEL_CARD);
		}
		
		populateDevicedataCode(approved, order.getCustomerOrder().getDeviceData(), requestMap,
				EBTServiceCode.CC_AUTH_DEVICE, EBTServiceCode.CC_AUTH_NO_DEVICE);
		
	}
	
	private void populateDevicedataCode(boolean paymentApproved, String orderDeviceData, 
			Map<LPTransactionProperty, String> requestMap, EBTServiceCode deviceCode, EBTServiceCode noDeviceCode) {
		// EBT_Service code: function of payment type, device data, and auth decline
		// for credit card, options are:
		// N: CC + no device ID
		// I: CC + device ID
		// A: CC decline + no device ID
		// O: CC decline + device ID
		// X: alt payment + device ID
		// U: alt payment + no device ID
		// A: CC decline + no device ID
		// O: CC decline + device ID
		if (TransformerUtils.isNotBlank(orderDeviceData)) {
			requestMap.put(LPTransactionProperty.EBT_Service,
					(paymentApproved ? deviceCode.code() : EBTServiceCode.NO_SCORE_DEVICE.code()));
		} else {
			requestMap.put(LPTransactionProperty.EBT_Service,
					(paymentApproved ? noDeviceCode.code() : EBTServiceCode.NO_SCORE_NO_DEVICE.code()));
		}
	}
	
	private void populatePayPalData(FraudRequest order, PaypalTender payPalPg,
			Map<LPTransactionProperty, String> requestMap) {

		// MOP_TYPE_CD, TOKEN_ID, ACCT_NUM, CARD_EXP_DT, CARD_SEC_IND_CD,
		// RSP_CD, RSP_AVS_CD, RSP_SEC_CD, EBT_Service
		// EBT_USER_DATA3 (paypal status), EBT_USER_DATA4 (paypal email)
		// EBT_USER_DATA8 (paypal)

		requestMap.put(LPTransactionProperty.MOP_TYPE_CD, ACIConstants.MethodOfPaymentType.PAYPAL.code());

		// ACCT_NUM -> paypal payer ID
		requestMap.put(LPTransactionProperty.ACCT_NUM, payPalPg.getPayerId());

		// CARD_EXP_DT -> for paypal, today's date + 1 year
		populateOneYearExpireDate(LocalDateTime.now().plusYears(1), requestMap);

		// CARD_SEC_IND_CD -> 0
		requestMap.put(LPTransactionProperty.CARD_SEC_IND_CD, LPTransactionProperty.CARD_SEC_IND_CD.defaultValue());

		boolean approved = false;
		if (payPalPg.getAuthorizationDtls() != null) {
			// RSP_CD: 00=Approved, 05=Declined, 96=Error
			// we don't currently seem to get a differentiation between Declined and Error
			// from the AEOPayPalProcessor
			// for now, just use Decline

			if (payPalPg.getAuthorizationDtls().isTransactionSuccess()) {
				approved = true;
				requestMap.put(LPTransactionProperty.RSP_CD, ACIConstants.AuthResponseCode.APPROVE.code());
			} else {
				requestMap.put(LPTransactionProperty.RSP_CD, ACIConstants.AuthResponseCode.DECLINE.code());
			}
		}

		// PayPal currently does not return AVS data
		// RSP_AVS_CD
		requestMap.put(LPTransactionProperty.RSP_AVS_CD, ACIConstants.AVSResponse.AVS_SYS_UNAVAIL.code());

		// RSP_SEC_CD: this is CVV, we don't have this
		requestMap.put(LPTransactionProperty.RSP_SEC_CD, ACIConstants.CINResponse.CIN_NOT_PROCESSED.code());

		populateDevicedataCode(approved, order.getCustomerOrder().getDeviceData(), requestMap,
				EBTServiceCode.ALT_PAYMENT_DEVICE, EBTServiceCode.ALT_PAYMENT_NO_DEVICE);

		// EBT_USER_DATA3: paypal verified
		String payerStatus = payPalPg.getPayerStatus();
		requestMap.put(LPTransactionProperty.EBT_USER_DATA3, payerStatus);

		// EBT_USER_DATA4: paypal email from PG
		requestMap.put(LPTransactionProperty.EBT_USER_DATA4, payPalPg.getPayerEmail());

		// EBT_USER_DATA8: PAYPAL
		requestMap.put(LPTransactionProperty.EBT_USER_DATA8, ACIConstants.ALT_PMT_TYPE_PAYPAL);
	}
	
	protected void populateOneYearExpireDate(LocalDateTime date, Map<LPTransactionProperty, String> requestMap) {
		String month = Integer.toString(date.getMonth().getValue());
		String year = Integer.toString(date.getYear());
		requestMap.put(LPTransactionProperty.CARD_EXP_DT, (month.length() == 1 ? "0" + month : month) + year.substring(2));
	}
	
	private void populateAltPayData(FraudRequest order, DigitalWalletTender altPayPg, 
			Map<LPTransactionProperty, String> requestMap) {

		// MOP_TYPE_CD, TOKEN_ID, ACCT_NUM, CARD_EXP_DT, CARD_SEC_IND_CD,
		// RSP_CD, RSP_AVS_CD, RSP_SEC_CD, EBT_Service
		// EBT_USER_DATA3 (paypal status), EBT_USER_DATA4 (paypal email)
		// EBT_USER_DATA8 (paypal)

		requestMap.put(LPTransactionProperty.MOP_TYPE_CD, ACIConstants.MethodOfPaymentType.PAYPAL.code());

		// ACCT_NUM -> paypal payer ID
		requestMap.put(LPTransactionProperty.ACCT_NUM, altPayPg.getPaymentMethodNonce());

		// CARD_EXP_DT -> for paypal, today's date + 1 year
		populateOneYearExpireDate(LocalDateTime.now().plusYears(1), requestMap);

		// CARD_SEC_IND_CD -> 0
		requestMap.put(LPTransactionProperty.CARD_SEC_IND_CD, LPTransactionProperty.CARD_SEC_IND_CD.defaultValue());

		boolean approved = false;
		if (altPayPg.getAuthorizationDtls() != null) {
			// RSP_CD: 00=Approved, 05=Declined, 96=Error
			// we don't currently seem to get a differentiation between Declined and Error
			// from the AEOPayPalProcessor
			// for now, just use Decline
			if (altPayPg.getAuthorizationDtls().isTransactionSuccess()) {
				approved = true;
				requestMap.put(LPTransactionProperty.RSP_CD, ACIConstants.AuthResponseCode.APPROVE.code());
			} else {
				requestMap.put(LPTransactionProperty.RSP_CD, ACIConstants.AuthResponseCode.DECLINE.code());
			}
		}

		// PayPal currently does not return AVS data
		// RSP_AVS_CD
		requestMap.put(LPTransactionProperty.RSP_AVS_CD, ACIConstants.AVSResponse.AVS_SYS_UNAVAIL.code());

		// RSP_SEC_CD: this is CVV, we don't have this
		requestMap.put(LPTransactionProperty.RSP_SEC_CD, ACIConstants.CINResponse.CIN_NOT_PROCESSED.code());
		
		populateDevicedataCode(approved, order.getCustomerOrder().getDeviceData(), requestMap, 
				EBTServiceCode.ALT_PAYMENT_DEVICE, EBTServiceCode.ALT_PAYMENT_NO_DEVICE);

		// EBT_USER_DATA3: paypal verified
		requestMap.put(LPTransactionProperty.EBT_USER_DATA3, "payerStatus");

		// EBT_USER_DATA4: paypal email from PG
		requestMap.put(LPTransactionProperty.EBT_USER_DATA4, "xxx@gmail.com");

		// EBT_USER_DATA8: PAYPAL
		requestMap.put(LPTransactionProperty.EBT_USER_DATA8, ACIConstants.ALT_PMT_TYPE_PAYPAL);
	}
	
	private void populateGiftCardsData(FraudRequest order, List<GiftCardTender> giftCardPgs,
			Map<LPTransactionProperty, String> requestMap) {

		List<GiftCardTender> sortedGcPgs = null;
		if (giftCardPgs.size() > 1) {
			// sort gift card payment groups by amount
			Comparator<GiftCardTender> gcComparator = Comparator.comparing(GiftCardTender::getProcessedAmount,
					Comparator.reverseOrder());
			sortedGcPgs = new ArrayList<>(giftCardPgs);
			sortedGcPgs.sort(gcComparator);
		} else {
			sortedGcPgs = giftCardPgs;
		}

		GiftCardTender primaryGcPg = sortedGcPgs.get(0);

		// MOP_TYPE_CD, TOKEN_ID, ACCT_NUM, CARD_EXP_DT, CARD_SEC_IND_CD,
		// RSP_CD, RSP_AVS_CD, RSP_SEC_CD, EBT_Service

		requestMap.put(LPTransactionProperty.MOP_TYPE_CD, ACIConstants.MethodOfPaymentType.GIFT_CARD.code());

		// ACCT_NUM -> gift card number
		requestMap.put(LPTransactionProperty.ACCT_NUM, primaryGcPg.getCardNumber());

		// CARD_EXP_DT -> for gift card, today's date + 1 year
		populateOneYearExpireDate(LocalDateTime.now().plusYears(1), requestMap);

		// CARD_SEC_IND_CD: 1 if we have PIN, otherwise 0
		requestMap.put(LPTransactionProperty.CARD_SEC_IND_CD,
				TransformerUtils.isNotBlank(primaryGcPg.getGiftCardPin()) ? "1" : 
					LPTransactionProperty.CARD_SEC_IND_CD.defaultValue());

		boolean approved = false;
		// RSP_CD: 00=Approved, 05=Declined, 96=Error
		// we don't currently seem to get a differentiation between Declined and Error
		// from the AEOGiftCardProcessor
		// Currently we only receive IxActionCode of 0 or 1 for GiftCards,
		// AEOAJBGiftCardResponseProcessor processes
		// 0 as success and 1 as decline.

		// NOTE: ProcValidateFraudProcessor will not allow Fraud Check if auth failed.
		// So at this time this will
		// always be APPROVE
		if (primaryGcPg.isTransactionSuccess()) {
			approved = true;
			requestMap.put(LPTransactionProperty.RSP_CD, ACIConstants.AuthResponseCode.APPROVE.code());
		} else {
			requestMap.put(LPTransactionProperty.RSP_CD, ACIConstants.AuthResponseCode.ERROR.code());
		}

		// GiftCard response does not contain AVS data
		// RSP_AVS_CD
		requestMap.put(LPTransactionProperty.RSP_AVS_CD, ACIConstants.AVSResponse.AVS_SYS_UNAVAIL.code());

		// RSP_SEC_CD: do we get CVV from IxOptions also?
		requestMap.put(LPTransactionProperty.RSP_SEC_CD, ACIConstants.CINResponse.CIN_NOT_PROCESSED.code());

		populateDevicedataCode(approved, order.getCustomerOrder().getDeviceData(), requestMap, 
				EBTServiceCode.ALT_PAYMENT_DEVICE, EBTServiceCode.ALT_PAYMENT_NO_DEVICE);

		// handle multiple gift cards
		if (sortedGcPgs.size() > 1) {

			// EBT_USER_DATA6 (split payment value), EBT_USER_DATA7 (split payment acct num)
			// EBT_USER_DATA8 (GIFT_CARD)
			StringBuilder paymentAcctString = new StringBuilder();
			StringBuilder paymentValueString = new StringBuilder();
			for (int i = 0; i < sortedGcPgs.size(); i++) {
				GiftCardTender gcPg = sortedGcPgs.get(i);
				if (i > 0) {
					paymentAcctString.append("|");
					paymentValueString.append("|");
				}
				paymentAcctString.append(gcPg.getCardNumber());
				paymentValueString.append(TransformerUtils.cleanNumberString(gcPg.getProcessedAmount(), 2));
			}

			requestMap.put(LPTransactionProperty.EBT_USER_DATA6, paymentValueString.toString());
			requestMap.put(LPTransactionProperty.EBT_USER_DATA7, paymentAcctString.toString());
		}
		// always set payment type
		requestMap.put(LPTransactionProperty.EBT_USER_DATA8, ACIConstants.ALT_PMT_TYPE_GIFT_CARD);
	}
	
	private void populateSplitPaymentData(FraudRequest order, CreditDebitTender creditCardPg,
			List<GiftCardTender> giftCardPgs, Map<LPTransactionProperty, String> requestMap) {

		// do this like a credit card first, then we'll override and update as needed
		populateCreditCardData(order, creditCardPg, requestMap);

		// now handle the split payment fields, putting CC first

		StringBuilder paymentAcctString = new StringBuilder();
		StringBuilder paymentValueString = new StringBuilder();

		paymentAcctString.append(creditCardPg.getMaskedAccountNumber());
		paymentValueString.append(TransformerUtils.cleanNumberString(
				Double.toString(creditCardPg.getAuthorizationDtls().getAmount()), 2));

		// sort the gift cards
		List<GiftCardTender> sortedGcPgs = null;
		if (giftCardPgs.size() > 1) {
			// sort gift card payment groups by amount
			Comparator<GiftCardTender> gcComparator = Comparator.comparing(GiftCardTender::getProcessedAmount,
					Comparator.reverseOrder());
			sortedGcPgs = new ArrayList<>(giftCardPgs);
			sortedGcPgs.sort(gcComparator);
		} else {
			sortedGcPgs = giftCardPgs;
		}

		for (GiftCardTender gcPg : sortedGcPgs) {
			paymentAcctString.append("|");
			paymentValueString.append("|");
			paymentAcctString.append(gcPg.getCardNumber());
			paymentValueString.append(TransformerUtils.cleanNumberString(gcPg.getProcessedAmount(), 2));
		}

		requestMap.put(LPTransactionProperty.EBT_USER_DATA6, paymentValueString.toString());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA7, paymentAcctString.toString());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA8, ACIConstants.ALT_PMT_TYPE_GIFT_CARD);

	}

	@Override
	public boolean returnsItems() {
		return false;
	}

}
