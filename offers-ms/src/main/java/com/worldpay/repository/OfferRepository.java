package com.worldpay.repository;

import java.util.List;

import com.worldpay.model.repository.Offer;

/**
 * @author alena.khvat
 *
 */
public interface OfferRepository {

    String DEFAULT_EXPIRE_DATE = "9999-12-31";

    int createOffer(Offer offer);

    List<Offer> getOffers();

    boolean cancelOffer(int idOffer);

    Offer getOfferById(int idOffer);

}
