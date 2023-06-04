package com.bhx.rootcategory.usecase;

import com.bhx.rootcategory.ports.RootCategoryRepositoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetLastIdUseCaseImpl implements GetLastIdUseCase{

    private final RootCategoryRepositoryService rootCategoryRepositoryService;
    @Override
    public String execute() throws Exception {
        int last = rootCategoryRepositoryService.GetLastId();
        return String.valueOf(last);
    }
}
