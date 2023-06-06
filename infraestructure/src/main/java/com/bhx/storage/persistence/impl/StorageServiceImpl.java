package com.bhx.storage.persistence.impl;

import com.bhx.storage.Storage;
import com.bhx.storage.persistence.converter.StorageRepositoryConverter;
import com.bhx.storage.persistence.entities.StorageEntity;
import com.bhx.storage.persistence.repositories.StorageRepository;
import com.bhx.storage.ports.StorageRepositoryService;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class StorageServiceImpl implements StorageRepositoryService {

    private final StorageRepository storageRepository;
    private final StorageRepositoryConverter storageRepositoryConverter;
    @Override
    public Optional<Storage> getAStorageById(String id) {
        Optional<StorageEntity> stored =  storageRepository.findById(id);
        return Optional.ofNullable(storageRepositoryConverter.mapToEntity(stored.get()));
    }

    @Override
    public boolean createAStorage(Storage storage) {

        return false;
    }

    @Override
    public boolean editAStorage(Storage storage) {
        return false;
    }

    @Override
    public boolean deleteAStorage(Storage storage) {
        return false;
    }
}
