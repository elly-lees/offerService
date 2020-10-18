package com.worldpay.controller;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldpay.constants.MessageConstants;
import com.worldpay.exception.CannotFindOfferException;
import com.worldpay.model.wrapper.OfferOutput;
import com.worldpay.model.wrapper.ResponseGetOffersWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application.properties")
@Sql(scripts="INSERT_DML.sql")
public class GetCancelOffersIntTest {

    @Autowired
    private OfferController controller;

    @Test
    public void testGetOffers() {
        ResponseGetOffersWrapper response = controller.getOffers();
        Assert.assertEquals(MessageConstants.RESULT_OK, response.getResultCode());
        Assert.assertEquals(MessageConstants.RESULT_DESC_OK_GET_OFFERS, response.getDescription());
        LocalDateTime dateTimeBase = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        Assert.assertEquals(3, response.getOffers().size());
        IntStream.iterate(1, i -> i + 1).limit(3).forEach(i -> {
            OfferOutput offer = response.getOffers().get(i - 1);
            Assert.assertEquals("title " + i, offer.getTitle());
            Assert.assertEquals("description " + i, offer.getDescription());
            Assert.assertEquals("merchant " + i, offer.getMerchantName());
            Assert.assertEquals(new BigDecimal(10 * i + 1).setScale(2), offer.getPrice());
            Assert.assertEquals("EUR", offer.getCurrency());
            Assert.assertEquals(i, offer.getProductId());
            Assert.assertEquals(dateTimeBase.plusMonths(i - 1), offer.getExpireDate());
        });
    }

    @Test
    public void testCancelOffer() {
        ResponseGetOffersWrapper responseBefore = controller.getOffers();
        responseBefore.getOffers().stream().forEach(offer -> controller.cancelOffer(offer.getIdOffer()));

        ResponseGetOffersWrapper responseAfter = controller.getOffers();
        assertTrue(responseAfter.getOffers().stream().allMatch(offer -> offer.getCancelDate() != null));
    }

    @Test(expected = CannotFindOfferException.class)
    public void testCancelOfferAlreadyCancelled() {
        controller.cancelOffer(1);// if exists executes with success otherwise should throw immediately
                                  // CannoFindOfferException
        controller.cancelOffer(1);

    }

}
