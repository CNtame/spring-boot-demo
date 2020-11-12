package com.spring.demo.common;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/12
 */
public class ApiResponse <T>{

    private Integer code;
    private T data;
    private String msg;
    private Integer count;

    @Override
    public String toString() {
        return "APIResponse{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                '}';
    }

    public ApiResponse(){

    }

    public ApiResponse(Integer code){
        this.code = code;
    }

    public ApiResponse(Integer code, T data){
        this.code = code;
        this.data = data;
    }

    public ApiResponse(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功不返回数据
     */
    public static ApiResponse success(){
        return new ApiResponse(CodeMsg.SUCCESS.getCode(),CodeMsg.SUCCESS.getMsg());
    }

    /**
     * 成功返回 string
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(String msg){
        return new ApiResponse<T>(CodeMsg.SUCCESS.getCode(),msg);
    }

    /**
     * 成功返回数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(CodeMsg.SUCCESS.getCode(), data);
    }

    /**
     * 失败 string
     * @param msg
     * @return
     */
    public static ApiResponse fail(String msg){
        return new ApiResponse(CodeMsg.FAIL.getCode(), msg);
    }

    /**
     * 失败 code +数据
     * @param code
     * @param msg
     * @return
     */
    public static ApiResponse fail(Integer code, String msg){
        return  new ApiResponse(code,msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
