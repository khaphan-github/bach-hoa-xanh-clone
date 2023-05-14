package com.bhx.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author "KhaPhan" on 13-May-23
 * @project clean-architecture
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTSuggestionMessageRequire {
    private List<Dish> dishes;
    private List<RelatedProduct> relatedProducts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dish {
        private String dishName;
        private String description;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RelatedProduct {
        private String name;
    }
}
