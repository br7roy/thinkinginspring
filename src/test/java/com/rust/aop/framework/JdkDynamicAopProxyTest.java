package com.rust.aop.framework;

/**
 * FileName: JdkDynamicAopProxyTest
 * Author:   Rust
 * Date:     2018/4/13
 * Description:
 * History:
 */
public class JdkDynamicAopProxyTest {
    public static void main(String[] args) {
        Class returnType = String.class;
        String s = "";

        System.out.println(returnType.isInstance(s));

        Class type = Void.TYPE;

        System.out.println(type.isPrimitive());

        Class type2 = Integer.TYPE;
        System.out.println(type2.isPrimitive());


    }
}
