package com.ak.leetcode;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ShortestPalindromeTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of("aacecaa", "aacecaa"),
            Arguments.of("aacecaaa", "aaacecaaa"),
            Arguments.of("abcd", "dcbabcd")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("")
    void shortestPalindromeTest(String input, String result) {
        Assertions.assertEquals(result, ShortestPalindrome.shortestPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "ecdadce",
        "ecdaadce",
        " ",
        "",
        "a",
        "aa",
        "aaa"
    })
    @DisplayName("")
    void isPolindromTrueTest(final String string) {
        Assertions.assertTrue(ShortestPalindrome.isPolindromString(string));
        Assertions.assertTrue(ShortestPalindrome.isPolindromChar(string));
        Assertions.assertTrue(ShortestPalindrome.isPolindrom(string));
    }

    @Test
    @DisplayName("")
    void isPolindromFalseTest() {
        Assertions.assertFalse(ShortestPalindrome.isPolindromString("ecda"));
        Assertions.assertFalse(ShortestPalindrome.isPolindrom("ecda"));
    }

}
