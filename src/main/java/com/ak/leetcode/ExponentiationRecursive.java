package com.ak.leetcode;

import java.util.*;

public class ExponentiationRecursive {

    private static final Map<Integer, Integer> pairsBNI = new HashMap<>();

    //List<Float> results = (List<Float>) Arrays.asList(64, 2, 1, 0.5, 0.25);
    //Set<String> set = new HashSet<String>(Arrays.asList("a", "b", "c"));

    public static void main(String[] args) {
        pairsBNI.put(0, 2);
        pairsBNI.put(-1, 2);
        pairsBNI.put(1, 2);
        pairsBNI.put(-2, 2);
        pairsBNI.put(3, 4);


        Iterator<Map.Entry<Integer, Integer>> iterator = pairsBNI.entrySet().iterator();
        //Iterator iterator = mapA.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            ++i;
            Map.Entry<Integer, Integer> entry = iterator.next();
            int x = entry.getValue();
            int y = entry.getKey();
            System.out.println(i + ") " + x + " " + y);
            System.out.println(exponentiation(x, y));
        }
    }

/*
    protected static float exponentiation(int basis, int naturalIndicator) {
        long result = 1;
        for (int i = 0; i < naturalIndicator; ++i) {
            result *= basis;
        }
        return result;
    }
*/

    protected static float exponentiation(int basis, int naturalIndicator) {
        float fBasis = basis;
        if (naturalIndicator == 0)
            return 1;
        if (naturalIndicator == 1)
            return basis;
        if (naturalIndicator < 0)
            fBasis = 1 / fBasis;

        return multiplication(1, fBasis, naturalIndicator);
    }

    protected static float multiplication(float a, float b, int counter) {
        if (counter == 0) {
            return a;
        } else {
            if (counter < 0) {
                ++counter;
            } else { //if(counter > 0) {
                --counter;
            }
        }

        return multiplication(a * b, b, counter);
    }
}
