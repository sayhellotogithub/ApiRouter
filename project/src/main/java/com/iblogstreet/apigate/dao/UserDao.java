package com.iblogstreet.apigate.dao;

import com.iblogstreet.apigate.pojo.UserBean;

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
     * @param userBean
     * @return
     */

    @Results(id = "userResult", value = {
            @Result(property = "userName", column = "user_name"),
            @Result(property = "roleName", column = "role_name")})
    @Select(" select id,password,role_name,user_name from ssm_user where user_name=#{userName} and password=#{password} limit 1")
    UserBean login(UserBean userBean);

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
