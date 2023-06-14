package com.bhx.storage.persistence.impl;

import com.bhx.product.Product;
import com.bhx.storage.Storage;
import com.bhx.storage.persistence.converter.StorageRepositoryConverter;
import com.bhx.storage.persistence.entities.StorageEntity;
import com.bhx.storage.persistence.repositories.StorageRepository;
import com.bhx.storage.ports.StorageRepositoryService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    public boolean saveStorage(Storage storage) {
        storageRepository.save(storageRepositoryConverter.mapToTable(storage));
        return true;
    }


    @Override
    public boolean deleteAStorage(String id) {
        storageRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean doesStorageNameExits(String name) {
         storageRepository.findByName(name);
        return true;
    }

    @Override
    public boolean doesStorageIdExist(String id) {
        return storageRepository.findById(id).isPresent();
    }

    @Override
    public Collection<Product> getAllProductByStorageId(String id) {
        return null;
    }

    @Override
    public List<Storage> getAllStorage() {
        List<StorageEntity> storageEntities = storageRepository.findAll();
        List<Storage> storages = new ArrayList<>();

        for (StorageEntity entity : storageEntities) {
            Storage storage = new Storage();
            storage.setId(entity.getId());
            storage.setName(entity.getName());
            storage.setAddress(entity.getAddress());
            storages.add(storage);
        }
        return storages;
    }
}
