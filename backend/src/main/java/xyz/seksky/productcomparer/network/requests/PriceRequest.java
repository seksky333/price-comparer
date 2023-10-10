package xyz.seksky.productcomparer.network.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class PriceRequest {
    @JsonProperty(value = "product_name", required = true)
    @NotBlank
    String productName;
    @JsonProperty(value = "product_model", required = true)
    @NotBlank
    String productModel;
    @JsonProperty(value = "product_price", required = true)
    @NotBlank
    String productPrice;
    @JsonProperty(value = "seller", required = true)
    @NotBlank
    String seller;
    @JsonProperty(value = "view_date", required = true)
    @NotBlank
    String viewDate;
    @JsonProperty(value = "reference_url", required = true)
    @NotBlank
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
