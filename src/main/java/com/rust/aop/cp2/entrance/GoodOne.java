package com.rust.aop.cp2.entrance;

import org.aopalliance.aop.Advice;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;

import com.rust.aop.cp2.advice.TicketServiceAfterReturningAdvice;
import com.rust.aop.cp2.advice.TicketServiceAroundAdvice;
import com.rust.aop.cp2.advice.TicketServiceBeforeAdvice;
import com.rust.aop.cp2.advice.TicketServiceThrowAdvice;
import com.rust.aop.cp2.realbattle.FilterAdvisor;
import com.rust.aop.cp2.service.RailWayStation;
import com.rust.aop.cp2.service.TicketService;

/**
 * FileName: GoodOne
 * Author:   Rust
 * Date:     2018/4/13
 * Description:
 * History:
 */
public class GoodOne {
    public static void main(String[] args) {
        //1.针对不同的时期类型，提供不同的Advice
        Advice beforeAdvice = new TicketServiceBeforeAdvice();
        Advice afterReturningAdvice = new TicketServiceAfterReturningAdvice();
        Advice aroundAdvice = new TicketServiceAroundAdvice();
        Advice throwsAdvice = new TicketServiceThrowAdvice();

        RailWayStation railwayStation = new RailWayStation();

        //2.创建ProxyFactoryBean,用以创建指定对象的Proxy对象
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //3.设置Proxy的接口
        proxyFactoryBean.setInterfaces(TicketService.class);
        //4. 设置RealSubject
        proxyFactoryBean.setTarget(railwayStation);
        //5.使用JDK基于接口实现机制的动态代理生成Proxy代理对象，如果想使用CGLIB，需要将这个flag设置成true
        proxyFactoryBean.setProxyTargetClass(true);

        //5. 添加不同的Advice

        proxyFactoryBean.addAdvice(afterReturningAdvice);
        proxyFactoryBean.addAdvice(aroundAdvice);
        proxyFactoryBean.addAdvice(throwsAdvice);
        //proxyFactoryBean.addAdvice(beforeAdvice);
        proxyFactoryBean.setProxyTargetClass(false);

        //手动创建一个pointcut,专门拦截sellTicket方法
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution( * sellTicket(..))");
        //传入创建的beforeAdvice和pointcut
        FilterAdvisor sellBeforeAdvior = new FilterAdvisor(pointcut,beforeAdvice);
        //添加到FactoryBean中
        proxyFactoryBean.addAdvisor(sellBeforeAdvior);

        //通过ProxyFactoryBean生成
        TicketService ticketService = (TicketService) proxyFactoryBean.getObject();
        ticketService.sellTicket();
        System.out.println("---------------------------");
        ticketService.inquire();


    }
}
