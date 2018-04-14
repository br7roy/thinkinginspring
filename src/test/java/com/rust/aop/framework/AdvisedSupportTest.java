package com.rust.aop.framework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.Advisor;

/**
 * FileName: AdvisedSupportTest
 * Author:   Rust
 * Date:     2018/4/13
 * Description:
 * History:
 */
public class AdvisedSupportTest {

    List<Advisor> advisors = new LinkedList<Advisor>();

    Advisor[] advisorArray = new Advisor[0];


    @Test
    public void test() {
        advisors.add(new Advisor() {
            @Override
            public Advice getAdvice() {
                return null;
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        });

        System.out.println(System.currentTimeMillis());
        this.advisorArray = this.advisors.toArray(new Advisor[this.advisors.size()]);
        System.out.println(Arrays.toString(this.advisorArray));
        //toArray()的返回值是一个Object的数组，Object[]，这个数组是不可以进行强制数据转换的。
        //this.advisorArray = (Advisor[]) this.advisors.toArray();

        if (Advisor[].class.isInstance(advisors)) {
            System.out.println("1" + true);
        }


    }
}
