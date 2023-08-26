package xyz.seksky.productcomparer.network.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidResponse implements PriceResponse{
    @JsonProperty("error")
    private String errorMessage;

    public InvalidResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
