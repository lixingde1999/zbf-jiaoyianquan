package com.zbf.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Description TODO
 * @Author 冀培银
 * @Date 2020/9/16 8:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("base_role")
public class Role implements Serializable {

    @TableId("id")
    private long id;

    @TableField("role_code")
    private String roleCode;

    @TableField("name")
    private String name;

    @TableField("miaoshu")
    private String miaoshu;
}
