package com.ak.codility;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DemoTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(5, new int[]{1, 3, 6, 4, 1, 2}),
            Arguments.of(5, new int[]{-2, 1, 3, 6, 4, 1, 2}),
            Arguments.of(8, new int[]{1, 2, 3, 4, 5, 6, 7}),
            Arguments.of(1, new int[]{2, 3, 4, 5, 6, 7}),
            Arguments.of(2, new int[]{1, 3, 4, 5, 6, 7}),
            Arguments.of(3, new int[]{1, 2, 4, 5, 6, 7}),
            Arguments.of(4, new int[]{1, 2, 3, 5, 6, 7}),
            Arguments.of(5, new int[]{1, 2, 3, 4, 6, 7}),
            Arguments.of(6, new int[]{1, 2, 3, 4, 5, 7}),
            Arguments.of(2, new int[]{1, 3, 4, 5, 7}),
            Arguments.of(3, new int[]{1, 2, 4, 6, 8})

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("")
    void longestCommonPrefixTest(int result, int[] A) {
        Assertions.assertEquals(result, Demo.solutionThirdAttempt(A));
    }
}
