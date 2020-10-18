package com.worldpay.model.wrapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OfferOutput {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private int idOffer;
    private String title;
    private String description;
    private String merchandName;
    private BigDecimal price;
    private String currency;
    private int productId;
    
    @JsonFormat(pattern=DATETIME_FORMAT)
    private LocalDateTime createDate;
    @JsonFormat(pattern=DATETIME_FORMAT)
    private LocalDateTime updateDate;
    @JsonFormat(pattern=DATETIME_FORMAT)
    private LocalDateTime expireDate;
    @JsonFormat(pattern=DATETIME_FORMAT)
    private LocalDateTime cancelDate;
    
    public int getIdOffer() {
        return idOffer;
    }
    public void setIdOffer(int idOffer) {
        this.idOffer = idOffer;
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
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public LocalDateTime getExpireDate() {
        return expireDate;
    }
    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }
    public LocalDateTime getCancelDate() {
        return cancelDate;
    }
    public void setCancelDate(LocalDateTime cancelDate) {
        this.cancelDate = cancelDate;
    }
    public String getMerchantName() {
        return merchandName;
    }
    public void setMerchandName(String merchandName) {
        this.merchandName = merchandName;
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
