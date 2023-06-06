package com.bhx.storage.ports;

import com.bhx.storage.Storage;

import java.util.Optional;

public interface StorageRepositoryService {
    public Optional<Storage> getAStorageById(String id);
    public boolean createAStorage(Storage storage);
    public boolean editAStorage(Storage storage);
    public boolean deleteAStorage(Storage storage);
}
