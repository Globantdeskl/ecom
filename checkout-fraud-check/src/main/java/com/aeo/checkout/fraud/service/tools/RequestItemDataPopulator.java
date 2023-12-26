package com.aeo.checkout.fraud.service.tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aeo.checkout.fraud.model.FraudRequest;
import com.aeo.checkout.fraud.model.Item;
import com.aeo.checkout.fraud.model.aci.ACIConstants;
import com.aeo.checkout.fraud.model.aci.LPTransactionProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RequestItemDataPopulator implements FraudRequestDataPopulator {

	@Override
	public void populate(FraudRequest order, Map<LPTransactionProperty, String> requestMap) {
		populateAndGetItemData(order, requestMap);
	}
	
	public List<Map<LPTransactionProperty, String>> populateAndGetItemData(FraudRequest order,
			Map<LPTransactionProperty, String> requestMap) {

		// PROD_DEL_CD, OI_REPEAT, EBT_USER_x (lines in order),
		// ITEM_QTY[N], ITEM_AMT[N], ITEM_CST_AMT[N], ITEM_DESC[N], ITEM_COMM_CD[N]

		List<Item> cis = order.getItems();

		requestMap.put(LPTransactionProperty.OI_REPEAT, Integer.toString(cis.size()));

		// per clarification from the fraud team, need DATA11 to be total quantity
		long totalQty = cis.stream().collect(Collectors.summingLong(c -> c.getQuantity()));
		requestMap.put(LPTransactionProperty.EBT_USER_DATA11, Long.toString(totalQty));

		// need to iterate through commerce items and create entries for each, but our
		// map's key is LPTransactionProperty and we don't have enums for each N value,
		// so we'll return a structure that will need to be merged into the resulting
		// final Map<String, String>

		List<Map<LPTransactionProperty, String>> itemList = new ArrayList<>();

		// as we loop through commerce items, keep track of types for the PROD_DEL_CD value
		boolean hasHardgood = false;
		boolean hasVirtualGC = false;

		// track item sizes for output in EBT_USER_DATA19
		List<String> itemSizes = new ArrayList<>();

		for (Item ci : cis) {
			// only VGC have recipient email
			if (TransformerUtils.isNotBlank(ci.getRecipientEmail())) {
				hasVirtualGC = true;
				addVGCData(ci, requestMap);
			} else {
				hasHardgood = true;
			}

			Map<LPTransactionProperty, String> itemMap = createItemMap(ci);
			
			if(TransformerUtils.isNotBlank(ci.getSizeDescDefault())) {
				itemSizes.add(ci.getSizeDescDefault());
			}

			if (order.getOrderMetaData().isBopisOrder()
					&& ci.getPickupPromiseDate() != null) {
				addBopisDetails(ci, itemMap, requestMap);
			}
			
			itemList.add(itemMap);
		}
		
		addGoodsType(hasHardgood, hasVirtualGC, requestMap);

		// SKU sizes
		requestMap.put(LPTransactionProperty.EBT_USER_DATA19, 
				TransformerUtils.collectionToDelimitedString(itemSizes, 
						LPTransactionProperty.EBT_USER_DATA19.getMax()));
		
		return itemList;
	}
	
	private Map<LPTransactionProperty, String> createItemMap(Item ci) {
		
		Map<LPTransactionProperty, String> itemMap = new EnumMap<>(LPTransactionProperty.class);
		
		StringBuilder prodCd = new StringBuilder();
		prodCd.append(ci.getProductClass());
		prodCd.append("-");
		prodCd.append(ci.getProductClassId());
		
		// qty 1 is represented as 10000, oddly enough
		itemMap.put(LPTransactionProperty.ITEM_QTY, 
				TransformerUtils.cleanNumberString(Long.toString(ci.getQuantity()), 4));
		itemMap.put(LPTransactionProperty.ITEM_AMT, 
				TransformerUtils.cleanNumberString(ci.getAmount(), 2));
		// unit price of 2.00 is presented as 20000
		itemMap.put(LPTransactionProperty.ITEM_CST_AMT, 
				TransformerUtils.cleanNumberString(ci.getListPrice(), 4));
		itemMap.put(LPTransactionProperty.ITEM_COMM_CD, ci.getCatalogRefId());
		itemMap.put(LPTransactionProperty.ITEM_PROD_CD, prodCd.toString());
		itemMap.put(LPTransactionProperty.ITEM_DESC, ci.getEquityName());
		
		return itemMap;
	}
	
	private void addVGCData(Item ci, Map<LPTransactionProperty, String> requestMap) {
		requestMap.put(LPTransactionProperty.EBT_USER_DATA12, ci.getRecipientEmail());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA13, ci.getRecipientName());
		requestMap.put(LPTransactionProperty.EBT_USER_DATA21, ci.getGiftMessage());
		requestMap.put(LPTransactionProperty.SHIP_EMAIL, ci.getRecipientEmail());
		requestMap.put(LPTransactionProperty.SHIP_HOME_PHONE, ci.getRecipientMobile());
	}
	
	private void addGoodsType(boolean hasHardgoods, boolean hasVGCs, Map<LPTransactionProperty, String> requestMap) {
		if (hasHardgoods) {
			if (hasVGCs) {
				requestMap.put(LPTransactionProperty.PROD_DEL_CD, ACIConstants.DIGITAL_N_PHYSICAL_GOODS);
			} else {
				requestMap.put(LPTransactionProperty.PROD_DEL_CD, ACIConstants.PHYSICAL_GOODS);
			}
		} else {
			requestMap.put(LPTransactionProperty.PROD_DEL_CD, ACIConstants.DIGITAL_GOODS);
		}
	}
	
	private void addBopisDetails(Item ci, Map<LPTransactionProperty, String> itemMap, 
			Map<LPTransactionProperty, String> requestMap) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(ci.getPickupPromiseDate());
		LocalDate todayLocalDate = LocalDate.now();
		LocalDate tomorrowLocalDate = todayLocalDate.plusDays(1);
		LocalDate promiseLocalDate = LocalDate.of(cal.get(Calendar.YEAR), 
				(cal.get(Calendar.MONTH) + 1), cal.get(Calendar.DATE));

		if (todayLocalDate.compareTo(promiseLocalDate) == 0
				|| tomorrowLocalDate.compareTo(promiseLocalDate) == 0) {
			itemMap.put(LPTransactionProperty.ITEM_SHIP_NO, ACIConstants.PICKUP_TODAY);
			requestMap.put(LPTransactionProperty.EBT_USER_DATA22, ACIConstants.YES);
		} else {
			itemMap.put(LPTransactionProperty.ITEM_SHIP_NO, ACIConstants.SHIP_TO_STORE);
		}
		
		if(!ACIConstants.YES.equals(requestMap.get(LPTransactionProperty.EBT_USER_DATA22))) {
			requestMap.put(LPTransactionProperty.EBT_USER_DATA22, ACIConstants.NO);
		}
	}

	@Override
	public boolean returnsItems() {
		return true;
	}

}
