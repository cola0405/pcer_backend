package com.pcer.entity.res;

import com.pcer.exception.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cola
 * @description controller返回结果类（含数据）
 * @date 2022/2/4
 */
@Data
@AllArgsConstructor
public class RD {
    Integer code;
    String message;
    public Map<String, Object> data = new HashMap<>(1);


    public RD(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public RD(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static RD codeEnum(int code, String message) {
        return new RD(code, message);
    }

    public static RD success() {
        return new RD(CodeEnum.success.code, "成功");
    }

    public static RD fail() {
        return new RD(CodeEnum.fail.code, "失败");
    }

    public RD putData(String key, Object obj) {
        this.data.put(key, obj);
        return this;
    }
}
