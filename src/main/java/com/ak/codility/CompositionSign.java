package com.ak.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompositionSign {
    private static final Logger logger = Logger.getLogger(CompositionSign.class.getName());

    protected static final int[] test1 = new int[]{1, -2, -3, 5};
    protected static final int[] test2 = new int[]{-2, 1, 3, 6, 4, 1, 2};

    public static void main(String[] args) {
        logger.log(Level.INFO, "{0}", solution(test1));
        logger.log(Level.INFO, "{0}", solution(test2));
    }

    public static int solution(int[] A) {
        List<Integer> initial = new ArrayList<>();
        for (int j : A) {
            initial.add(j);
        }

        if (initial.stream().anyMatch(x -> x == 0)) return 0;
        // List<Integer> sortedNegative = initial.stream()
        //.sorted()
        long negative = initial.stream()
                .filter(x -> x < 0).count();
        long mod = negative % 2;
        if (mod != 0) return -1;
        else return 1;

        //.distinct()
        //.collect(Collectors.toList());
        //   if (sorted.isEmpty()) return 1;
        //   if (sorted.get(0) > 1) return 1;
        //   return binarySearch(sorted, sorted.size() / 2, 0, sorted.size());
        //return -1;
    }

}
