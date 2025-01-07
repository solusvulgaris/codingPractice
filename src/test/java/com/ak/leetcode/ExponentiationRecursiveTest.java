package com.ak.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ExponentiationRecursiveTest {

    public static Stream<org.junit.jupiter.params.provider.Arguments> invalidTemplateData() {
        return Stream.of(
                Arguments.of(4, 3, 64),
                Arguments.of(2, 1, 2),
                Arguments.of(2, 0, 1),
                Arguments.of(2, -1, 0.5),
                Arguments.of(2, -2, 0.25)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidTemplateData")
    @DisplayName("")
    void exponentiationRecursiveTest(int basis, int naturalIndicator, float result) {
        Assertions.assertEquals(result, ExponentiationRecursive.exponentiation(basis, naturalIndicator));
    }
}
