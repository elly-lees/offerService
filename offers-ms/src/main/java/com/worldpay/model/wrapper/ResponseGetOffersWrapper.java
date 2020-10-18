package com.worldpay.model.wrapper;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author alena.khvat
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseGetOffersWrapper extends GenericResponseWrapper implements Serializable{
	private static final long serialVersionUID = 4700220365109195371L;
	
	private List<OfferOutput> offers;

    public List<OfferOutput> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferOutput> offers) {
        this.offers = offers;
    }

	

}
