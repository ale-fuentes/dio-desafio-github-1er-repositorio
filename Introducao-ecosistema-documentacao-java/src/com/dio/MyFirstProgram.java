package com.dio;

import com.dio.base.Order;

import java.math.BigDecimal;

public class MyFirstProgram {
    public static void main(String[] args){
        final Order order = new Order("code1234", new BigDecimal(10_000D));
        System.out.println(order);
    }
}