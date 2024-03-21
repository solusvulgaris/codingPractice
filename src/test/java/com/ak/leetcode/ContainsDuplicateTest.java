package com.ak.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static com.ak.leetcode.ContainsDuplicate.findAllDuplicatedElements;
import static com.ak.leetcode.ContainsDuplicate.findAllDuplicatedElementsWithArraysOnly;
import static com.ak.leetcode.ContainsDuplicate.findFirstDuplicatedValue;
import static com.ak.leetcode.ContainsDuplicate.isNotDuplicated;

class ContainsDuplicateTest {

    @Test
    void isNotDuplicatedTest() {
        int[] numsT = {1, 2, 3, 4};
        int[] numsF = {1, 2, 3, 1};

        Assertions.assertTrue(isNotDuplicated(numsT));
        Assertions.assertFalse(isNotDuplicated(numsF));
    }

    @Test
    void findFirstDuplicatedValueTest() {
        int[] numsT = {1, 2, 3, 4};
        int[] numsF = {1, 2, 3, 1};

        Assertions.assertEquals(Optional.empty(), findFirstDuplicatedValue(numsT));
        Assertions.assertEquals(Optional.of(1), findFirstDuplicatedValue(numsF));
    }

    @Test
    void findAllDuplicatedElementsTest() {
        int[] newNums = {1, 1, 2, 3, 1, 2, 1, 4, 5, 6, 6}; //result = {1,2,6}
        Set<Integer> resultSet = new HashSet<>(Arrays.asList(1, 2, 6));
        Assertions.assertEquals(resultSet, findAllDuplicatedElements(newNums));
    }

    public static Stream<Arguments> sourceFindAllDuplicatedElementsWithArraysOnly() {
        return Stream.of(
                Arguments.of((Object) new int[]{1}, (Object) new int[]{1, 1, 2, 6}),
                //Arguments.of((Object) new int[]{2, 5, 1},(Object) new int[]{1, 2, 3, 2, 2, 4, 5, 5, 2, 1}),
                //order will not be saved, result will be sorted!
                Arguments.of((Object) new int[]{1, 2, 5},(Object) new int[]{1, 2, 3, 2, 2, 4, 5, 5, 2, 1}),
                Arguments.of((Object) new int[]{},(Object) new int[]{0, 1}));
    }

    @ParameterizedTest
    @MethodSource("sourceFindAllDuplicatedElementsWithArraysOnly")
    void findAllDuplicatedElementsWithArraysOnlyTest(int[] expected, int[] args) {
        int[] result = findAllDuplicatedElementsWithArraysOnly(args);

        Assertions.assertEquals(expected.length, result.length);

        for(int i = 0; i< expected.length; ++i) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }
}