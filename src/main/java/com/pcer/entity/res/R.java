package com.pcer.entity.res;

import com.pcer.exception.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Cola
 * @description
 * @date 2022/1/15
 * @email 1020151695@qq.com
 */
@Data
@AllArgsConstructor
public class R {
    private Integer code;
    private String message;

    public static R codeEnum(int code,String message){
        return new R(code,message);
    }

    public static R success(){
        return new R(CodeEnum.success.code, "成功");
    }
    public static R fail(){
        return new R(CodeEnum.fail.code, "失败");
    }
}
