package com.bhx.storage.usecase;

import com.bhx.storage.Storage;

import java.util.Optional;

public interface GetAStorageByIdUseCase {
    public Optional<Storage> excute(String Id);
}
