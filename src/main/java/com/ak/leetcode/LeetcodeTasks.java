package com.ak.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LeetcodeTasks {

    public static void main(String[] args) {

    }

    public static List<String> Task1(String[] words) {
        //String[] words = new String[]{"cool","lock","cook"};//
        //String[] words = new String[]{"bella", "label", "roller"};
        String firstWorld = words[0];
        char[] allCharsInStr = firstWorld.toCharArray();

        List<String> input = Arrays.asList(words);
        List<String> output = new ArrayList<>();

        LinkedHashMap<String, Integer> keyValuePairList =
            new LinkedHashMap<>();

        int index = 0;
        for (char ch : firstWorld.toCharArray()) {
            for (int i = 1; i < words.length; ++i) {
                if (words[i].contains(String.valueOf(ch))) {
                    words[i] = words[i].replaceFirst(String.valueOf(ch), "");
                    ++index;
                }

            }
            if (index + 1 == words.length) {
                output.add(String.valueOf(ch));
            }
            index = 0;
        }
        /*
        char[] wordsArray = new char[output.size()];
        for (int i = 0; i < output.size(); i++) {
            wordsArray[i] = output.get(i).toCharArray()[0];
        }
        */
        return output;
    }

    public static int Task2(String s) {
        //String s = "RLRRLLRLRL";
        String tempStr = s;
        List<String> R = new ArrayList();
        List<String> L = new ArrayList();
        int pairs = 0;
        for (char ch : s.toCharArray()) {
            if (String.valueOf(ch).equals("R")) {
                R.add("R");
                s = s.replaceFirst("R", "");
            }
            if (String.valueOf(ch).equals("L")) {
                L.add("L");
                s = s.replaceFirst("L", "");
            }
            if (R.size() == L.size()) {
                ++pairs;
                R = new ArrayList();
                L = new ArrayList();
            }


        }
        //String str = String.valueOf(pairs);
        return pairs;
    }

    public static List<List<Integer>> MinimumAbsoluteDifference(int[] arr) {
        //int[] arr =
        //new int[]{4, 2, 1, 3};
        //new int[]{1, 3, 6, 10, 15};
        //new int[]{3, 8, -10, 23, 19, -4, -14, 27};
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            diff = Math.min(diff, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == diff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;
    }

    public static List<List<Integer>> MinimumAbsoluteDifferenceMy(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        int minAD = Math.abs(arr[0] - arr[1]);
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff < minAD) {
                    minAD = diff;
                }
            }
        }
        //Arrays.asList(arr).stream().collect(Collectors.toMap());

        class MyValue implements Comparable<MyValue> {

            final List<Integer> list = new ArrayList<>();

            @Override
            public boolean equals(Object o) {
                return list.equals(o);
            }

            @Override
            public int hashCode() {
                return list.hashCode();
            }

            @Override
            public int compareTo(MyValue o) {
                return this.list.get(0).compareTo(o.list.get(0));
            }
        }

        //public interface MyValue { }
        //TreeSet<MyValue> resultValueSet = new TreeSet<>();
        SortedSet<List<Integer>> resultSet = new TreeSet<>(Comparator.comparing(o -> o.get(0)));
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 1; j < arr.length; ++j) {
                if (Math.abs(arr[i] - arr[j]) == minAD) {
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(arr[i]);
                    set.add(arr[j]);
                    MyValue myValue = new MyValue();
                    myValue.list.add(set.first());
                    myValue.list.add(set.last());
                    //resultValueSet.add(myValue);
                    resultSet.add(myValue.list);
                }
            }
        }

        for (List<Integer> myValue : resultSet) {
            result.add(myValue);
        }

        System.out.println(Collections.singletonList(result));
        return result;
    }

    /*
         Collections.sort(result, new Comparator<List<Integer>>() {
             @Override
             public int compare(List<Integer> o1, List<Integer> o2) {
                 if(o1.get(0) < o2.get(0))
                     return 0;
                 else
                     return 1;
             }
         });
 */

    protected int[][] fillArrayFromMap(Map<Integer, Integer> map) {
        int[][] array = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[index][0] = entry.getKey();
            array[index][1] = entry.getValue();
            ++index;
        }

        return array;
    }

    public static void SortPuzirec(int[][] array) {
        boolean isSorted = false;
        int buf0, buf1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i][0] > array[i + 1][0]) {
                    isSorted = false;

                    buf0 = array[i][0];
                    buf1 = array[i][1];
                    array[i][0] = array[i + 1][0];
                    array[i][1] = array[i + 1][1];
                    array[i + 1][0] = buf0;
                    array[i + 1][1] = buf1;
                }
            }
        }
    }

    public static void SortPuzirec(int[] array) {
        boolean isSorted = false;
        int buf0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    buf0 = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf0;
                }
            }
        }
    }

}
