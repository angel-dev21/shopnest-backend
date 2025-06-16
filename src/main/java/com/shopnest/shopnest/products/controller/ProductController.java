package com.shopnest.shopnest.products.controller;


import com.shopnest.shopnest.products.dto.ProductDto;
import com.shopnest.shopnest.products.dto.ProductResponseDto;
import com.shopnest.shopnest.products.dto.ProductSizeDto;
import com.shopnest.shopnest.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    /*@GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }*/

    //Get product by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    //Get product by code
    @GetMapping("/code/{productCode}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable String productCode) {
        return ResponseEntity.ok(productService.getProductByCode(productCode));
    }

    //Get available sizes for a product
    @GetMapping("/code/{productCode}/sizes")
    public ResponseEntity<List<ProductSizeDto>> getAvailableSizes(@PathVariable String productCode) {
        List<ProductSizeDto> sizes = productService.getAvailableSizesForProduct(productCode);
        return ResponseEntity.ok(sizes);
    }


    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> GetProductPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size){
        return ResponseEntity.ok(productService.getPaginatedProducts(page, size));
    }

    /*
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
        return ResponseEntity.ok(productService.updateProduct(productDto,id));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    } */
}
