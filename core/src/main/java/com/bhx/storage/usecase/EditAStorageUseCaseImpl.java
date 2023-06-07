package com.bhx.storage.usecase;

import com.bhx.storage.Storage;
import com.bhx.storage.ports.StorageRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditAStorageUseCaseImpl implements  EditAStorageUseCase{
    private StorageRepositoryService storageRepositoryService;
    @Override
    public Boolean excute(Storage storage) {
        if(storageRepositoryService.doesStorageIdExist(storage.getId()))
        {
            return storageRepositoryService.saveStorage(storage);
        }
        return false;
    }
}
