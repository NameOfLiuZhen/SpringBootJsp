package com.h3c.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User implements Serializable {


    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("pwd")
    private String pwd;

    @TableField("status")
    private Integer status;

}
