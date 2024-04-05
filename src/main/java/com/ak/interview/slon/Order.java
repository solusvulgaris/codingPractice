package com.ak.interview.slon;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Comparable<Order> {
    @Getter
    @Setter
    Date date;
    @Getter
    @Setter
    String name;

    public Order(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull Order o) {
        return this.date.compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return "Order{" +
                "date=" + dateFormat.format(date) +
                ", name='" + name + '\'' +
                '}';
    }
}
