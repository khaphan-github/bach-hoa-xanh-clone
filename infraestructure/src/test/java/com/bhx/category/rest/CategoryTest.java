package com.bhx.category.rest;

import com.bhx.category.Category;
import com.bhx.category.persistence.converters.CategoryRepositoryConverter;
import com.bhx.category.persistence.entities.CategoryEntity;
import com.bhx.category.persistence.impl.CategoryServiceImpl;
import com.bhx.category.persistence.repositories.CategoryRepository;
import com.bhx.category.usecase.GetAllCategoriesUseCase;
import com.bhx.category.ports.CategoryRepositoryService;
import com.bhx.chatgpt.ChatGPTSuggestionApiResponse;
import com.bhx.chatgptsuggestion.persistence.impl.ChatGPTSuggestionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Slf4j
@SpringJUnitConfig
@SpringBootTest
public class CategoryTest {
    private GetAllCategoriesUseCase getAllCategoriesUseCase;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryRepositoryConverter categoryRepositoryConverter;

    @Autowired
    private CategoryServiceImpl categoryRepositoryService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetAllCategories() {
        Collection<Category> categories = categoryRepositoryService.getAllCategories();
        System.out.println(categories);;
        // Verify the result
        assertNotEquals(0, categories.size());
    }

    @Test
    public void testCreateACategory() {
        Collection<Category> categoriesBefore = categoryRepositoryService.getAllCategories();
        Category category = new Category(null, "2", "Kim Khánh",true);
        categoryRepositoryService.saveCategory(category);
        Collection<Category> categoriesAfter = categoryRepositoryService.getAllCategories();
        // Verify the result
        assert(categoriesBefore.size()< categoriesAfter.size());
    }

    @Test
    public  void testUpdateACategory(){
        Category category = new Category("21", "2", "Update Kim Khánh",true);
        categoryRepositoryService.saveCategory(category);
        // Verify the result
        assert(category.getName() == "Update Kim Khánh");
    }

    @Test
    public void testDeleteACategory() {
        Collection<Category> categoriesBefore = categoryRepositoryService.getAllCategories();
        categoryRepositoryService.deleteCategory("21");
        Collection<Category> categoriesAfter = categoryRepositoryService.getAllCategories();
        // Verify the result
        assert(categoriesBefore.size()> categoriesAfter.size());
    }
    @Test
    public void testGetOneCategory(){
        Optional<Category> category = categoryRepositoryService.getCategoryById("21");
        System.out.println(category);
        assertTrue(category.isPresent());
    }
}
