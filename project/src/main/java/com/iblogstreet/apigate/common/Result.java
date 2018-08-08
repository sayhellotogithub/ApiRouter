package com.iblogstreet.apigate.common;

/**
 * Created by 13 on 17/6/26.
 */
public class Result<T> extends BaseResult {
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        super(resultCode, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + getResultCode() +
                ", message='" + getMessage() + '\'' +
                ", data={" + data.toString() + "}" +
                '}';
    }

}
