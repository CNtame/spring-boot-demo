package com.spring.demo.config;

import com.spring.demo.common.ApiResponse;
import com.spring.demo.common.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2020/11/12
 */
@Slf4j
@ControllerAdvice
@Component
public class GlobalExceptionHandler {


    /**
     * Spring容器注入MethodValidationPostProcessor对象
     *
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }


    /**
     *  没有此接口
     * 查找有没有对应的url，若没有则会抛该异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ApiResponse handle_404(NoHandlerFoundException e) {
        log.error(e.toString());
        return ApiResponse.fail(CodeMsg.urlWrong.getCode(), CodeMsg.urlWrong.getMsg());
    }

    /**
     * valid中缺少参数
     * @param
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handle(ConstraintViolationException e) {
        log.error(e.toString());
        return ApiResponse.fail(CodeMsg.paramsLess.getCode(), CodeMsg.paramsLess.getMsg());
    }

    /**
     * @RequstBody
     * 缺少实体 没有Body
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ApiResponse handle_BOdy(HttpMessageNotReadableException e) {
        log.error(e.toString());
        return ApiResponse.fail(CodeMsg.paramsLess.getCode(), CodeMsg.paramsLess.getMsg());
    }
    /**
     * 未检测到路径参数
     * 参数签名@PathVariable
     */
    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    public ApiResponse handle_Path(MissingPathVariableException e) {

        log.error(e.toString());
        return ApiResponse.fail(CodeMsg.pathParamsWrong.getCode(), CodeMsg.pathParamsWrong.getMsg());
    }

    /**
     * 请求方式错误
     * 如post 用get
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ApiResponse handle2(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        log.error(e.toString());
        return ApiResponse.fail(CodeMsg.requestMethodWrong.getCode(), CodeMsg.requestMethodWrong.getMsg());
    }

    /**
     * 缺少请求参数。
     * @param
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ApiResponse handle3(MissingServletRequestParameterException e) {
        log.error(e.toString());
        return ApiResponse.fail(CodeMsg.paramsLess.getCode(), CodeMsg.paramsLess.getMsg());
    }

    /**
     * 然后再对请求头与控制器支持的做比较，
     * 比如content-type请求头，若控制器的参数签名包含注解@RequestBody，
     * 但是请求的content-type请求头的值没有包含application/json，那么会抛该异常
     * （当然，不止这种情况会抛这个异常）
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public ApiResponse handle4(HttpMediaTypeNotSupportedException e) {
        log.error(e.toString());
        return ApiResponse.fail(CodeMsg.headerWrong.getCode(), CodeMsg.headerWrong.getMsg());
    }
}
