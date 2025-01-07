package com.ak.codingame;

import java.util.Arrays;

public class TemperatureRecords {

    public static int computeClosestToZero(int[] ts) {
        if (ts.length == 0) {
            return 0;
        } else {
            //return positive in case of -2 & 2
            int minTemperature = Arrays.stream(ts)
                .boxed()
                .map(Math::abs)
                .sorted()
                .findFirst().orElse(0);

            if (Arrays.stream(ts).anyMatch(t -> t == minTemperature) || minTemperature == 0) {
                return minTemperature;
            } else {
                return -minTemperature;
            }

            //.collect(Collectors.toList());
            //Collections.sort(integersLazy);
            //Collections.sort(testList);
            //Collections.reverse(testList);
            //integersLazy.stream().map(mapper).forEach(x -> System.err.println(x));
        }
        //return -1;
    }
}
