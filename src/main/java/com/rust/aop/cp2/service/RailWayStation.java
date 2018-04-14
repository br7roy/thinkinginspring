package com.rust.aop.cp2.service;

/**
 * FileName: RailWayStation
 * Author:   Rust
 * Date:     2018/4/12
 * Description: RailwayStation 实现 TicketService
 * History:
 */
public class RailWayStation implements TicketService {
    @Override
    public void sellTicket() {
        System.out.println("售票............");
    //    make some problem
    //    String str = null;
    //    str.equals("");

    }

    @Override
    public void inquire() {
        System.out.println("问询.............");
    }

    @Override
    public void withdraw() {
        System.out.println("退票.............");
    }
}
