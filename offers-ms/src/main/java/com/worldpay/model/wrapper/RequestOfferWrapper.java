package com.worldpay.model.wrapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author alena.khvat
 *
 */
public class RequestOfferWrapper implements Serializable {
    private static final long serialVersionUID = 4700220365109195371L;

    private String title;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireDate;

    private String merchandName;

    private BigDecimal price;
    private String currency;

    private int productId;

    /**
     * 
     */
    public RequestOfferWrapper() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public String getMerchantName() {
        return merchandName;
    }

    public void setMerchantName(String merchantName) {
        this.merchandName = merchantName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
