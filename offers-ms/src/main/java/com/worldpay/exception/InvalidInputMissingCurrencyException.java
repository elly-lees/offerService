package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * 
 * @author alena.khvat
 *
 */
public class InvalidInputMissingCurrencyException extends CustomOfferException  {
	
	/**
     * 
     */
    private static final long serialVersionUID = -2257408586673532191L;

    /**
	 * 
	 */
	public InvalidInputMissingCurrencyException() {
		super(CustomExceptionEnum.INVALID_INPUT_MISSING_CURRENCY_EXCEPTION.getCodeError(), CustomExceptionEnum.INVALID_INPUT_MISSING_CURRENCY_EXCEPTION.getMessageError(), null);
	}
	

}
