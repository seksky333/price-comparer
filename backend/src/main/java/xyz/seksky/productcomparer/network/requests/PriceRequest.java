package xyz.seksky.productcomparer.network.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceRequest {
    @JsonProperty(value = "product_name", required = true)
    String productName;
    @JsonProperty(value = "product_model", required = true)
    String productModel;
    @JsonProperty(value = "product_price", required = true)
    String productPrice;
    @JsonProperty(value = "seller", required = true)
    String seller;
    @JsonProperty(value = "view_date", required = true)
    String viewDate;
    @JsonProperty(value = "reference_url", required = true)
    String referenceUrl;

    public PriceRequest(String productName, String productModel, String productPrice, String seller, String viewDate, String referenceUrl) {
        this.productName = productName;
        this.productModel = productModel;
        this.productPrice = productPrice;
        this.seller = seller;
        this.viewDate = viewDate;
        this.referenceUrl = referenceUrl;
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
