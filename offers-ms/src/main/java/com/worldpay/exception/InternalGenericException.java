package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * @author alena.khvat
 *
 */
public class InternalGenericException extends CustomOfferException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 562577872995185713L;

	/**
	 * 
	 */
	public InternalGenericException() {
		super(CustomExceptionEnum.INTERNAL_GENERIC_EXCEPTION.getCodeError(), CustomExceptionEnum.INTERNAL_GENERIC_EXCEPTION.getMessageError(), null);
	}
	/**
	 * @param cause
	 */
	public InternalGenericException(Exception cause) {
		super(CustomExceptionEnum.INTERNAL_GENERIC_EXCEPTION.getCodeError(), CustomExceptionEnum.INTERNAL_GENERIC_EXCEPTION.getMessageError(), cause);
	}

}
