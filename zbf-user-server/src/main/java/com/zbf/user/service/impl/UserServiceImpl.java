package com.zbf.user.service.impl;

import com.zbf.user.entity.User;
import com.zbf.user.mapper.UserMapper;
import com.zbf.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 冀培银
 * @since 2020-09-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
