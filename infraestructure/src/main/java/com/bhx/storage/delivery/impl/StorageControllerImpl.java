package com.bhx.storage.delivery.impl;

import com.bhx.storage.Storage;
import com.bhx.storage.delivery.StorageController;
import com.bhx.storage.usecase.GetAllStorageUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/permissions")
public class StorageControllerImpl implements StorageController {
    private final GetAllStorageUsecase getAllStorageUsecase;
    @Override
    @GetMapping("")
    public String index(Model model) throws Exception {
        model.addAttribute("active","home");
        Collection<Storage> storageList =getAllStorageUsecase.excute();
        model.addAttribute("list_storages",storageList);
        return "admin/storage/index";
    }
}
