package com.worldpay.service;

import java.util.List;

import com.worldpay.model.OfferBean;

public interface OfferService {

    /**
     * @param offer
     * @return
     */
    public int createOffer(OfferBean offer);

    /**
     * @return
     */
    public List<OfferBean> getOffers();

    /**
     * @param idOffer
     * @return
     */
    public boolean cancelOffer(int idOffer);

}
