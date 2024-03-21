package com.ak.leetcode;

/*
Given an integer array nums,
return true if any value appears at least twice in the array,
and return false if every element is distinct.

        Example 1:
            Input: nums = [1,2,3,1]
            Output: true
        Example 2:
            Input: nums = [1,2,3,4]
            Output: false
        Example 3:
            Input: nums = [1,1,1,3,3,4,3,2,4,2]
            Output: true

        Constraints:
        1 <= nums.length <= 105
        -109 <= nums[i] <= 109
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] newNums = {1, 1, 2, 3, 2, 4, 5, 6, 6}; //result = {1,2,6}
        Set<Integer> resultSet = findAllDuplicatedElements(newNums);

        resultSet.stream().forEach(System.out::println);
    }

    private static int[] numsT = {1, 2, 3, 1};
    private static int[] numsF = {1, 2, 3, 4};

    protected static boolean isNotDuplicated(int[] nums) {
        Set<Integer> intSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length == intSet.size();
    }

    protected static Optional<Integer> findFirstDuplicatedValue(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return Optional.of(n);
            }
        }
        return Optional.empty();
    }

    private static int[] newNums = {1, 1, 2, 3, 1, 2, 1, 4, 5, 6, 6}; //result = {1,2,6}

    protected static Set<Integer> findAllDuplicatedElements(int[] nums) {
        List<Integer> intList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Integer> intSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        //intList.removeAll(intSet);//удаляет вообще все
        for (int n : intSet) {
            //intList.remove(n);//problem is that index is also int, and 5 int value cause "java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 5"
            intList.remove(Integer.valueOf(n));
        }

        return new HashSet<>(intList);
    }

    private static int[] num1 = {1, 1, 2, 6};
    private static int[] num2 = {1, 1, 2, 2, 2, 4, 5, 5, 3, 2, 1};
    private static int[] num3 = {0, 1};

    // find maximum value
    // create empty array with size = maximum value + 1
    // for each int value in the initial array - increment value of corresponding cell in empty array
    // thus values in new array will correspond to number of repetitions (duplications) of int value from initial array
    // - which corresponds to the indexes in the new array
    // collect
    protected static int[] findAllDuplicatedElementsWithArraysOnly(int[] nums) {
        int maximum = Arrays.stream(nums).max().getAsInt();
        int[] tempArray = new int[maximum + 1];

        int resultArrayFirstLenth = Math.min(nums.length, maximum);

        int[] duplicatedArray = new int[resultArrayFirstLenth];

        for (int i : nums) {
            tempArray[i]++;
        }

        int j = 0;
        for (int i = 0; i < tempArray.length; ++i) {
            if (tempArray[i] > 1) { //we have duplications
                duplicatedArray[j] = i;
                ++j;
            }
        }

        if (j < duplicatedArray.length) {
            int[] resultDuplicated = new int[j];
            /*
            for (int i = 0; i < j; ++i) {
                resultDuplicated[i] = duplicatedArray[i];
            }
            */
            System.arraycopy(duplicatedArray, 0, resultDuplicated, 0, j);
            return resultDuplicated;
        }

        return duplicatedArray;
    }

}
