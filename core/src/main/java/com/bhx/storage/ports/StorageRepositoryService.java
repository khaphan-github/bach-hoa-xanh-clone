package com.bhx.storage.ports;

import com.bhx.storage.Storage;

import java.util.Optional;

public interface StorageRepositoryService {
    public Optional<Storage> getAStorageById(String id);
    public boolean saveStorage(Storage storage);
    public boolean deleteAStorage(String id);

    public boolean doesStorageNameExits(String name);

    public boolean doesStorageIdExist(String id);
}
