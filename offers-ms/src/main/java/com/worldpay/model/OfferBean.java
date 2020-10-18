package com.worldpay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author alena.khvat
 *
 */
public class OfferBean implements Serializable{
	private static final long serialVersionUID = -5913996385436881807L;
	
	private int idOffer;
    private String title;
    private String description;
    
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime expireDate;
    private LocalDateTime cancelDate;
    
    private String merchantName;
    
    private BigDecimal price;
    private String currency;
    private int productId;
    
    //methods for chaining
    public OfferBean title(String title) {
        this.title = title;
        return this;
    }
    public OfferBean description(String description) {
        this.description = description;
        return this;
    }
    public OfferBean expireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }
    public OfferBean merchandName(String merchandName) {
        this.merchantName = merchandName;
        return this;
    }
    public OfferBean price(BigDecimal price) {
        this.price = price;
        return this;
    }
    public OfferBean currency(String currency) {
        this.currency = currency;
        return this;
    }
    public OfferBean productId(int productId) {
        this.productId = productId;
        return this;
    }
    
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
        return merchantName;
    }
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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
