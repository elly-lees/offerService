package com.worldpay.controller;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldpay.constants.MessageConstants;
import com.worldpay.exception.InvalidInputInvalidExpireDateException;
import com.worldpay.exception.InvalidInputInvalidPriceException;
import com.worldpay.exception.InvalidInputMissingCurrencyException;
import com.worldpay.exception.InvalidInputMissingDescriptionException;
import com.worldpay.exception.InvalidInputMissingPriceException;
import com.worldpay.exception.InvalidInputMissingProductException;
import com.worldpay.exception.InvalidInputMissingTitleException;
import com.worldpay.model.wrapper.RequestOfferWrapper;
import com.worldpay.model.wrapper.ResponseCreateOfferWrapper;
import com.worldpay.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application.properties")
public class CreateOffersIntTest {

    @Autowired
    private OfferController controller;
    
   
    

    @Test
    public void testCreateOffer() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        ResponseCreateOfferWrapper response = controller.createOffer(rew);
        Assert.assertEquals(MessageConstants.RESULT_OK, response.getResultCode());
        Assert.assertEquals(MessageConstants.RESULT_DESC_OK_CREATE_OFFER, response.getDescription());
        controller.cancelOffer(response.getIdOffer());

    }

   

    @Test(expected = InvalidInputMissingTitleException.class)
    public void testCreateOfferTitleEmpty() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setTitle("");
        controller.createOffer(rew);

    }

    @Test(expected = InvalidInputMissingTitleException.class)
    public void testCreateOfferTitleNull() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setTitle(null);
        controller.createOffer(rew);
    }

    @Test(expected = InvalidInputMissingDescriptionException.class)
    public void testCreateOfferDescriptionEmpty() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setDescription("");
        controller.createOffer(rew);

    }

    @Test(expected = InvalidInputMissingDescriptionException.class)
    public void testCreateOfferDescriptionNull() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setDescription(null);
        controller.createOffer(rew);
    }

    @Test(expected = InvalidInputInvalidExpireDateException.class)
    public void testCreateOfferExpireDateToday() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setExpireDate(TestUtils.createDateToday());
        controller.createOffer(rew);
    }

    @Test(expected = InvalidInputInvalidExpireDateException.class)
    public void testCreateOfferExpireDateInThePast() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setExpireDate(TestUtils.createDateYesterday());
        controller.createOffer(rew);
    }
    @Test(expected = InvalidInputMissingPriceException.class)
    public void testCreateOfferPriceNull() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setPrice(null);
        controller.createOffer(rew);
    }
    @Test(expected = InvalidInputInvalidPriceException.class)
    public void testCreateOfferPriceNegative() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setPrice(new BigDecimal("-1"));
        controller.createOffer(rew);
    }
    @Test(expected = InvalidInputMissingCurrencyException.class)
    public void testCreateOfferCurrencyNull() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setCurrency(null);
        controller.createOffer(rew);
    }
    @Test(expected = InvalidInputMissingProductException.class)
    public void testCreateOfferProductNull() {
        RequestOfferWrapper rew = TestUtils.createOfferRequest();
        rew.setProductId(0);
        controller.createOffer(rew);
    }

}
