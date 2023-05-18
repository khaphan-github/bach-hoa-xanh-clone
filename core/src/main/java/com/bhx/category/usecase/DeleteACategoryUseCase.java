package com.bhx.category.usecase;

import com.bhx.category.Category;
import com.bhx.category.exception.CategoryAlreadyExistException;

import java.util.Collection;

public interface DeleteACategoryUseCase {
    void execute(String id) throws CategoryAlreadyExistException;
}
