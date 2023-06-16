package com.bhx.category.delivery.converters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import javax.validation.constraints.Null;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryJson {
    private String href;
    private String name;
    private String keywords;
    @Nullable
    private String parentId;
}
