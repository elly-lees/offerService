package com.worldpay.exception;

/**
 * @author alena.khvat
 *
 */
public class CustomOfferException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 562577872995185713L;
	protected final String errorCode;
	
	/**
	 * @param errorCode
	 */
	public CustomOfferException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}
	

	/**
	 * @param errorCode
	 * @param message
	 * @param cause
	 */
	public CustomOfferException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}


	/**
	 * @return
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	
}
