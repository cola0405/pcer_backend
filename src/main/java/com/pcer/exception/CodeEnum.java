package com.pcer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Cola
 * @description 错误类型枚举类
 * @date 2022/1/15
 * @email 1020151695@qq.com
 */
@AllArgsConstructor
public enum CodeEnum implements ExceptionAssert{
    success(200, "成功"),
    fail(400, "失败"),
    no_login(201, "账号未登录"),
    wrong_parameter(202, "参数错误"),
    no_role(203, "缺少权限"),
    wrong_password(204, "密码错误"),
    wrong_request_method(205, "请求方法错误"),
    error(500, "系统异常");

    public int code;
    public String message;

    /**
    * @author cola
    * @description 实现ExceptionAssert接口是为了再assert时，抛出的异常能获取到code和message
    * @date 2022/1/16
    * @email 1020151695@qq.com
    */
    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
