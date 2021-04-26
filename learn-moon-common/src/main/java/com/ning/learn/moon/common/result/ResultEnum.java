package com.ning.learn.moon.common.result;

/**
 * @Author: wudening
 * @Description: 结果枚举
 * @Date: 2021/4/26 8:36 下午
 */
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS("0", "成功"),

    /**
     * 失败
     */
    FAIL("1", "失败");


    /**
     * 错误编码
     */
    private String code;
    /**
     * 错误消息
     */
    private String msg;

    ResultEnum() {
    }

    /**
     * 构造方法
     *
     * @param code 返回码
     * @param msg  返回消息
     */
    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取 错误编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置 错误编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 错误消息
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * 设置 错误消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultCodeEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                "} " + super.toString();
    }
}
