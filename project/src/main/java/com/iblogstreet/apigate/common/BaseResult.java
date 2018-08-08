package com.iblogstreet.apigate.common;

/**
 * Created by 13 on 17/6/26.
 */
public class BaseResult {
    private static final long serialVersionUID = 1L;
    private int status;
    private String message;

    public BaseResult() {
    }

    public BaseResult(int resultCode, String message) {
        this.status = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return status;
    }

    public void setResultCode(int resultCode) {
        this.status = resultCode;
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
                "resultCode=" + status +
                ", message='" + message + '\'' +

                '}';
    }

}
