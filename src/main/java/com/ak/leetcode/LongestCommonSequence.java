package com.ak.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonSequence {

    private LongestCommonSequence() {

    }

    public static void main(String[] args) {
        //String res = findLongestCommonPrefix(new String[]{"flogerwer", "geraflow", "bflightger"});
        String res = findLongestCommonPrefix(new String[]{"cir", "car"});
    }

    public static String findLongestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (Arrays.stream(strs).anyMatch(String::isEmpty)) return "";
        List<String> stringsSortedByLength = Arrays.stream(strs)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        List<char[]> stringsAsSortedCharArray = stringsSortedByLength.stream()
                .map(String::toCharArray) //x -> x.toCharArray()
                .collect(Collectors.toList());
        char[] firstWord = stringsAsSortedCharArray.get(0);

        StringBuilder prefix = new StringBuilder();

        int counter;
        boolean ok = true;
        for (int j = 0; j < firstWord.length; ++j) {
            counter = stringsAsSortedCharArray.size();
            for (int i = 1; i < stringsAsSortedCharArray.size(); ++i) {
                char[] toCompare = stringsAsSortedCharArray.get(i);
                if (toCompare[j] != firstWord[j]) {
                    --counter;
                    ok = false;
                }
            }
            if (counter == stringsAsSortedCharArray.size() && ok)
                prefix.append(firstWord[j]);
        }
        return prefix.toString();
    }

    public static String findLongestCommonSequenceAlternative(String[] strs) {
        List<String> stringsSortedByLength =
                Arrays.stream(strs)
                        //.sorted() alphabetical order
                        .sorted(Comparator.comparingInt(String::length))//.reversed()) //by length
                        //(p1, p2)->p1.x.compareTo(p2.x)) by properties comparison
                        //        .forEach(System.out::println);
                        .collect(Collectors.toList());

        String min = stringsSortedByLength.get(0);
        return ifAllWordsContains(min, stringsSortedByLength);
    }


    protected static String ifAllWordsContains(String prefix, List<String> words) {
        for (int i = 1; i < words.size(); ++i) {
            if (!words.get(i).contains(prefix)) {
                return ifAllWordsContains(prefix.substring(0, prefix.length() - 1), words);
            }
        }
        return prefix;
    }

    public static String findLongestCommonSequence(String[] input) {
        List<char[]> stringsAsSortedCharArray = Arrays.stream(input)
                .map(String::toCharArray) //x -> x.toCharArray()
                .collect(Collectors.toList());
        stringsAsSortedCharArray.forEach(Arrays::sort);//x -> Arrays.sort(x)
        List<String> stringsDoubleSort = stringsAsSortedCharArray.stream()
                .map(String::valueOf)
                .sorted()
                .collect(Collectors.toList());

        char[] lastWorldCharArray = stringsDoubleSort.get(stringsDoubleSort.size() - 1).toCharArray();
        String lastWorldRest = stringsDoubleSort.get(stringsDoubleSort.size() - 1);

        for (int i = 0; i < stringsDoubleSort.size() - 1; ++i) {
            for (char ch : lastWorldCharArray) {
                String word = stringsDoubleSort.get(i);
                if (!word.contains(String.valueOf(ch))) {
                    lastWorldRest = lastWorldRest.replace(String.valueOf(ch), "");
                }
            }
        }

        String finalLastWorldRest = lastWorldRest;
        List<String> stringsSortedByLength =
                Arrays.stream(input)
                        .filter(i -> i.length() >= finalLastWorldRest.length())
                        //.sorted() alphabetical order
                        .sorted(Comparator.comparingInt(String::length).reversed()) //by length
                        //(p1, p2)->p1.x.compareTo(p2.x)) //by properties comparison
                        //        .forEach(System.out::println);
                        .collect(Collectors.toList());


        String resultStr = "";
        for (String s : stringsSortedByLength) {
            for (char ch : lastWorldRest.toCharArray()) {
                if (!s.contains(String.valueOf(ch))) {
                    break;
                }
            }
            resultStr = s;
        }

        int lastIndex = -2;
        List<String> results = new ArrayList<>();
        for (int i = 0; i < resultStr.length(); ++i) {
            if (lastWorldRest.contains(String.valueOf(resultStr.charAt(i)))) {
                if (lastIndex == i - 1) {
                    results.add(results.get(results.size() - 1) + resultStr.charAt(i));
                } else {
                    results.add(String.valueOf(resultStr.charAt(i)));
                }
                lastIndex = i;
            }
        }

        return results.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

/* very strange with double char
        String minWord = String.valueOf(stringsSortedByLength.stream().findFirst());//.toCharArray();
        char[] minWordCharArray = minWord.toCharArray();

        String[] doubleChar = new String[minWordCharArray.length - 2];
        boolean[] b = new boolean[minWordCharArray.length - 2];
        for (int i = 0; i < minWordCharArray.length - 2; ++i) {
            doubleChar[i] = String.valueOf(minWordCharArray[i]) + String.valueOf(minWordCharArray[i + 1]);
            b[i] = true;
        }
        for (int i = 0; i < doubleChar.length; ++i) {
            for (int j = 0; j < stringsSortedByLength.size(); ++j) {
                if (!stringsSortedByLength.get(j).contains(doubleChar[i])) {
                    b[i] = false;
                    break;
                }
            }
        }
        */
    }
}
