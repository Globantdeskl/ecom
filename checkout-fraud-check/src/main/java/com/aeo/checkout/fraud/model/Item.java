package com.aeo.checkout.fraud.model;

import java.util.Date;

import lombok.Data;

@Data
public class Item {
	
	private int quantity;
	
	private String productClass;
	
	private String recipientEmail;
	
	private String recipientName;
	
	private String recipientMobile;
	
	private String senderEmail;
	
	private String senderName;
	
	private String giftMessage;
	
	private String giftCardAmount;
	
	private String eGifterOrderId;
	
	private String eGifterGiftId;

	private String amount;
	
	private String listPrice;
	
	private String catalogRefId;
	
	private Date pickupPromiseDate;
	
	private String productClassId;
	
	private String equityName;
	
	private String sizeDescDefault;
	
}
