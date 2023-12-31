package xyz.seksky333.productcomparer.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.seksky333.productcomparer.Entity.ProductEntity;
import xyz.seksky333.productcomparer.models.Product;
import xyz.seksky333.productcomparer.network.requests.PriceRequest;
import xyz.seksky333.productcomparer.network.responses.GetPriceResponse;
import xyz.seksky333.productcomparer.network.responses.InvalidResponse;
import xyz.seksky333.productcomparer.network.responses.PriceResponse;
import xyz.seksky333.productcomparer.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductPriceController {
    private final ProductService productService;

    @Autowired
    public ProductPriceController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetPriceResponse> getProduct() {
        List<Product> products = productService.getAll();
        GetPriceResponse response = new GetPriceResponse(products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponse> purchaseSeat(@Valid @RequestBody PriceRequest request) {
        try {
            productService.addPrice(
                    new ProductEntity(
                            productService.getNextEntityId(),
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
