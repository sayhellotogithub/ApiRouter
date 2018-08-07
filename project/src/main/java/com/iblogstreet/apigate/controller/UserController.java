package com.iblogstreet.apigate.controller;

import com.iblogstreet.apigate.common.Result;
import com.iblogstreet.apigate.common.ResultGenerator;
import com.iblogstreet.apigate.pojo.User;
import com.iblogstreet.apigate.service.UserService;
import com.iblogstreet.apigate.util.MD5Util;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * @author Armyone
 * @date 2018/8/7 15:14
 * @desc
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;
    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @RequestMapping( value = "/cookie" ,method = RequestMethod.POST)
    public Result login(User user) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        User resultUser = userService.login(user);
        log.info("request: user/login , user: " + user.toString());
        if (resultUser == null) {
            return ResultGenerator.genFailResult("请认真核对账号、密码！");
        } else {
            resultUser.setPassword("PASSWORD");
            Map data = new HashMap();
            data.put("currentUser", resultUser);
            return ResultGenerator.genSuccessResult(data);
        }
    }
}
