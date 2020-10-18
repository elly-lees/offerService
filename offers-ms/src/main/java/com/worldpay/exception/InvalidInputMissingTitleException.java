package com.worldpay.exception;

import com.worldpay.enumerators.CustomExceptionEnum;

/** 
 * 
 * @author alena.khvat
 *
 */
public class InvalidInputMissingTitleException extends CustomOfferException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7045913783121393859L;

	/**
	 * 
	 */
	public InvalidInputMissingTitleException() {
		super(CustomExceptionEnum.INVALID_INPUT_MISSING_TITLE_EXCEPTION.getCodeError(), CustomExceptionEnum.INVALID_INPUT_MISSING_TITLE_EXCEPTION.getMessageError(), null);
	}
	

}
