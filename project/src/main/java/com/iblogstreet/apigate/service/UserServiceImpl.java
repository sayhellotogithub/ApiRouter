package com.iblogstreet.apigate.service;

import com.iblogstreet.apigate.dao.UserDao;
import com.iblogstreet.apigate.mapper.UserMapper;
import com.iblogstreet.apigate.model.User;
import com.iblogstreet.apigate.pojo.UserBean;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Resource
    UserMapper userMapper;

    @Override
    public UserBean login(UserBean userBean) {
        return userDao.login(userBean);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserBean> findUsers(Map<String, Object> map) {
        return userDao.findUsers(map);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map) {
        return userDao.getTotalUser(map);
    }
}
