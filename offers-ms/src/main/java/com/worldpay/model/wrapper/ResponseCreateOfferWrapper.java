package com.worldpay.model.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author alena.khvat
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCreateOfferWrapper extends GenericResponseWrapper implements Serializable{
	
	/**
     * 
     */
    private static final long serialVersionUID = -1992179197314413671L;
    private int idOffer;
    public int getIdOffer() {
        return idOffer;
    }
    public void setIdOffer(int idOffer) {
        this.idOffer = idOffer;
    }

   
  

	

}
