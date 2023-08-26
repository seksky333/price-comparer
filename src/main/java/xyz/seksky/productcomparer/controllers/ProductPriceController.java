package xyz.seksky.productcomparer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.seksky.productcomparer.Entity.ProductPriceEntity;
import xyz.seksky.productcomparer.network.requests.PriceRequest;
import xyz.seksky.productcomparer.network.responses.GetPriceResponse;
import xyz.seksky.productcomparer.network.responses.InvalidResponse;
import xyz.seksky.productcomparer.network.responses.PriceResponse;
import xyz.seksky.productcomparer.services.PriceService;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class ProductPriceController {
    private final PriceService priceService;

    @Autowired
    public ProductPriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetPriceResponse> getProduct() {
        List<ProductPriceEntity> prices = priceService.getAll();
        GetPriceResponse response = new GetPriceResponse(prices);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponse> purchaseSeat(@RequestBody PriceRequest request) {
        try {
            priceService.addPrice(
                    new ProductPriceEntity(
                            priceService.getNextEntityId(),
                            request.getProductName(), request.getProductModel(), request.getProductPrice(),
                            request.getSeller(), request.getViewDate(), request.getReferenceUrl()
                    )
            );
        } catch (IllegalStateException e) {
            InvalidResponse response = new InvalidResponse("Invalid inputs");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
