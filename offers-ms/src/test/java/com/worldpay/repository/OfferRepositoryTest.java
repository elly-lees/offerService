package com.worldpay.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldpay.model.repository.Offer;
import com.worldpay.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class OfferRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OfferRepository repository;
    @MockBean
    ServletContext context;

    @Test
    public void testPersistOfferSuccess() {
        Offer objectToCreate = TestUtils.createOfferDTO();
        int idOffer = repository.createOffer(objectToCreate);
        assertNotEquals(0, idOffer);
        Offer retrievedObject = repository.getOfferById(idOffer);
        assertNotNull(retrievedObject);

        assertEquals(objectToCreate.getTitle(), retrievedObject.getTitle());
        assertEquals(objectToCreate.getDescription(), retrievedObject.getDescription());
        assertEquals(objectToCreate.getMerchantName(), retrievedObject.getMerchantName());
        assertEquals(objectToCreate.getPrice(), retrievedObject.getPrice());
        assertEquals(objectToCreate.getCurrency(), retrievedObject.getCurrency());
        assertEquals(objectToCreate.getProductId(), retrievedObject.getProductId());

        boolean cancelled = repository.cancelOffer(idOffer);
        assertTrue(cancelled);
        retrievedObject = repository.getOfferById(idOffer);
        assertNotNull(retrievedObject);
        assertNotNull(retrievedObject.getCancelDate());
    }

    @Test
    public void testRetrieveOfferExpiredSuccess() {
        Offer objectToCreate = TestUtils.createOfferDTO();
        objectToCreate.setExpireDate(TestUtils.createDateYesterday());
        int idOffer = repository.createOffer(objectToCreate);
        assertNotEquals(0, idOffer);
        List<Offer> offerList = repository.getOffers();
        assertEquals(0, offerList.size());

        boolean cancelled = repository.cancelOffer(idOffer);
        assertFalse(cancelled);

    }

}
