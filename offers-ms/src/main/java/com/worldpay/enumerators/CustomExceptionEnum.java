package com.worldpay.enumerators;

/**
 * 
 * @author alena.khvat
 *
 */
public enum CustomExceptionEnum {
	INTERNAL_GENERIC_EXCEPTION("1", "System error."),
	INTERNAL_DB_EXCEPTION("2", "Database error."),
	
	INVALID_INPUT_MISSING_TITLE_EXCEPTION("3", "The title is mandatory."),
	INVALID_INPUT_MISSING_MERCHANT_EXCEPTION("4", "The merchant is mandatory."),
	INVALID_INPUT_INVALID_EXPIRE_DATE_EXCEPTION("5", "The expiration date should be in the future."),
	INVALID_INPUT_MISSING_DESCRIPTION_EXCEPTION("6", "The description is mandatory."),
	INVALID_INPUT_MISSING_PRICE_EXCEPTION("7", "The price is mandatory."),
	INVALID_INPUT_INVALID_PRICE_EXCEPTION("8", "The price is mandatory."),
	INVALID_INPUT_MISSING_CURRENCY_EXCEPTION("9", "The currency is mandatory."),
	INVALID_INPUT_MISSING_PRODUCT_EXCEPTION("10", "The product id is mandatory."),
	CANNOT_FIND_OFFER_EXCEPTION("11", "The offer doesn't exist or expired.");
	
	private String codeError;
	private String messageError;
	
	/**
	 * @param codeError
	 * @param messageError
	 */
	private CustomExceptionEnum(String codeError, String messageError) {
		this.codeError = codeError;
		this.messageError = messageError;
	}
	/**
	 * @return
	 */
	public String getCodeError() {
		return codeError;
	}
	/**
	 * @return
	 */
	public String getMessageError() {
		return messageError;
	}
	
}
