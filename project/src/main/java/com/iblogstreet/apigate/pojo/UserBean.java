package com.iblogstreet.apigate.pojo;

import com.iblogstreet.apigate.model.User;

/**
 * @author Armyone
 * @date 2018/8/7 15:27
 * @desc
 */

public class UserBean extends User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", userName='" + getUserName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", roleName='" + getRoleName() + '\'' +
                '}';
    }
}
