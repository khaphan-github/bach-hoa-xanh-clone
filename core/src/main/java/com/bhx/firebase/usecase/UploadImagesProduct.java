package com.bhx.firebase.usecase;

import com.bhx.category.exception.CategoryAlreadyExistException;

import java.awt.Image;
import java.util.List;

public interface UploadImagesProduct {
    public List<String> execute(List<Image> images) throws CategoryAlreadyExistException;
}
