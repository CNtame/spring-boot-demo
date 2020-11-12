package com.spring.demo.common;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/12
 */
public enum CodeMsg {

    //成功状态码
    SUCCESS(1,"成功"),
    //失败状态码
    FAIL(0,"失败"),
    paramsLess(10, "参数缺失"),
    requestMethodWrong(20, "请求方式错误"),
    headerWrong(30, "请求头错误"),
    urlWrong(40, "后端接口没有此url"),
    webWrong(50, "后台错误，没有后台控制器"),
    pathParamsWrong(50, "缺少路径参数"),
    noAuthority(60, "缺少权限"),
    noData(70, "没有数据"),
    MoreData(80, "过多数据");

    private int code;

    private String msg;

    CodeMsg(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
