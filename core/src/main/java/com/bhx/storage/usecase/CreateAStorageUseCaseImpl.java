package com.bhx.storage.usecase;

import com.bhx.storage.Storage;
import com.bhx.storage.ports.StorageRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAStorageUseCaseImpl implements  CreateAStorageUseCase {
    private final StorageRepositoryService storageRepositoryService;
    @Override
    public Boolean excute(Storage storage) {
        return storageRepositoryService.saveStorage(storage);
    }
}
