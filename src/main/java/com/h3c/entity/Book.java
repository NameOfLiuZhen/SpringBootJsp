package com.h3c.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book implements Serializable {

    @TableId(value = "id",type= IdType.INPUT)
    private String id;

    @TableField("book_name")
    private String name;

    @TableField("book_price")
    private Double price;

    @TableField("deleted")
    private Integer deleted;

}
