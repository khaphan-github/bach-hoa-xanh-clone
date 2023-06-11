package com.bhx.storage.usecase;

import com.bhx.storage.ports.StorageRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAStorageUseCaseImpl implements  DeleteAStorageUseCase{
    private final StorageRepositoryService storageRepositoryService;
    @Override
    public Boolean excute(String id) {
        if(storageRepositoryService.doesStorageIdExist(id))
        {
            return storageRepositoryService.deleteAStorage(id);
        }
        return false;
    }
}
