package com.bhx.storage.usecase;

import com.bhx.storage.Storage;
import com.bhx.storage.ports.StorageRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Collection;


@AllArgsConstructor
public class GetAllStorageUsecaseImpl implements GetAllStorageUsecase{
    private final StorageRepositoryService storageRepositoryService;
    @Override
    public Collection<Storage> excute() {
        return storageRepositoryService.getAllStorage();
    }
}
