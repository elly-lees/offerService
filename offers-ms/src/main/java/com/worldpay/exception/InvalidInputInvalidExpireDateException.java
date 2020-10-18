package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * 
 * @author alena.khvat
 *
 */
public class InvalidInputInvalidExpireDateException extends CustomOfferException  {
	

	/**
     * 
     */
    private static final long serialVersionUID = 4479119649067873021L;

    /**
	 * 
	 */
	public InvalidInputInvalidExpireDateException() {
		super(CustomExceptionEnum.INVALID_INPUT_INVALID_EXPIRE_DATE_EXCEPTION.getCodeError(), CustomExceptionEnum.INVALID_INPUT_INVALID_EXPIRE_DATE_EXCEPTION.getMessageError(), null);
	}
	

}
