package com.bhx.storage.usecase;

import com.bhx.storage.Storage;
import com.bhx.storage.ports.StorageRepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@AllArgsConstructor
public class GetAStorageByIdUseCaseImpl implements  GetAStorageByIdUseCase{
    private final StorageRepositoryService storageRepositoryService;
    @Override
    public Optional<Storage> excute(String Id) {
        return storageRepositoryService.getAStorageById(Id);
    }
}
