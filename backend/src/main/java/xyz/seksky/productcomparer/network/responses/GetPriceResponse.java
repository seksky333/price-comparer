package xyz.seksky.productcomparer.network.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.seksky.productcomparer.Entity.ProductPriceEntity;

import java.util.List;

public class GetPriceResponse implements PriceResponse{
    @JsonProperty("prices")
    private List<ProductPriceEntity> prices;

    public GetPriceResponse(List<ProductPriceEntity> prices) {
        this.prices = prices;
    }
}
