package com.zbf.auth.mapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "feign11")
public interface LoginPhone {
    @RequestMapping("/dd")
    boolean dd(@RequestParam("tel") String tel);
}
