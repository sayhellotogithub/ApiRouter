package com.iblogstreet.apigate.service;

import com.iblogstreet.apigate.dao.UserDao;
import com.iblogstreet.apigate.pojo.User;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Armyone
 * @date 2018/8/7 15:31
 * @desc
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
