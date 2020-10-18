package com.worldpay.model.wrapper;

import com.worldpay.exception.CustomOfferException;

/**
 * @author alena.khvat
 *
 */
public class GenericResponseWrapper {
    private String resultCode;
    private String description;

    /**
     * 
     */
    public GenericResponseWrapper() {
        super();
    }

    /**
     * @param e
     */
    public GenericResponseWrapper(CustomOfferException e) {
        super();
        this.resultCode = e.getErrorCode();
        this.description = e.getMessage();
    }

    /**
     * @return
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * @param resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
