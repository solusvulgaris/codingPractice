package com.ak.leetcode;

import java.util.stream.Stream;

public class RearrangeSpacesBetweenWords {

    private static final String initialStr = "  first   second";
    private static final String initialStr1 = "  first   second third    forth";

    public static void main(String[] args) {
        System.out.println(rearrange(initialStr));
    }

    public static String rearrange(String text) {
        System.out.println(text);

        StringBuilder output;
        int spaceCount = text.length() - text.replace(" ", "").length();
        String[] split = text.split(" ");
        long wordsCount = Stream.of(split).filter(x -> !(x.trim().isEmpty())).count();
        if (wordsCount > 1) {
            long countOfSpacesBetweenWords = spaceCount / (wordsCount - 1);
            StringBuilder spacesbetweenWorlds = new StringBuilder();
            for (int i = 0; i < countOfSpacesBetweenWords; ++i) {
                spacesbetweenWorlds.append(" ");
            }
            String finalSpacesbetweenWorlds = spacesbetweenWorlds.toString();
            StringBuilder sb = Stream.of(split)
                .filter(x -> !(x.trim().isEmpty()))
                .collect(
                    StringBuilder::new,
                    (x, y) -> x.append(y).append(finalSpacesbetweenWorlds),
                    StringBuilder::append);
            output = new StringBuilder(sb.toString().trim());
        } else {
            output = new StringBuilder(text.replace(" ", ""));
        }
        int l = text.length() - output.length();
        while (l > 0) {
            output.append(" ");
            --l;
        }
        return output.toString();
    }
}
