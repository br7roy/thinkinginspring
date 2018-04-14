package com.rust.aop.cp2.realbattle;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * FileName: FilterAdvisor
 * Author:   Rust
 * Date:     2018/4/13
 * Description: 实现一个PointcutAdvisor，通过提供的Pointcut,对Advice的执行进行过滤
 * History:
 */
public class FilterAdvisor implements PointcutAdvisor {

    private Pointcut pointcut;
    private Advice advice;

    public FilterAdvisor(Pointcut pointcut, Advice advice) {
        this.pointcut = pointcut;
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
