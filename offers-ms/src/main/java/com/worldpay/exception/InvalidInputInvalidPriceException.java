package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * 
 * @author alena.khvat
 *
 */
public class InvalidInputInvalidPriceException extends CustomOfferException  {
    

   
    /**
     * 
     */
    private static final long serialVersionUID = -2617061350209219374L;

    /**
     * 
     */
    public InvalidInputInvalidPriceException() {
        super(CustomExceptionEnum.INVALID_INPUT_INVALID_PRICE_EXCEPTION.getCodeError(), CustomExceptionEnum.INVALID_INPUT_INVALID_PRICE_EXCEPTION.getMessageError(), null);
    }
    

}
