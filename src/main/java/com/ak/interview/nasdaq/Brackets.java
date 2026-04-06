package com.ak.interview.nasdaq;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Input String with brackets, like "(some text (abc)) and ((one more) text)"
 * has to be validated, namely, that all the brackets are in place.
 * Invalid example: ")("
 * */
public class Brackets {

    public static void main(String[] args) {
        boolean result = validate("(;lj(flsk)jg(kjbk)234)fbfd)..(1)|");
        System.out.println(result);
    }

    protected static boolean validate(String str) {

        List<String> brackets =
            Stream.of(str)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                //.peek(System.out::println)
                .filter(s -> (Objects.equals(s, ")") || Objects.equals(s, "(")))
                .peek(System.out::println)
                .collect(Collectors.toList());

        List<Integer> bracketsToInt =
            brackets.stream()
                .map(s -> {
                        if (Objects.equals(s, "(")) {
                            return 1;
                        } else if (Objects.equals(s, ")")) {
                            return -1;
                        }
                        return null;
                    }
                )
                .filter(Objects::nonNull)
                .toList();
        // bracketsToInt.stream()
        return validate(bracketsToInt);
    }

    private static boolean validate(List<Integer> bracketsToInt) {
        boolean n = true;
        int result = 0;
        for (int i : bracketsToInt) {
            System.out.println(i);

            result += i;
            System.out.println("result: " + result);
            if (result < 0) {
                n = false;
                break;
            }
        }
        return n;
    }
}
