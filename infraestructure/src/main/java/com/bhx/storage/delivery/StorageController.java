package com.bhx.storage.delivery;

import com.bhx.storage.Storage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface StorageController {
    String index(Model model, HttpSession session) throws Exception;

    String saveStorage(@ModelAttribute Storage storage);

    String updateStorage(Storage storage);
    String updateInventoryProduct(Model model)throws Exception;
    String deleteStorage(String id);

}
