package com.tunkbook.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategories {
    private Integer id;
    private Integer categoryId;
    private String subcategoryName;
}
