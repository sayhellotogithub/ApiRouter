package com.iblogstreet.apigate.common;

/**
 * @author Armyone
 * @date 2018/8/8 11:12
 * @desc
 */

public interface ResultErrorStatusConstants {
    String ARTICLE_CACHE_KEY = "perfect-ssm:article:";//文章key
    String PICTURE_CACHE_KEY = "perfect-ssm:picture:";//图片key

    class Code {
        public static final int RESULT_CODE_SUCCESS = 200;  // 成功处理请求
        public static final int RESULT_CODE_NO_DATA = 201;//未找到对象
        public static final int RESULT_CODE_PARAM = 202;//参数不正确

        public static final int RESULT_CODE_UNAUTHORIZED = 401;//无权限
        public static final int RESULT_CODE_FORBIDDEN = 403;//禁止访问
        public static final int RESULT_CODE_GONE = 410;//无此资源
        public static final int RESULT_CODE_BAD_REQUEST = 412;  // bad request

        public static final int RESULT_CODE_SERVER_ERROR = 500;  // 服务器发生错误
    }

    class Message {
        //        public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
        public static final String DEFAULT_FAIL_MESSAGE = "处理请求失败";
        public static final String RESULT_CODE_SUCCESS_MESSAGE = "成功处理请求";
        public static final String RESULT_CODE_NO_DATA_MESSAGE = "未找到对象";

        public static final String RESULT_CODE_UNAUTHORIZED_MESSAGE = "无权限";
        public static final String RESULT_CODE_FORBIDDEN_MESSAGE = "禁止访问";
        public static final String RESULT_CODE_GONE_MESSAGE = "无此资源";
        public static final String RESULT_CODE_BAD_REQUEST_MESSAGE = "bad request";
        public static final String RESULT_CODE_SERVER_ERROR_MESSAGE = "服务器发生错误";
        public static final String RESULT_CODE_ERROR_PARAM = "参数不能为空";

        //用户模块
        public static final String USER_PASSWORD_EMPTY = "用户密码不能为空";
        public static final String USER_USERNAME_EMPTY = "用户名不能为空";
        public static final String USER_ID_EMPTY = "用户id不能为空";
    }
}
