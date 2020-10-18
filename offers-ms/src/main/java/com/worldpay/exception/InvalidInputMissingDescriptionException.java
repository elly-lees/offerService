package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * 
 * @author alena.khvat
 *
 */
public class InvalidInputMissingDescriptionException extends CustomOfferException  {
	
	/**
     * 
     */
    private static final long serialVersionUID = 2883604629468606781L;

    /**
	 * 
	 */
	public InvalidInputMissingDescriptionException() {
		super(CustomExceptionEnum.INVALID_INPUT_MISSING_DESCRIPTION_EXCEPTION.getCodeError(), CustomExceptionEnum.INVALID_INPUT_MISSING_DESCRIPTION_EXCEPTION.getMessageError(), null);
	}
	

}
