package com.ak.codingame;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MoneyGiverTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(10, 125000, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("MoneyGiverTest")
    void testMoneyGiver(int start, int budget, int result) {
        Assertions.assertEquals(MoneyGiver.howManyTimes_first(start, budget), result);
    }
}
