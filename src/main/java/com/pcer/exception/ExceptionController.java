package com.pcer.exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.pcer.entity.res.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Cola
 * @description
 * @date 2022/1/15
 * @email 1020151695@qq.com
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = EnumException.class)
    public R handleException(EnumException e){
        return R.codeEnum(e.code,e.message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R catchAllException(Exception e) {
        log.error(e.getMessage());
        if (e instanceof InvalidFormatException) {
            return R.codeEnum(CodeEnum.wrong_parameter.code,"请求参数错误");
        } else if (e instanceof HttpMessageNotReadableException) {
            return R.codeEnum(CodeEnum.wrong_parameter.code,"请求参数错误");
        }else if(e instanceof HttpMediaTypeNotSupportedException){
            return R.codeEnum(CodeEnum.wrong_parameter.code,"POST要求json格式数据及请求头");
        }else if(e instanceof HttpRequestMethodNotSupportedException){
            return R.codeEnum(CodeEnum.wrong_request_method.code,"请求方法有误");
        }
        log.error("\n\r系统异常!", e);
        return R.codeEnum(CodeEnum.error.code,"系统异常!");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public R validatorHandler(MethodArgumentNotValidException e){
        return R.codeEnum(CodeEnum.fail.code, e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
