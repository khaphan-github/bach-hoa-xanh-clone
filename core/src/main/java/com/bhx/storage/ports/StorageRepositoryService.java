package com.bhx.storage.ports;

import com.bhx.product.Product;
import com.bhx.storage.Storage;

import java.util.Collection;
import java.util.Optional;

public interface StorageRepositoryService {
    public Optional<Storage> getAStorageById(String id);
    public boolean saveStorage(Storage storage);
    public boolean deleteAStorage(String id);

    public boolean doesStorageNameExits(String name);

    public boolean doesStorageIdExist(String id);
    public Collection<Product> getAllProductByStorageId(String id);
}
