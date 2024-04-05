package com.ak.interview.hashcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class HashTagUtilsTest {

    public static Stream<Arguments> Given_String_When_HasHashTags_Then_ReturnHashTags() {
        return Stream.of(
                Arguments.of(Collections.emptyList(), new ArrayList<>(List.of(""))),
                Arguments.of(Collections.emptyList(), new ArrayList<>(List.of("some text"))),
                Arguments.of(List.of("#hashtag"), new ArrayList<>(List.of("some #hashtag text"))),
                Arguments.of(List.of("#hashtag"), new ArrayList<>(List.of("#hashtag text"))),
                Arguments.of(List.of("#hashtag"), new ArrayList<>(List.of(" #hashtag "))),
                Arguments.of(List.of("#hashtag"), new ArrayList<>(List.of("#hashtag"))),
                Arguments.of(List.of("#hashtag", "#hashtag"), new ArrayList<>(List.of("some #hashtag #hashtag text")))
        );
    }

    @ParameterizedTest
    @MethodSource("Given_String_When_HasHashTags_Then_ReturnHashTags")
    void Given_String_When_HasHashTags_Then_StreamReturnHashTags(List<String> expectedResult, List<String> input) {
        List<String> result = HashTagUtils.getSortedHashTagsStream(input);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for(int i = 0; i < expectedResult.size(); ++i) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("Given_String_When_HasHashTags_Then_ReturnHashTags")
    void Given_String_When_HasHashTags_Then_SelfWrittenReturnHashTags(List<String> expectedResult, List<String> input) {
        List<String> result = HashTagUtils.getSortedHashTagsSelfWritten(input);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for(int i = 0; i < expectedResult.size(); ++i) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }
}