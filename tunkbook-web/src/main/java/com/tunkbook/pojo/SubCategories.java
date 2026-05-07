package com.tunkbook.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("subcategory")
public class SubCategories {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("category_id")
    private Integer categoryId;
    @TableField("subcategory_name")
    private String subcategoryName;
    @TableField("subcategory_img")
    private String subcategoryImg;
}
