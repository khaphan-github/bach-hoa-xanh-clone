package com.bhx.storage.delivery.impl;

import com.bhx.category.Category;
import com.bhx.storage.Storage;
import com.bhx.storage.delivery.StorageController;
import com.bhx.storage.ports.StorageRepositoryService;
import com.bhx.storage.usecase.CreateAStorageUseCase;
import com.bhx.storage.usecase.DeleteAStorageUseCase;
import com.bhx.storage.usecase.EditAStorageUseCase;
import com.bhx.storage.usecase.GetAllStorageUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/storage")
public class StorageControllerImpl implements StorageController {
    private final GetAllStorageUsecase getAllStorageUsecase;
    private final CreateAStorageUseCase createAStorageUseCase;
    private final StorageRepositoryService storageRepositoryService;
    private final EditAStorageUseCase editAStorageUseCase;
    private final DeleteAStorageUseCase deleteAStorageUseCase;

    @Override
    @GetMapping("")
    public String index(Model model, HttpSession session) throws Exception {
        Collection<Storage> storageList =getAllStorageUsecase.excute();
        model.addAttribute("list_storages",storageList);
        Storage storage = new Storage();
        model.addAttribute("storage", storage);
        Storage storageEdit = new Storage();
        String storageId = (String) session.getAttribute("storageId");
        if(storageId != null){
            storageEdit = storageRepositoryService.getAStorageById(storageId);
        }
        model.addAttribute("storageEdit", storageEdit);
        return "admin/storage/index";
    }

    @Override
    @PostMapping("/create")
    public String saveStorage(@ModelAttribute("storage") Storage storage) {
        String storageId = storage.getId();
        if(storageId == null || storageId.isEmpty())
        {
            storage.setId(new ObjectId().toString());
        }
        if(storageRepositoryService.saveStorage(storage)){
            return "redirect:/storage";
        }
        return "redirect:/storage";
    }

    @Override
    @PostMapping("/updateStorage")
    public String updateStorage(@ModelAttribute Storage storage) {
        editAStorageUseCase.excute(storage);
        return "redirect:/storage";
    }


    @Override
    public String updateInventoryProduct(Model model) throws Exception {
        return null;
    }

    @Override
    @PostMapping("/deleteStorage/{id}")
    public String deleteStorage(@PathVariable("id") String id) {
        deleteAStorageUseCase.excute(id);
        return "redirect:/storage";
    }

}
