package com.iblogstreet.apigate.common;


import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Code.RESULT_CODE_FORBIDDEN;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Code.RESULT_CODE_PARAM;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Code.RESULT_CODE_SERVER_ERROR;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Code.RESULT_CODE_SUCCESS;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Message.DEFAULT_FAIL_MESSAGE;
import static com.iblogstreet.apigate.common.ResultErrorStatusConstants.Message.RESULT_CODE_SUCCESS_MESSAGE;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(RESULT_CODE_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(RESULT_CODE_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result genFailResult(String message) {
        return genFailResult(message, RESULT_CODE_SERVER_ERROR);
    }


    public static Result genFailResult(String message, int code) {
        Result result = new Result();
        result.setResultCode(code);
        if (message == null || message.length() < 1) {
            message = DEFAULT_FAIL_MESSAGE;
        }
        result.setMessage(message);
        return result;
    }

    /**
     * 服务器错误
     *
     * @param message
     * @return
     */
    public static Result genServerError(String message) {
        return genFailResult(message, RESULT_CODE_SERVER_ERROR);
    }

    /**
     * 服务器错误
     *
     * @return
     */
    public static Result genServerError() {
        return genFailResult(ResultErrorStatusConstants.Message.RESULT_CODE_SERVER_ERROR_MESSAGE, RESULT_CODE_SERVER_ERROR);
    }

    /**
     * 禁止访问
     *
     * @return
     */
    public static Result genForbidenENError() {
        return genFailResult(ResultErrorStatusConstants.Message.RESULT_CODE_FORBIDDEN_MESSAGE, RESULT_CODE_FORBIDDEN);
    }

    /**
     * 参数错误
     *
     * @return
     */
    public static Result genParamError(String message) {
        return genFailResult(message, RESULT_CODE_PARAM);
    }

}
