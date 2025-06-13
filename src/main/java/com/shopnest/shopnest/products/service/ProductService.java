package com.shopnest.shopnest.products.service;

import com.shopnest.shopnest.exceptions.ResourceNotFoundException;
import com.shopnest.shopnest.products.dto.ProductDto;
import com.shopnest.shopnest.products.entity.Product;
import com.shopnest.shopnest.products.mapper.ProductMapper;
import com.shopnest.shopnest.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getPaginatedProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        List<Product> products = productPage.getContent();
        return products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }

    /*public List<ProductDto> getAllProduct(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }*/

    public ProductDto getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return productMapper.toProductDto(product);
    }

    public ProductDto addProduct(ProductDto productDto){
        Product product = productMapper.toProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDto(savedProduct);
    }

    public ProductDto updateProduct(ProductDto productDto, Long id){
        Product updatedProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        updatedProduct.setProductName(productDto.getProductName());
        updatedProduct.setProductDescription(productDto.getProductDescription());
        updatedProduct.setProductPrice(productDto.getProductPrice());
        productRepository.save(updatedProduct);
        return productMapper.toProductDto(updatedProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    

}
