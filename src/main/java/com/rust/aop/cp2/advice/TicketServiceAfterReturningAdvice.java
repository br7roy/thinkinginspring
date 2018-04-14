package com.rust.aop.cp2.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * FileName: TicketServiceAfterReturningAdvice
 * Author:   Rust
 * Date:     2018/4/12
 * Description: 返回结果时后的处理意见
 * History:
 */
public class TicketServiceAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("AFTER_RETURNING：本次服务已结束....");
    }
}
