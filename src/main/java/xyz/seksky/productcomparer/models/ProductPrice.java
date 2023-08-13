package xyz.seksky.productcomparer.models;

import jakarta.persistence.*;

@Entity
@Table(name = "price")
public class ProductPrice {
    @Id
    Long id;
    String productName;
    String productModel;
    String productPrice;
    String seller;
    String viewDate;
    String referenceUrl;

    public ProductPrice() {
    }

    public ProductPrice(Long id, String productName, String productModel, String productPrice, String seller, String viewDate, String referenceUrl) {
        this.id = id;
        this.productName = productName;
        this.productModel = productModel;
        this.productPrice = productPrice;
        this.seller = seller;
        this.viewDate = viewDate;
        this.referenceUrl = referenceUrl;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getSeller() {
        return seller;
    }

    public String getViewDate() {
        return viewDate;
    }

    public String getReferenceUrl() {
        return referenceUrl;
    }
}
