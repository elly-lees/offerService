package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * @author alena.khvat
 *
 */
public class CannotFindOfferException extends CustomOfferException  {

	
	/**
     * 
     */
    private static final long serialVersionUID = -4646274740829536494L;
    /**
	 * 
	 */
	public CannotFindOfferException() {
		super(CustomExceptionEnum.CANNOT_FIND_OFFER_EXCEPTION.getCodeError(), CustomExceptionEnum.CANNOT_FIND_OFFER_EXCEPTION.getMessageError(), null);
	}
	/**
	 * @param cause
	 */
	public CannotFindOfferException(Exception cause) {
		super(CustomExceptionEnum.CANNOT_FIND_OFFER_EXCEPTION.getCodeError(), CustomExceptionEnum.CANNOT_FIND_OFFER_EXCEPTION.getMessageError(), cause);
	}

}
