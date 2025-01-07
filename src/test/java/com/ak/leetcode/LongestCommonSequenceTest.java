package com.ak.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestCommonSequenceTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"flower","flow","flight"}, "fl"),
                Arguments.of(new String[]{"sdflower","nmflow","flowight"}, "flow"),
                Arguments.of(new String[]{"hgfrflo","dsflow","dfloight"}, "flo"),
                Arguments.of(new String[]{"dag","racecar","car"}, "a"),
                Arguments.of(new String[]{"dog","racecar","car"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("")
    void longestCommonSequenceTest(String[] input, String result) {
        Assertions.assertEquals(result, LongestCommonSequence.findLongestCommonSequence(input));
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("")
    void longestCommonSequenceAlternativeTest(String[] input, String result) {
//        Assertions.assertEquals(result, LongestCommonSequence.findLongestCommonSequenceAlternative(input));
    }

    public static Stream<Arguments> testDataPrefix() {
        return Stream.of(
                Arguments.of(new String[]{"cir","car"}, "c"),
                Arguments.of(new String[]{""}, ""),
                Arguments.of(new String[]{"aaca","ac","aca"}, "a"),
                Arguments.of(new String[]{"dag","racecar","car"}, ""),
                Arguments.of(new String[]{"racdog","racecar","racar"}, "rac")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataPrefix")
    @DisplayName("")
    void longestCommonPrefixTest(String[] input, String result) {
        Assertions.assertEquals(result, LongestCommonSequence.findLongestCommonPrefix(input));
    }
}
