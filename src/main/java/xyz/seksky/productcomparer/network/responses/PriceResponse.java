package xyz.seksky.productcomparer.network.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.seksky.productcomparer.models.ProductPrice;

import java.util.List;

public class PriceResponse {
    @JsonProperty("prices")
    private List<ProductPrice> prices;

    public PriceResponse(List<ProductPrice> prices) {
        this.prices = prices;
    }
}
