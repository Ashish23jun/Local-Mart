package com.ashley.product.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
        @RequestBody @Valid ProductRequest productrequest
    ){
        return ResponseEntity.ok(productService.createProduct(productrequest));
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>>purchaseProduct(
            @RequestBody List<ProductPurchaseRequest> productPurchaseRequests
    ){
        return ResponseEntity.ok(productService.purchaseProduct(productPurchaseRequests));
    }
    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse>findById(
            @PathVariable("product-id") Integer productId
    ){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>>findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
}