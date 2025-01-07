package com.ak.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 933. Number of Recent Calls
 * */
public class NumberOfRecentCalls {

    private static final int[] ping = new int[]{1, 100, 3001, 3002};
    private static final int[] output = new int[10];

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        for (int i = 0; i < ping.length; ++i) {
            output[i] = obj.ping(ping[i]);
            System.out.println(output[i]);
        }
    }

    static class RecentCounter {

        public RecentCounter() {
            q1 = new LinkedList<>();
        }

        List<Integer> callsList = new ArrayList<>();


        public int pingWithLambdas(int t) {
            int requestsN = 0;
            callsList.add(t);
            // List<Integer> sortedCalls = calls.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            // List<Integer> resultList = sortedCalls.stream().filter(x -> x > (t - 3000)).collect(Collectors.toList());

            // return resultList.size();
            return (int) callsList.stream().filter(x -> x > (t - 3000)).count();
        }

        Queue<Integer> q1;

        public int ping(int t) {
            q1.add(t);
            while (q1.peek() < t - 3000) {
                q1.poll();
            }
            return q1.size();
        }
    }

}
