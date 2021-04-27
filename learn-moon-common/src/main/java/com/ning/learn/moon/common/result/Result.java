package com.ning.learn.moon.common.result;

import lombok.ToString;

/**
 * @Author: wudening
 * @Description: 统一封装结果类
 * @Date: 2021/4/27 3:06 下午
 */
@ToString
public class Result<T> {

    public static final int ERRCODE_SUCCESS = 0;
    public static final int ERRCODE_FAIL = 1;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int status;
    private String msg;
    private T data;

    public Result(int status, String msg, T data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public Result() {
    }


    public T getData() {

        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /***
     * 创建空的 无数据的 成功返回对象
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> createOK() {
        Result<T> ok = new Result<>(ERRCODE_SUCCESS, "");
        return ok;
    }

    /***
     * 创建空的 无数据的 成功返回对象
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> createFail() {
        Result<T> fail = new Result<>(ERRCODE_FAIL, "");
        return fail;
    }

    /***
     * 创建空的 无数据的 成功返回对象
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> createFail(String message) {
        Result<T> fail = new Result<>(ERRCODE_FAIL, "");
        fail.setMsg(message);
        return fail;
    }

    public static <T> Result<T> createFail(Integer status, String message) {
        Result<T> fail = new Result<>(status, message);
        return fail;
    }

    public static <T> Result<T> createFail(Integer status, String message, T data) {
        Result<T> fail = new Result<>(status, message, data);
        return fail;
    }

    /**
     * 根据返回的数据，创建成功的返回对象
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> createOK(T data) {
        Result<T> ok = createOK();
        ok.setMsg("数据访问成功");
        ok.setData(data);
        return ok;
    }


    public static <T> Result<T> createOK(T data, String message) {
        Result<T> ok = createOK();
        ok.setMsg(message);
        ok.setData(data);
        return ok;
    }
}


