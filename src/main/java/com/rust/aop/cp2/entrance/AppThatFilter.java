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
 * FileName: AppThatFilter
 * Author:   Rust
 * Date:     2018/4/13
 * Description:
 * History:
 */
public class AppThatFilter {
    public static void main(String[] args) {
        //创建advice
        Advice beforeAdvice = new TicketServiceBeforeAdvice();
        Advice afterReturnAdvice = new TicketServiceAfterReturningAdvice();
        Advice aroundAdvice = new TicketServiceAroundAdvice();
        Advice throwAdvice = new TicketServiceThrowAdvice();
        //创建service
        RailWayStation railWayStation = new RailWayStation();

        //2.创建ProxyFactoryBean,用以创建指定对象的Proxy对象
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //3.设置Proxy的接口
        proxyFactoryBean.setInterfaces(TicketService.class);
        //4. 设置RealSubject
        proxyFactoryBean.setTarget(railWayStation);
        //5.使用JDK基于接口实现机制的动态代理生成Proxy代理对象，如果想使用CGLIB，需要将这个flag设置成true
        proxyFactoryBean.setProxyTargetClass(false);

        //6. 添加不同的Advice
        //proxyFactoryBean.addAdvice(beforeAdvice);
        proxyFactoryBean.addAdvice(afterReturnAdvice);
        proxyFactoryBean.addAdvice(aroundAdvice);
        proxyFactoryBean.addAdvice(throwAdvice);




        AspectJExpressionPointcut aep = new AspectJExpressionPointcut();
        aep.setExpression("execution( * sellTicket(..))");
        FilterAdvisor filterAdvisor = new FilterAdvisor(aep, beforeAdvice);

        proxyFactoryBean.addAdvisor(filterAdvisor);


        //7.通过ProxyFactoryBean生成Proxy对象
        TicketService ticketService = (TicketService) proxyFactoryBean.getObject();
        ticketService.sellTicket();
        System.out.println("---------");
        ticketService.inquire();




    }
}
