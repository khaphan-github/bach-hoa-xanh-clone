package com.bhx.rootcategory.delivery.converters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class RootCategoryView implements Serializable {

    private String id;
    private String name;
}
