package com.bhx.rootcategory.delivery.impl;

import com.bhx.rootcategory.delivery.RootCategoryController;
import com.bhx.rootcategory.usecase.GetLastIdUseCase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class RootCategoryControllerImpl implements RootCategoryController {

    @Override
    public void getRootCategory() throws Exception {

    }
}
