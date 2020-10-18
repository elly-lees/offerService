package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 
 * @author alena.khvat
 *
 */
public class InternalDbException extends CustomOfferException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 562577872995185713L;

	/**
	 * 
	 */
	public InternalDbException() {
		super(CustomExceptionEnum.INTERNAL_DB_EXCEPTION.getCodeError(), CustomExceptionEnum.INTERNAL_DB_EXCEPTION.getMessageError(), null);
	}
	/**
	 * @param cause
	 */
	public InternalDbException(Exception cause) {
		super(CustomExceptionEnum.INTERNAL_DB_EXCEPTION.getCodeError(), CustomExceptionEnum.INTERNAL_DB_EXCEPTION.getMessageError(), cause);
	}

}
