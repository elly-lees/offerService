package com.worldpay.model.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the OFFER database table.
 * 
 */
@Entity
@Table(name="OFFER")
public class Offer implements Serializable {
    private static final long serialVersionUID = 2139524073601655366L;
    
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
    
   


    /**
     * 
     */
    public Offer() {
        super();
    }
    

    //methods for chaining
    public Offer title(String title) {
        this.title = title;
        return this;
    }
    public Offer description(String description) {
        this.description = description;
        return this;
    }
    public Offer expireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }
    public Offer merchandName(String merchandName) {
        this.merchantName = merchandName;
        return this;
    }
    public Offer price(BigDecimal price) {
        this.price = price;
        return this;
    }
    public Offer currency(String currency) {
        this.currency = currency;
        return this;
    }
    public Offer productId(int productId) {
        this.productId = productId;
        return this;
    }
    @Id
    @Column(name="ID_OFFER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdOffer() {
        return idOffer;
    }


    public void setIdOffer(int idOffer) {
        this.idOffer = idOffer;
    }

    @Column(name="TITLE")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="CREATE_DATE")
    public LocalDateTime getCreateDate() {
        return createDate;
    }


    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Column(name="UPDATE_DATE")
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }


    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name="EXPIRE_DATE")
    public LocalDateTime getExpireDate() {
        return expireDate;
    }


    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    @Column(name="CANCEL_DATE")
    public LocalDateTime getCancelDate() {
        return cancelDate;
    }


    public void setCancelDate(LocalDateTime cancelDate) {
        this.cancelDate = cancelDate;
    }

    @Column(name="MERCHANT_NAME")
    public String getMerchantName() {
        return merchantName;
    }


    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    
    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name="CURRENCY")
    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name="PRODUCT_ID")
    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }

}