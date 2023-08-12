package xyz.seksky.productcomparer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPriceController {


    @GetMapping("/product")
    public ResponseEntity<String> getProduct() {

        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
