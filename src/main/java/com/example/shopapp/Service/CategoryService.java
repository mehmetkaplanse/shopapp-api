package com.example.shopapp.Service;

import com.example.shopapp.Entitities.Category;
import com.example.shopapp.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }


    public Category createCategory(@RequestBody Category categoryRequest) {
        Category toSave = new Category();
        toSave.setId(categoryRequest.getId());
        toSave.setName(categoryRequest.getName());
        toSave.setProducts(categoryRequest.getProducts());

        return categoryRepository.save(toSave);
    }

    public Category updateCategoryById(Long id, Category categoryRequest) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            Category toUpdate = categoryOptional.get();
            toUpdate.setId(categoryRequest.getId());
            toUpdate.setName(categoryRequest.getName());
            toUpdate.setProducts(categoryRequest.getProducts());
            categoryRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
