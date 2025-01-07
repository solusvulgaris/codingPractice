package com.ak.hackerrank;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTheTriplets {

    public static long method(List<Long> ar) {
        return ar.stream().reduce( Long.valueOf(0), (a, b) -> a + b);
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int f = 0;
        int s = 0;

        for (int i = 0; i < a.size(); ++i) {
            if (a.get(i) != b.get(i)) {
                if (a.get(i) > b.get(i)) {
                    ++f;
                } else {
                    ++s;
                }
            }

            return new ArrayList<>(Arrays.asList(f, s));
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        List<Integer> result = compareTriplets(
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(1, 2, 3))
        );
    }

    /*
    *  public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    * */

}