package com.worldpay.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.worldpay.constants.ControllerRoutesConstants;
import com.worldpay.constants.MessageConstants;
import com.worldpay.exception.CannotFindOfferException;
import com.worldpay.exception.CustomOfferException;
import com.worldpay.exception.InternalDbException;
import com.worldpay.exception.InternalGenericException;
import com.worldpay.exception.InvalidInputInvalidExpireDateException;
import com.worldpay.exception.InvalidInputInvalidPriceException;
import com.worldpay.exception.InvalidInputMissingCurrencyException;
import com.worldpay.exception.InvalidInputMissingDescriptionException;
import com.worldpay.exception.InvalidInputMissingProductException;
import com.worldpay.exception.InvalidInputMissingTitleException;
import com.worldpay.model.OfferBean;
import com.worldpay.model.wrapper.GenericResponseWrapper;
import com.worldpay.model.wrapper.OfferOutput;
import com.worldpay.model.wrapper.RequestOfferWrapper;
import com.worldpay.model.wrapper.ResponseCreateOfferWrapper;
import com.worldpay.model.wrapper.ResponseGetOffersWrapper;
import com.worldpay.service.OfferService;
import com.worldpay.validator.Validator;


@RestController
@RequestMapping(path = ControllerRoutesConstants.ENGINE_CONTROLLER)
public class OfferController {
	private MessageFormat errorMsgFormat = new MessageFormat("ErrorCode = {0}. Description = {1}");

    @Autowired
    private Validator<RequestOfferWrapper> validator;

    @Autowired
    private OfferService offerService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method for creating a new offer
     * 
     * @param rew
     * @return
     */
    @PostMapping(path = ControllerRoutesConstants.CREATE_OFFER)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseCreateOfferWrapper createOffer(@RequestBody RequestOfferWrapper rew) {
        logger.info("Controller createOffer >>> start");

        ResponseCreateOfferWrapper response = new ResponseCreateOfferWrapper();
        validator.validate(rew);
        try {
            OfferBean o = new OfferBean();
            o.setDescription(rew.getDescription());
            o.setExpireDate(rew.getExpireDate());
            o.setTitle(rew.getTitle());
            o.setMerchantName(rew.getMerchantName());
            o.setCurrency(rew.getCurrency());
            o.setPrice(rew.getPrice());
            o.setProductId(rew.getProductId());
            int idOffer = offerService.createOffer(o);

            response.setResultCode(MessageConstants.RESULT_OK);
            response.setDescription(MessageConstants.RESULT_DESC_OK_CREATE_OFFER);
            response.setIdOffer(idOffer);

        } catch (Exception e) {

            throw new InternalGenericException(e);
        }

        logger.info("Controller createOffer <<< end");

        return response;
    }

    
    /**
     * Method for retrieving a list of all active offers
     * 
     * @return
     */
    @GetMapping(path = ControllerRoutesConstants.GET_OFFERS)
    public ResponseGetOffersWrapper getOffers() {
        logger.info("Controller getOffers >>> start");

        ResponseGetOffersWrapper response = new ResponseGetOffersWrapper();
        try {
            List<OfferOutput> offerList = offerService.getOffers().stream().map(offer -> {
                OfferOutput o = new OfferOutput();
                o.setIdOffer(offer.getIdOffer());
                o.setCancelDate(offer.getCancelDate());
                o.setCreateDate(offer.getCreateDate());
                o.setDescription(offer.getDescription());
                o.setExpireDate(offer.getExpireDate());
                o.setTitle(offer.getTitle());
                o.setUpdateDate(offer.getUpdateDate());
                o.setMerchandName(offer.getMerchantName());
                o.setPrice(offer.getPrice());
                o.setCurrency(offer.getCurrency());
                o.setProductId(offer.getProductId());
                return o;
            }).collect(Collectors.toList());
            response.setOffers(offerList);
            response.setResultCode(MessageConstants.RESULT_OK);
            response.setDescription(MessageConstants.RESULT_DESC_OK_GET_OFFERS);
        } catch (Exception e) {
            throw new InternalGenericException(e);
        }

        logger.info("Controller getOffers <<< end");

        return response;
    }

    /**
     * Method for cancelling an offer before expiration
     * 
     * @param idOffer
     * @return
     * @throws CustomOfferException
     */
    @DeleteMapping(path = ControllerRoutesConstants.CANCEL_OFFER)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GenericResponseWrapper cancelOffer(@PathVariable int idOffer) throws CustomOfferException {

        logger.info("Controller cancelOffer >>> start");

        GenericResponseWrapper response = new ResponseGetOffersWrapper();

        boolean result = false;
        try {
            result = offerService.cancelOffer(idOffer);
            if (result == true) {
                response.setResultCode(MessageConstants.RESULT_OK);
                response.setDescription(MessageConstants.RESULT_DESC_OK_CANCEL_OFFER);
            } else {
                throw new CannotFindOfferException();
            }

        }catch (CannotFindOfferException ce) {
            throw ce;
        } catch (Exception e) {
            throw new InternalGenericException(e);
        }

        logger.info("Controller cancelOffer <<< end");

        return response;

    }

    
    /**
     * Method for handling validation error, return BAD REQUEST
     * 
     * @param exception
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ InvalidInputMissingTitleException.class, InvalidInputInvalidExpireDateException.class,
        InvalidInputInvalidPriceException.class, InvalidInputMissingCurrencyException.class,
        InvalidInputMissingDescriptionException.class, InvalidInputMissingProductException.class
       })
    @ResponseBody
    public GenericResponseWrapper handleValidationError(Exception exception) {
        return handleErrorBase(exception);
    }

   
    /**
     * Method for handling technical exceptions
     * @param exception
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ InternalGenericException.class, InternalDbException.class })
    @ResponseBody
    public GenericResponseWrapper handleInternalError(Exception exception) {
        return handleErrorBase(exception);
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({  CannotFindOfferException.class })
    @ResponseBody
    public GenericResponseWrapper handleCannotFindOfferError(Exception exception) { 
        return handleErrorBase(exception);
    }
    
    /**
     * Base implementation for error handling and wrapping the response
     * @param exception
     * @return
     */
    private GenericResponseWrapper handleErrorBase(Exception exception) {
        CustomOfferException e = (CustomOfferException) exception;
        logger.error(errorMsgFormat.format(new String[] { e.getErrorCode(), e.getMessage() }), e.getCause());
        return new GenericResponseWrapper(e);
    }
    

}
