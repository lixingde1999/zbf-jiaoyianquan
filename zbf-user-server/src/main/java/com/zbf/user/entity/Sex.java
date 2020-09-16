package com.zbf.user.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Sex {
    man("男",1),
    nv("女",2);

    @JsonValue
    private String label;
    @EnumValue
    private Integer value;
    Sex(String label,Integer value){
        this.label=label;
        this.value=value;
    }
}
