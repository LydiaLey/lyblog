package com.ly.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.entity.User;
import com.ly.mapper.UserMapper;
import com.ly.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lydia
 * @date 2020/9/17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
