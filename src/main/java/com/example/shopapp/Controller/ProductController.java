package com.example.shopapp.Controller;

import com.example.shopapp.Entitities.Product;
import com.example.shopapp.Requests.CreateProductRequest;
import com.example.shopapp.Requests.UpdateProductRequest;
import com.example.shopapp.Responses.ProductResponse;
import com.example.shopapp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @PutMapping("/{productId}")
    public Product updateProductById(@PathVariable Long productId, @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.updateProductById(productId,updateProductRequest);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }
}
