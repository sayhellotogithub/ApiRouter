package com.iblogstreet.apigate.controller;

import com.iblogstreet.apigate.common.BaseResult;
import com.iblogstreet.apigate.common.Result;
import com.iblogstreet.apigate.common.ResultGenerator;
import com.iblogstreet.apigate.model.User;
import com.iblogstreet.apigate.pojo.UserBean;
import com.iblogstreet.apigate.service.UserService;
import com.iblogstreet.apigate.util.MD5Util;
import com.iblogstreet.apigate.util.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Message.RESULT_CODE_ERROR_PARAM;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Message.USER_ID_EMPTY;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Message.USER_PASSWORD_EMPTY;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Message.USER_USERNAME_EMPTY;

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
     * @param userBean
     * @return
     */
    @RequestMapping(value = "/cookie", method = RequestMethod.POST)
    public Result login(UserBean userBean) {
        try {
            String MD5pwd = MD5Util.MD5Encode(userBean.getPassword(), "UTF-8");
            userBean.setPassword(MD5pwd);
        } catch (Exception e) {
            userBean.setPassword("");
        }
        UserBean resultUserBean = userService.login(userBean);
        log.info("request: userBean/login , userBean: " + userBean.toString());
        if (resultUserBean == null) {
            return ResultGenerator.genFailResult("请认真核对账号、密码！");
        } else {
            resultUserBean.setPassword("PASSWORD");
            Map data = new HashMap();
            data.put("currentUser", resultUserBean);
            return ResultGenerator.genSuccessResult(data);
        }
    }

    @RequestMapping(value = "/ids", method = RequestMethod.GET)
    public Result selectByPrimaryKey(Integer id) {
        User user = userService.selectByPrimaryKey(id);
        log.info("request:" + user.toString());
        return ResultGenerator.genSuccessResult(user);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public BaseResult save(User user) {
        if (null == user) {
            return ResultGenerator.genParamError(RESULT_CODE_ERROR_PARAM);
        }
        if (StringUtil.isEmpty(user.getPassword())) {
            return ResultGenerator.genParamError(USER_PASSWORD_EMPTY);
        }
        if (StringUtil.isEmpty(user.getUserName())) {
            return ResultGenerator.genParamError(USER_USERNAME_EMPTY);
        }
        int resultTotal = 0;
        String md5Pwd = MD5Util.MD5Encode(user.getPassword(), "utf-8");
        user.setPassword(md5Pwd);
        resultTotal = userService.insertSelective(user);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genServerError();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public BaseResult update(User user) {
        if (null == user) {
            return ResultGenerator.genParamError(RESULT_CODE_ERROR_PARAM);
        }
        if (null == user.getId()) {
            return ResultGenerator.genParamError(USER_ID_EMPTY);
        }
        if (!StringUtil.isEmpty(user.getPassword())) {
            String md5Pwd = MD5Util.MD5Encode(user.getPassword(), "utf-8");
            user.setPassword(md5Pwd);
        }
        int resultTotal = userService.updateByPrimaryKeySelective(user);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genServerError();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseResult delete(@PathVariable(value = "id") Integer id) {
        if (null == id) {
            return ResultGenerator.genParamError(USER_ID_EMPTY);
        }
        int resultTotal = userService.deleteByPrimaryKey(id);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genServerError();
        }
    }

}
