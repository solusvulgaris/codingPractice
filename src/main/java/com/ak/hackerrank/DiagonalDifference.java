package com.ak.hackerrank;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class DiagonalDifference {

    @Getter
    @Setter
    public static class Pair {

        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static Pair diagonalDifference1(List<List<Integer>> arr) {
        // Write your code here
        List<Integer> first = arr.get(0);
        List<Integer> middle = arr.get(1);
        List<Integer> last = arr.get(2);

        int firstSum = first.get(0) + middle.get(1) + last.get(2);
        int secondSum = first.get(2) + middle.get(1) + last.get(0);

        return new Pair(firstSum, secondSum);

    }

    public static Pair diagonalDifference2(List<List<Integer>> arr) {
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < 3; ++i) {
            firstSum += arr.get(i).get(i);
            secondSum += arr.get(2 - i).get(i);
        }
        return new Pair(firstSum, secondSum);
        //return Math.abs(firstSum - secondSum);
    }

    public static int diagonalDifference(int n, List<List<Integer>> arr) {
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < n; ++i) {
            firstSum += arr.get(i).get(i);
            secondSum += arr.get(n - 1 - i).get(i);
        }
        return Math.abs(firstSum - secondSum);
    }

}
