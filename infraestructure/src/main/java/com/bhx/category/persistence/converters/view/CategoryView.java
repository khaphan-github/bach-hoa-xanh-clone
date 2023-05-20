package com.bhx.category.persistence.converters.view;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class CategoryView {
    private String id;
    private String name;
    private String parentId;
    private Boolean available;
}
