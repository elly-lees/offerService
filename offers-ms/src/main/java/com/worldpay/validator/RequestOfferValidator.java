package com.worldpay.validator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.worldpay.exception.InvalidInputInvalidExpireDateException;
import com.worldpay.exception.InvalidInputInvalidPriceException;
import com.worldpay.exception.InvalidInputMissingCurrencyException;
import com.worldpay.exception.InvalidInputMissingDescriptionException;
import com.worldpay.exception.InvalidInputMissingPriceException;
import com.worldpay.exception.InvalidInputMissingProductException;
import com.worldpay.exception.InvalidInputMissingTitleException;
import com.worldpay.model.wrapper.RequestOfferWrapper;

/**
 *
 * 
 * @author alena.khvat
 *
 */
@Component
public class RequestOfferValidator  implements Validator<RequestOfferWrapper>  {

    @Override
    public void validate(RequestOfferWrapper offer) {
        validateTitle(offer.getTitle());
        validateDescription(offer.getDescription());
        validateExpireDate(offer.getExpireDate());
        validatePrice(offer.getPrice());
        validateCurrency(offer.getCurrency());
        validateProduct(offer.getProductId());
    }

    private void validateProduct(int productId) {
        if(productId == 0)
            throw new InvalidInputMissingProductException();
    }

    private void validateCurrency(String currency) {
        if(StringUtils.isEmpty(currency))
            throw new InvalidInputMissingCurrencyException();
    }

    private void validatePrice(BigDecimal price) {
        if(price == null)
            throw new InvalidInputMissingPriceException();
        if(price.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidInputInvalidPriceException();
    }

    private void validateExpireDate(LocalDateTime expireDate) {
        if(expireDate != null && !expireDate.isAfter(LocalDateTime.now()))
            throw new InvalidInputInvalidExpireDateException();
        
    }

    private void validateDescription(String description) {
        if(StringUtils.isEmpty(description))
            throw new InvalidInputMissingDescriptionException();
        
    }

    private void validateTitle(String title) {
       if(StringUtils.isEmpty(title))
           throw new InvalidInputMissingTitleException();
    }

 
}
