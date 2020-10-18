package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * 
 * @author alena.khvat
 *
 */
public class InvalidInputMissingProductException extends CustomOfferException  {
	

	/**
     * 
     */
    private static final long serialVersionUID = 3667180183097696853L;

    /**
	 * 
	 */
	public InvalidInputMissingProductException() {
		super(CustomExceptionEnum.INVALID_INPUT_MISSING_PRODUCT_EXCEPTION.getCodeError(), CustomExceptionEnum.INVALID_INPUT_MISSING_PRODUCT_EXCEPTION.getMessageError(), null);
	}
	

}
