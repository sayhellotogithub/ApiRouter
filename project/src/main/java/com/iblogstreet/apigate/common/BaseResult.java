package com.iblogstreet.apigate.common;

/**
 * Created by 13 on 17/6/26.
 */
public class BaseResult {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;

    public BaseResult() {
    }

    public BaseResult(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +

                '}';
    }

}
