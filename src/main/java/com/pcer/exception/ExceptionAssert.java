package com.pcer.exception;

/**
 * @author Cola
 * @description 断言判断是否抛出错误
 * @date 2022/1/15
 * @email 1020151695@qq.com
 */
public interface ExceptionAssert {
    int getCode();
    String getMessage();

    default void assertIsEquals(Object o1, Object o2) throws Exception {
        if(o1==null){
            // o1为null的话，无法调equals()
            throw  new EnumException(this);
        }
        if(!o1.equals(o2)){
            /**
             * CodeEnum.fail.assertIsEquals(1,2);
             * fail 实际上会返回一个枚举对象
             * this 在使用中，传递过去的是包含了code和message的实现了断言类的CodeEnum对象
             */
            throw new EnumException(this);
        }
    }
}
