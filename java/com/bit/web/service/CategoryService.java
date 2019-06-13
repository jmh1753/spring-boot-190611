package com.bit.web.service;

import java.util.List;

import com.bit.web.domain.CategoryDTO;

import org.springframework.stereotype.Component;

/**
 * CategoryService
 */
@Component
public interface CategoryService {
    public void addCategory(CategoryDTO category);   
    public List<CategoryDTO> findCategories();
    public List<CategoryDTO> findCategoriesByOption(CategoryDTO option);
    public CategoryDTO findCategoryBycategoryId(String categoryId);
    public void updateCategory(CategoryDTO category);
    public void deleteCategory(CategoryDTO category);
}