package com.bit.web.serviceimpl;

import java.util.List;

import com.bit.web.domain.CategoryDTO;
import com.bit.web.service.CategoryService;

import org.springframework.stereotype.Service;

/**
 * CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public void addCategory(CategoryDTO category) {

    }

    @Override
    public List<CategoryDTO> findCategories() {
        return null;
    }

    @Override
    public List<CategoryDTO> findCategoriesByOption(CategoryDTO option) {
        return null;
    }

    @Override
    public CategoryDTO findCategoryBycategoryId(String categoryId) {
        return null;
    }

    @Override
    public void updateCategory(CategoryDTO category) {

    }

    @Override
    public void deleteCategory(CategoryDTO category) {

    }

    
}