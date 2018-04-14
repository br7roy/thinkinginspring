package com.rust.aop.framework;

import java.util.Date;

/**
 * FileName: TimeTest
 * Author:   Rust
 * Date:     2018/4/13
 * Description:
 * History:
 */
public class TimeTest {
    public static void main(String[] args) {
        long timeUnix = 1523585419189L;

        Date date = new Date(timeUnix);

        System.out.println(date);
    }
}
