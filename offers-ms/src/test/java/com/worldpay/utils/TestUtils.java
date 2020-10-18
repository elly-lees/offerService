package com.worldpay.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.worldpay.model.repository.Offer;
import com.worldpay.model.wrapper.RequestOfferWrapper;

public class TestUtils {

    public static LocalDateTime createDateYesterday() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        return yesterday;
    }
    public static LocalDateTime createDateToday() {
        LocalDateTime today = LocalDateTime.now();
        return today;
    }

    public static LocalDateTime createDateTomorrow() {
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        return tomorrow;
    }
    public static RequestOfferWrapper createOfferRequest() {
        RequestOfferWrapper rew = new RequestOfferWrapper();
        rew.setDescription("description 0");
        rew.setTitle("title 0");
        rew.setPrice(new BigDecimal("10"));
        rew.setCurrency("EUR");
        rew.setProductId(10);
        rew.setExpireDate(createDateTomorrow());
        return rew;
    }
    public static Offer createOfferDTO() {
        Offer o = new Offer();
        o.setDescription("description 0");
        o.setTitle("title 0");
        o.setPrice(new BigDecimal("10.00"));
        o.setCurrency("EUR");
        o.setProductId(10);
        o.setExpireDate(createDateTomorrow());
        o.setCreateDate(createDateToday());
        o.setUpdateDate(createDateToday());
        return o;
    }

}
