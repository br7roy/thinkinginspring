package com.rust.aop.cp2.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * FileName: TicketServiceThrowAdvice
 * Author:   Rust
 * Date:     2018/4/12
 * Description: 抛出异常时的处理意见
 * History:
 */
public class TicketServiceThrowAdvice implements ThrowsAdvice{

    public void afterThrowing(Exception ep) {
        System.out.println("AFTER_THROWING....");
    }

    public void afterThrowing(Method method, Object[] objects, Object target, Exception ep) {
        System.out.println("调用过程出错啦！！！！！");
    }



}
