package xyz.seksky333.productcomparer.network.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.seksky333.productcomparer.models.Product;

import java.util.List;

public class GetPriceResponse implements PriceResponse {
    @JsonProperty("products")
    private List<Product> products;

    public GetPriceResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public GetPriceResponse() {
    }
}
