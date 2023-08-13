package xyz.seksky.productcomparer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import xyz.seksky.productcomparer.models.ProductPrice;
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

    @GetMapping
    public ResponseEntity<PriceResponse> getProduct() {
        List<ProductPrice> prices = priceService.getAll();
        PriceResponse response = new PriceResponse(prices);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
