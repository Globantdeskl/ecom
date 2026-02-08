package data;

import com.aeo.framework.model.FraudItem;
import com.aeo.framework.model.FraudRequest;
import com.aeo.framework.model.TaxableItems;
import com.aeo.framework.model.FraudAuthorizationDetails;
import com.aeo.framework.model.order.CreditDebitTender;
import com.aeo.framework.model.order.CustomerAddress;
import com.aeo.framework.model.order.CustomerAddresses;
import com.aeo.framework.model.order.CustomerBillingDetail;
import com.aeo.framework.model.order.CustomerEmail;
import com.aeo.framework.model.order.CustomerEmails;
import com.aeo.framework.model.order.CustomerInfo;
import com.aeo.framework.model.order.CustomerOrder;
import com.aeo.framework.model.order.CustomerPhoneNumber;
import com.aeo.framework.model.order.CustomerPhoneNumbers;
import com.aeo.framework.model.order.CustomerShippingDetail;
import com.aeo.framework.model.order.OrderMetaData;
import com.aeo.framework.model.order.PaymentMethod;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FraudDataProviderClass {

    @DataProvider(name = "fraud-data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { fraudOrder( "7.00") }
        };
    }

    public FraudRequest fraudOrder(String shippingCost){

        Faker usFaker = new Faker(Locale.US);
        FraudRequest fraudRequest = new FraudRequest();
        Address address = usFaker.address();
        String state = address.stateAbbr();
        List<FraudItem> fraudItemList = new ArrayList<>();
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(getPaymentMethod(40.96));

        fraudItemList.add(getItemForFraud("33.96", "49.95", 1));
        fraudRequest.setOrderId(usFaker.numerify("o70373499"));
        fraudRequest.setWebsite("https://sit.aezone.com/us/en");

        fraudRequest.setOrderTimeZone("-5");
        fraudRequest.setFreightAmount(shippingCost);
        fraudRequest.setAmount("40.96");
        fraudRequest.setResubmittedOrder(true);
        fraudRequest.setCustomerOrder(getCustomerOrder(usFaker));
        fraudRequest.setCustomerBillingDetail(getCustomerBillingDetail(usFaker));
        fraudRequest.setCustomerShippingDetail(getCustomerShippingDetail(usFaker));
        fraudRequest.setOrderMetaData(getOrderMetaData());
        fraudRequest.setAppliedCoupons(new ArrayList<>());
        fraudRequest.setItems(fraudItemList);

        fraudRequest.setPaymentMethods(paymentMethods);

        return fraudRequest;
    }

    private CustomerOrder getCustomerOrder(Faker faker){
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerOrderId("0000881402");
        customerOrder.setCurrencyCode("USD");
        customerOrder.setActivityDate("2020-04-06 14:45:58");
        customerOrder.setCarrierCode("STD");
        customerOrder.setFreeReturnLabel(true);
        customerOrder.setDiscount("0.0");
        customerOrder.setDeviceData(null);
        customerOrder.setFreeReturnLabelCode("USA");
        customerOrder.setFreeGiftReceipt(false);
        customerOrder.setProfileId(faker.numerify("testugp#########"));
        customerOrder.setSourceApplication("ATG");
        customerOrder.setChannel("WEB");
        customerOrder.setIpAddress("162.250.148.187");
        customerOrder.setProfileLoginDate("2019-10-04");
        return customerOrder;
    }

    private CustomerBillingDetail getCustomerBillingDetail(Faker faker){
        CustomerBillingDetail customerBillingDetail = new CustomerBillingDetail();
        CustomerInfo customerInfo = new CustomerInfo();

        CustomerEmails emails = new CustomerEmails();
        List<CustomerEmail> emailList = new ArrayList<>();
        CustomerEmail customerEmail = new CustomerEmail();

        List<CustomerPhoneNumber> customerPhoneNumberList = new ArrayList<>();
        CustomerPhoneNumber phone = new CustomerPhoneNumber();
        CustomerPhoneNumbers phones = new CustomerPhoneNumbers();

        CustomerAddress customerAddress = new CustomerAddress();
        List<CustomerAddress> customerAddressList = new ArrayList<>();
        CustomerAddresses addresses = new CustomerAddresses();

        customerInfo.setFirstName(faker.name().firstName());
        customerInfo.setLastName(faker.name().lastName());
        customerBillingDetail.setCustomerInfo(customerInfo);

        customerEmail.setEmailAddress(faker.bothify("????##@gmail.com"));
        emailList.add(customerEmail);
        emails.setEmail(emailList);
        customerBillingDetail.setEmails(emails);

        phone.setPhoneNumber(faker.phoneNumber().phoneNumber());
        customerPhoneNumberList.add(phone);
        phones.setPhone(customerPhoneNumberList);
        customerBillingDetail.setPhones(phones);

        customerAddressList.add(getCustomerAddress(faker));
        addresses.setAddress(customerAddressList);
        customerBillingDetail.setAddresses(addresses);
        return customerBillingDetail;
    }

    private CustomerAddress getCustomerAddress(Faker faker){
        CustomerAddress customerAddress = new CustomerAddress();

        customerAddress.setAddress1(faker.address().streetAddress());
        customerAddress.setAddress2(faker.address().secondaryAddress());
        customerAddress.setCity(faker.address().city());
        customerAddress.setStateName(faker.address().state());
        customerAddress.setCountryCode(faker.address().countryCode());
        customerAddress.setPostalCode(faker.address().zipCode());

        return customerAddress;
    }

    private CustomerShippingDetail getCustomerShippingDetail(Faker faker){
        CustomerShippingDetail customerShippingDetail = new CustomerShippingDetail();

        customerShippingDetail.setFirstName(faker.name().firstName());
        customerShippingDetail.setLastName(faker.name().lastName());
        customerShippingDetail.setAddress(getCustomerAddress(faker));

        return customerShippingDetail;
    }

    private OrderMetaData getOrderMetaData(){
        OrderMetaData orderMetaData = new OrderMetaData();

        orderMetaData.setUserType("registered");
        orderMetaData.setHasPLCCPayment(false);
        orderMetaData.setBopisOrder(false);
        orderMetaData.setVGCOrder(false);

        return orderMetaData;
    }

    private FraudItem getItemForFraud(String amount, String listPrice, int quantity){
        FraudItem item = new FraudItem();
        item.setQuantity(quantity);
        item.setProductClass("032");
        item.setAmount(amount);
        item.setListPrice(listPrice);
        item.setCatalogRefId("0026752907");
        item.setProductClassId("0326");
        item.setEquityName("AE Super Soft X4 High-Waisted Jegging");
        item.setSizeDescDefault("10 Regular");
        return item;
    }

    private PaymentMethod getPaymentMethod(Double chargeAmount){
        PaymentMethod paymentMethod = new PaymentMethod();
        CreditDebitTender creditDebitTender = new CreditDebitTender();
        creditDebitTender.setMaskedAccountNumber("401200******7777");
        creditDebitTender.setCreditCardExpDate("11/2022");
        FraudAuthorizationDetails authDetails = new FraudAuthorizationDetails();
        authDetails.setTransactionSuccess(true);
        authDetails.setAmount(chargeAmount);
        authDetails.setCvvResponse("M");
        authDetails.setAvsCode("Y");
        creditDebitTender.setAuthorizationDtls(authDetails);
        creditDebitTender.setCardToken("1508372185067777");
        creditDebitTender.setCardVerificationNumber("OK891C");
        paymentMethod.setCreditDebitTender(creditDebitTender);
        return paymentMethod;
    }

}
