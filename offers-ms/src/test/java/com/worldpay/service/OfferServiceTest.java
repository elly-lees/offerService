package com.worldpay.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.worldpay.model.OfferBean;
import com.worldpay.model.repository.Offer;
import com.worldpay.repository.OfferRepository;
import com.worldpay.service.impl.OfferServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceTest {
    @InjectMocks
    OfferServiceImpl service;

    @Mock
    OfferRepository repository;

    @Mock
    OfferBean offerBean;

    @Test
    public void createOfferSuccess() {
        when(repository.createOffer(any(Offer.class))).thenReturn(1);
        int idOffer = service.createOffer(offerBean);

        verify(repository, times(1)).createOffer(any(Offer.class));
        verifyNoMoreInteractions(repository);
        assertEquals(1, idOffer);
    }

    @Test
    public void cancelOfferSuccess() {
        when(repository.cancelOffer(any(Integer.class))).thenReturn(true);
        boolean cancelled = service.cancelOffer(1);

        verify(repository, times(1)).cancelOffer(any(Integer.class));
        verifyNoMoreInteractions(repository);
        assertEquals(true, cancelled);
    }

    @Test
    public void getOffersEmptySuccess() {
        when(repository.getOffers()).thenReturn(new ArrayList<Offer>());
        List<OfferBean> offerList = service.getOffers();

        verify(repository, times(1)).getOffers();
        verifyNoMoreInteractions(repository);
        assertEquals(0, offerList.size());
    }

}
