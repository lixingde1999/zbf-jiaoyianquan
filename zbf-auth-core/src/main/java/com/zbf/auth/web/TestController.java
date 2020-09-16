package com.zbf.auth.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LCG
 * 作者: LCG
 * 日期: 2020/9/9  20:24
 * 描述:
 */
@RestController
public class TestController {


    @RequestMapping("test")
    public String test(){
        return "OK==测试";
    }

}
