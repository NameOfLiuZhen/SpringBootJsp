package com.h3c.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("t_role_per")
public class RolePer implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    private Integer roleId;

    private Integer perId;


}
