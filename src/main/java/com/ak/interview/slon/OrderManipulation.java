package com.ak.interview.slon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderManipulation {

    public static void main(String args[])
    {
        List<Order> orders = new ArrayList<>();
        Order order = new Order(new Date(204587433443L), "Alex");//1976/06/26 00:50:33
        orders.add(order);
        System.out.println(order);

        get(orders).forEach(System.out::println);
    }

    public static List<String> get(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .map(Order::getName)
                .collect(Collectors.toList());
    }
}
