package com.ak.codility;

//import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.StringReverseTest;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringReverseTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of("a", "a"),
            Arguments.of("", null),
            Arguments.of("dcba", "abcd")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("shouldInvert")
    void shouldInvert(String result, String testCase) {
        Assertions.assertEquals(result, reverse(testCase));
    }

    public static String reverse(String toReverse) {

        IntStream intStream = toReverse.chars();
        intStream.peek(System.out::println);
        Stream<Character> characterStream =
            toReverse.chars()
            .mapToObj(c -> (char) c);
        characterStream.peek(System.out::println);

        IntStream intStream1 = toReverse.codePoints();
        intStream1.peek(System.out::println);

        Stream<Character> characterStream2
            = toReverse.codePoints().mapToObj(c -> (char) c).peek(System.out::println);
        //characterStream.peek(System.out::println);

        Stream<String> stringStream = toReverse.codePoints()
            .mapToObj(c -> String.valueOf((char) c));

        return stringStream.peek(System.out::println).findFirst().orElse("");
    }
}
    /* --- JUNIT-4
import org.junit.Assert;
import org.junit.StringReverseTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class InverterTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { null, "" },
            { "", "" },
            { " ", " " },
            { "a", "a" },
            { "ba", "ab" },
            { "abc", "cba" },
            { "abcd", "dcba" }
           });
    }

    private String fInput;
    private String fExpected;

    public InverterTest(String input, String expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @StringReverseTest
    public void shouldInvert() {
        assertEquals(fExpected, Inverter.invert(fInput));
    }
}

    * */
