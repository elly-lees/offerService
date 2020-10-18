package com.worldpay.repository.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.worldpay.model.repository.Offer;
import com.worldpay.repository.OfferRepository;

/**
 * @author alena.khvat
 *
 */
@Repository
@Transactional
public class OfferRepositoryImpl implements OfferRepository {

    
    @PersistenceContext
    private EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private LocalDateTime defaultExpireDate = LocalDate.parse(DEFAULT_EXPIRE_DATE).atStartOfDay();


    public int createOffer(Offer offer) {
        Offer offerCreated = persistOffer(offer);
        logger.info("repository createOffer entity - " + offer);
        
        return offerCreated.getIdOffer();
    }

    public List<Offer> getOffers() {
        logger.info("repository getOffers entity");
        Query q = entityManager.createQuery(
                "SELECT p FROM Offer p where p.expireDate > current_timestamp and p.cancelDate is null order by p.createDate desc");
        q.setFirstResult(0);
        List<Offer> listOffers = q.getResultList();

        return listOffers;
    }

    private Offer persistOffer(Offer offer) {
        LocalDateTime currentDate = LocalDateTime.now();
        offer.setCreateDate(currentDate);
        offer.setUpdateDate(currentDate);
        if (offer.getExpireDate() == null) {
            offer.setExpireDate(defaultExpireDate);
        }
        entityManager.persist(offer);
        entityManager.flush();
        return offer;
    }

    public boolean cancelOffer(int idOffer) {
        logger.info("repository cancelOffer " + idOffer);
        LocalDateTime currentDate = LocalDateTime.now();
        boolean result = true;
        Query q = entityManager.createQuery("SELECT p FROM Offer p WHERE p.idOffer = :idOffer and p.expireDate > current_timestamp and p.cancelDate is null");
        q.setFirstResult(0);
        q.setMaxResults(1);
        q.setParameter("idOffer", idOffer);
        List<Offer> list = q.getResultList();
        if (list == null || list.size() == 0) {
            result = false;
        } else {
            Offer offer = list.get(0);
            offer.setCancelDate(currentDate);
            entityManager.persist(offer);
        }

        return result;
    }
    public Offer getOfferById(int idOffer) {
        logger.info("repository getOfferById entity");
        Query q = entityManager.createQuery(
                "SELECT p FROM Offer p where p.idOffer =:idOffer");
        q.setFirstResult(0);
        q.setParameter("idOffer", idOffer);
        Offer offer = (Offer) q.getSingleResult();

        return offer;
    }


}
