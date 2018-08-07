package com.iblogstreet.apigate.service;

import com.iblogstreet.apigate.pojo.User;

/**
 * @author Armyone
 * @date 2018/8/7 15:17
 * @desc
 */

public interface UserService {

    /**
     * @param user
     * @return
     */
    User login(User user);
}
