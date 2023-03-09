package com.pcer.exception;

import lombok.Data;

/**
 * @author Cola
 * @description 封装了code和message的异常类
 * @date 2022/1/15
 * @email 1020151695@qq.com
 */
@Data
public class EnumException extends RuntimeException{
    Integer code;
    String message;

    EnumException(ExceptionAssert enumExceptionAssert){
        this.code = enumExceptionAssert.getCode();
        this.message = enumExceptionAssert.getMessage();
    }
}
