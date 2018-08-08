package com.iblogstreet.apigate.service;

import com.iblogstreet.apigate.mapper.UserMapper;
import com.iblogstreet.apigate.model.User;
import com.iblogstreet.apigate.pojo.UserBean;

import java.util.List;
import java.util.Map;

/**
 * @author Armyone
 * @date 2018/8/7 15:17
 * @desc
 */

public interface UserService   {

    /**
     * @param userBean
     * @return
     */
    UserBean login(UserBean userBean);
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 查找用户
     *
     * @param map
     * @return
     */
    List<UserBean> findUsers(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    Long getTotalUser(Map<String, Object> map);
}
