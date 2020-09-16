package com.zbf.auth.web;

import com.zbf.auth.mapper.LoginPhone;
import com.zbf.common.utils.MailQQUtils;
import com.zbf.common.utils.RanDomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
public class YzmRedis {

    private static final Pattern PATTERN_PHONE = Pattern.compile("^-?\\d+(\\.\\d+)?$");
    @Autowired
    private LoginPhone loginPhone;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @RequestMapping("/getyzm")
    public boolean getyzm(@RequestParam("tel") String tel){
        if(isPhone(tel)){
            return loginPhone.dd(tel);
        }else{
            System.out.println(tel);
            String fourRandom = RanDomUtils.getFourRandom();
            redisTemplate.opsForValue().set("yzm",fourRandom);
            MailQQUtils.sendMessage(tel,fourRandom,"李氏科技");
            System.out.println(fourRandom);
            return  true;
        }






    }
    public boolean isPhone(String phone){
        return PATTERN_PHONE.matcher(phone).matches();
    }
}
