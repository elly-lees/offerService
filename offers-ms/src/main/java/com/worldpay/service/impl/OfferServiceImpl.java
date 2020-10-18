package com.worldpay.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldpay.model.OfferBean;
import com.worldpay.model.repository.Offer;
import com.worldpay.repository.OfferRepository;
import com.worldpay.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

   
    /* (non-Javadoc)
     * @see com.worldpay.service.OfferService#createOffer(com.worldpay.model.OfferBean)
     */
    @Override
    public int createOffer(OfferBean offer) {
        Offer o = new Offer().merchandName(offer.getMerchantName()).title(offer.getTitle())
                .description(offer.getDescription()).expireDate(offer.getExpireDate()).price(offer.getPrice())
                .currency(offer.getCurrency()).productId(offer.getProductId());
        int idOffer = offerRepository.createOffer(o);
        logger.debug("Offer with id  was created" + idOffer);
        return idOffer;

    }

   
    /* (non-Javadoc)
     * @see com.worldpay.service.OfferService#getOffers()
     */
    @Override
    public List<OfferBean> getOffers() {
        return offerRepository.getOffers().stream().map(offer -> {
            OfferBean o = new OfferBean();
            o.setIdOffer(offer.getIdOffer());
            o.setCancelDate(offer.getCancelDate());
            o.setCreateDate(offer.getCreateDate());
            o.setDescription(offer.getDescription());
            o.setExpireDate(offer.getExpireDate());
            o.setTitle(offer.getTitle());
            o.setUpdateDate(offer.getUpdateDate());
            o.setMerchantName(offer.getMerchantName());
            o.setPrice(offer.getPrice());
            o.setCurrency(offer.getCurrency());
            o.setProductId(offer.getProductId());
            return o;
        }).collect(Collectors.toList());
    }

   
    /* (non-Javadoc)
     * @see com.worldpay.service.OfferService#cancelOffer(int)
     */
    @Override
    public boolean cancelOffer(int idOffer) {
        return offerRepository.cancelOffer(idOffer);

    }

}
