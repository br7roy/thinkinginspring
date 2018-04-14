package com.rust.aop.cp2.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * FileName: TicketServiceBeforeAdvice
 * Author:   Rust
 * Date:     2018/4/12
 * Description: 执行RealSubject对象的方法之前的处理意见
 * History:
 */
public class TicketServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BEFORE_ADVICE: 欢迎光临代售点....");

    }
}
