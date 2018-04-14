package com.rust.test0413;

/**
 * FileName: ClassInstanceConfirm
 * Author:   Rust
 * Date:     2018/4/13
 * Description:
 * History:
 */
public class ClassInstanceConfirm {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        //ClassB是ClassA的子类

        System.out.println(classB instanceof ClassA);

        // 不支持向上转型，所以返回false
        System.out.println(classB.getClass().isInstance(classA));

        // 不支持向上转型，所以返回false
        System.out.println(classB.getClass().isAssignableFrom(ClassA.class));

        System.out.println(classA.getClass().isInstance(classB));

        System.out.println(classA.getClass().isAssignableFrom(ClassB.class));


    }
}
