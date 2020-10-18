package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * 
 * @author alena.khvat
 *
 */
public class InvalidInputMissingPriceException extends CustomOfferException  {
	

	/**
     * 
     */
    private static final long serialVersionUID = -4392069150477330113L;

    /**
	 * 
	 */
	public InvalidInputMissingPriceException() {
		super(CustomExceptionEnum.INVALID_INPUT_MISSING_PRICE_EXCEPTION.getCodeError(), CustomExceptionEnum.INVALID_INPUT_MISSING_PRICE_EXCEPTION.getMessageError(), null);
	}
	

}
