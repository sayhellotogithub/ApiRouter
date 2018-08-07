package com.iblogstreet.apigate.dao;

import com.iblogstreet.apigate.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Armyone
 * @date 2018/8/7 15:32
 * @desc
 */
@Mapper
public interface UserDao {
    /**
     * @param user
     * @return
     */

    @Results(id = "userResult", value = {
            @Result(property = "userName", column = "user_name"),
            @Result(property = "roleName", column = "role_name")})
    @Select(" select id,password,role_name,user_name from ssm_user where user_name=#{userName} and password=#{password} limit 1")
    User login(User user);

    /**
     * 查找用户
     *
     * @param map
     * @return
     */
    List<User> findUsers(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    Long getTotalUser(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(Integer id);
}
