package com.bhx.category.persistence.converters.view;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
public class CategoryView {
    private String id;
    private String name;
    private String parentId;
    private String href;
    private List<String> keywords;
    private Boolean available;
}
