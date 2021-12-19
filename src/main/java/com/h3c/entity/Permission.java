package com.h3c.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xushy
 * @since 2021-12-15
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_per")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField("permission")
    private String permission;

    @TableField("remark")
    private String remark;


}
