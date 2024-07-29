package com.example.shopapp.Service;

import com.example.shopapp.Entitities.Category;
import com.example.shopapp.Entitities.Product;
import com.example.shopapp.Repository.CategoryRepository;
import com.example.shopapp.Repository.ProductRepository;
import com.example.shopapp.Requests.CreateProductRequest;
import com.example.shopapp.Requests.UpdateProductRequest;
import com.example.shopapp.Responses.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public List<ProductResponse> getAllProducts() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(product -> {
            ProductResponse response = new ProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setPrice(product.getPrice());
            response.setExplanation(product.getExplanation());
            response.setCategory_id(product.getCategory().getId());
            return response;
        }).collect(Collectors.toList());
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }


    public Product createProduct(CreateProductRequest productRequest) {
        Product toCreate = new Product();
        toCreate.setName(productRequest.getName());
        toCreate.setPrice(productRequest.getPrice());
        toCreate.setExplanation(productRequest.getExplanation());

        Optional<Category> categoryOptional = categoryRepository.findById(productRequest.getCategory_id());
        if (categoryOptional.isPresent()) {
            toCreate.setCategory(categoryOptional.get());
        } else {
            throw new RuntimeException("Category not found with id: " + productRequest.getCategory_id());
        }

        return productRepository.save(toCreate);
    }

    public Product updateProductById(Long productId , UpdateProductRequest updateProductRequest) {
        Optional<Product> productOptional = productRepository.findById(productId);
        Optional<Category> categoryOptional = categoryRepository.findById(updateProductRequest.getCategory_id());
        if(productOptional.isPresent() && categoryOptional.isPresent()) {
            Product toUpdate = productOptional.get();
            toUpdate.setId(productId);
            toUpdate.setName(updateProductRequest.getName());
            toUpdate.setPrice(updateProductRequest.getPrice());
            toUpdate.setExplanation(updateProductRequest.getExplanation());
            toUpdate.setCategory(categoryOptional.get());
            productRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}
