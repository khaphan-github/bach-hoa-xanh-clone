package com.bhx.category.persistence.converters.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRoot {

    private String parentId;
    private String name;
    private String href;
    private String keywords;
    private Boolean available;
}
