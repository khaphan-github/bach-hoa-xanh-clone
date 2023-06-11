package com.bhx.firebase.usecase;

import com.bhx.category.exception.CategoryAlreadyExistException;
import com.bhx.firebase.ports.FirebaseRepositoryService;

import java.awt.*;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UploadImagesProductImpl implements UploadImagesProduct {
    private final FirebaseRepositoryService firebaseRepositoryService;
    @Override
    public List<String> execute(List<Image> images) throws CategoryAlreadyExistException {
        return firebaseRepositoryService.uploadMuiltiImages(images);
    }


}
