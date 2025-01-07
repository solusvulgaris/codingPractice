package com.ak.hackerrank;

import com.ak.hackerrank.DiagonalDifference.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DiagonalDifferenceTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, new ArrayList<List<Integer>>(
                        Arrays.asList(
                                new ArrayList<>(Arrays.asList(1, 2, 3)),
                                new ArrayList<>(Arrays.asList(1, 2, 3)),
                                new ArrayList<>(Arrays.asList(3, 2, 1))
                        )), 4),
                Arguments.of(4, new ArrayList<List<Integer>>(
                        Arrays.asList(
                                new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
                                new ArrayList<>(Arrays.asList(1, 2, 3, 5)),
                                new ArrayList<>(Arrays.asList(3, 2, 1, 6)),
                                new ArrayList<>(Arrays.asList(3, 2, 1, 7))
                        )), 1)
                );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("MoneyGiverTest")
    void testMoneyGiver(int n, List<List<Integer>> list, int result) {
        Assertions.assertEquals(DiagonalDifference.diagonalDifference(n, list), result);
    }


    @Test
    @DisplayName("DiagonalDifferenceTest")
    void testDiagonalDifference() {
        List<List<Integer>> list1 = new ArrayList<List<Integer>>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3)),
                        new ArrayList<>(Arrays.asList(1, 2, 3)),
                        new ArrayList<>(Arrays.asList(3, 2, 1))
                ));

        Pair p1 = DiagonalDifference.diagonalDifference1(list1);
        Pair p2 = DiagonalDifference.diagonalDifference2(list1);
        Pair result = new Pair(4, 8);
        Assertions.assertEquals(
                p1.getKey(),
                result.getKey()
        );
        Assertions.assertEquals(
                p1.getValue(),
                result.getValue()
        );
        Assertions.assertEquals(
                p2.getKey(),
                result.getKey()
        );
        Assertions.assertEquals(
                p2.getValue(),
                result.getValue()
        );
    }
}
