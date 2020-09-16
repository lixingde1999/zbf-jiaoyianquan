package com.zbf.user.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbf.common.utils.MailQQUtils;
import com.zbf.common.utils.RanDomUtils;
import com.zbf.user.entity.User;
import com.zbf.user.mapper.LoginPhone;
import com.zbf.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
public class YzmRedis {
    private static final Pattern PATTERN_EMAIL = Pattern.compile("^\\w+@\\w+([-]\\w+)*(\\.\\w+)+$");
    private static final Pattern PATTERN_PHONE = Pattern.compile("^-?\\d+(\\.\\d+)?$");
    @Autowired
    private LoginPhone loginPhone;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private IUserService userService;
    @RequestMapping("/getyzm")
    public boolean getyzm(@RequestParam("tel") String tel){
       if(isPhone(tel)){
         return   loginPhone.dd(tel);
       }else if(isEmail(tel)){
           String fourRandom = RanDomUtils.getFourRandom();
           MailQQUtils.sendMessage(tel,fourRandom,"科基金");
           return  true;
       }
     return false;




    }
    @RequestMapping("/getyzm2")
    public boolean getyzm2(@RequestParam("tel") String tel){
        try {
            if(isPhone(tel)){
                QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
                userQueryWrapper.eq("tel",tel);
                User one = userService.getOne(userQueryWrapper);
                if(one != null){
                    loginPhone.dd(tel);
                    return true;
                }
                return false;

            }else if (isEmail(tel)){
                QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
                userQueryWrapper.eq("email",tel);
                User one = userService.getOne(userQueryWrapper);
                if(one != null){
                    String fourRandom = RanDomUtils.getFourRandom();
                    MailQQUtils.sendMessage(tel,fourRandom,"科基金");
                    return  true;
                }else {
                    return false;            }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
    public boolean isPhone(String phone){
        return PATTERN_PHONE.matcher(phone).matches();
    }
    // 邮箱验证正则比对
    public boolean isEmail(String email){
        return PATTERN_EMAIL.matcher(email).matches();
    }
}
