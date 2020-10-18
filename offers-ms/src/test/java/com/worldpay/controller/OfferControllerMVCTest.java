package com.worldpay.controller;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.MessageFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldpay.constants.ControllerRoutesConstants;
import com.worldpay.exception.CannotFindOfferException;
import com.worldpay.exception.InvalidInputMissingTitleException;
import com.worldpay.model.OfferBean;
import com.worldpay.model.wrapper.RequestOfferWrapper;
import com.worldpay.repository.OfferRepository;
import com.worldpay.service.OfferService;
import com.worldpay.utils.TestUtils;
import com.worldpay.validator.Validator;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OfferController.class)
public class OfferControllerMVCTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private OfferService offerService;
    @MockBean
    private Validator<RequestOfferWrapper> validator;
    @MockBean
    RequestOfferWrapper rew;
    
    @MockBean
    OfferRepository repository;
  
    @Test
    public void testCreateOffer() throws Exception {      

        mockMvc.perform(post(buildCreateOfferPostUrl())
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(TestUtils.createOfferRequest())))
                .andExpect(status().isCreated());
        verify(offerService).createOffer(any(OfferBean.class));
        verifyNoMoreInteractions(offerService);

        verify(validator).validate(any(RequestOfferWrapper.class));
        verifyNoMoreInteractions(validator);

    }

    @Test
    public void testCreateOfferValidationTitleFail() throws Exception {
        doThrow(InvalidInputMissingTitleException.class).when(validator).validate(any(RequestOfferWrapper.class));
        mockMvc.perform(post(buildCreateOfferPostUrl())
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(TestUtils.createOfferRequest())))
                .andExpect(status().isBadRequest());
        verify(validator).validate(any(RequestOfferWrapper.class));
        verifyNoMoreInteractions(validator);
        verifyNoMoreInteractions(offerService);
        

    }
    @Test
    public void testCreateOfferTechnicalExceptionFail() throws Exception {
        doThrow(RuntimeException.class).when(offerService).createOffer(any(OfferBean.class));
        mockMvc.perform(post(buildCreateOfferPostUrl())
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(TestUtils.createOfferRequest())))
                .andExpect(status().isInternalServerError());
        verify(validator).validate(any(RequestOfferWrapper.class));
        verifyNoMoreInteractions(validator);
        verify(offerService).createOffer(any(OfferBean.class));
    }
    @Test
    public void testCancelOfferCannotFindOfferExceptionFail() throws Exception {
        doThrow(CannotFindOfferException.class).when(offerService).cancelOffer(any(int.class));
        mockMvc.perform(delete(buildCancelOfferUrl(1)))
                .andExpect(status().isNotFound());
        verifyNoMoreInteractions(validator);
        verify(offerService).cancelOffer(any(int.class));
    }
    private String buildCreateOfferPostUrl() {
        return new StringBuilder()
                .append(ControllerRoutesConstants.CREATE_OFFER)
                .toString();
    }
    private String buildCancelOfferUrl(int idOffer) {
        return new StringBuilder()
                .append("/offers/"+idOffer)
                .toString();
    }
   

}
