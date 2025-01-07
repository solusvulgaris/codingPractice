package com.ak.codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CompositionSignTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, new int[]{1, -2, -3, 5}),
                Arguments.of(-1, new int[]{1, -2, -3, -5}),
                Arguments.of(0, new int[]{1, -2, 0, -5})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("")
    void test(int result, int[] A) {
        Assertions.assertEquals(result, CompositionSign.solution(A));
    }

}
