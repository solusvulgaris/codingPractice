package com.ak.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Demo {

    private static final Logger logger = Logger.getLogger(Demo.class.getName());

    public static void main(String[] args) {
        //logger.log(Level.INFO, String.valueOf(solutionFirstAttempt(test)));
        //logger.log(Level.INFO, String.valueOf(solutionFirstAttempt(test)));
        logger.log(Level.INFO, String.valueOf(solutionThirdAttempt(test)));

        //int[] values = { 1, 2, 3, 4, 10 };
        //int valueToFind = 3;
        //binarySearch(values, valueToFind, 0, values.length - 1);

    }

    private Demo() {

    }

    public static int[] test = new int[]{-2, 1, 3, 6, 4, 1, 2};

    protected static List<Integer> fillInListFromArray(int[] A) {
        //List<Integer> integer = Arrays.asList(A);
        List<Integer> result = new ArrayList<>();
        for (int j : A) {
            result.add(j);
        }
        return result;
    }

    public static int solutionThirdAttempt(int[] A) {
        List<Integer> initial = fillInListFromArray(A);
        List<Integer> sorted = initial.stream()
            .sorted()
            .filter(x -> x > 0)
            .distinct()
            .collect(Collectors.toList());

        if (sorted.isEmpty()) {
            return 1;
        }

        if (sorted.get(0) > 1) {
            return 1;
        }

        return checkBinary(sorted, 0);
    }

    public static int checkBinary(List<Integer> sorted, int old) {
        if (sorted.get(sorted.size() - 1) == sorted.size() + old) {
            return sorted.size() + 1;
        } else {
            int middle = sorted.size() / 2;

            if (sorted.get(middle - 1) == middle + old) {//левая сторона - ок, берем правую
                List<Integer> newArray = sorted.subList(middle, sorted.size());
                if (newArray.size() == 1) {
                    return 1 + middle + old;
                }
                return checkBinary(newArray, middle + old);//начинаем сначала
            } else { //правая сторона ок - берем левую
                List<Integer> newArray = sorted.subList(0, middle);
                if (newArray.size() == 1) {
                    return middle + old;
                }
                return checkBinary(newArray, 0);//начинаем сначала
            }
        }
    }

    public static int solutionSecondAttempt(int[] A) {
        List<Integer> initial = fillInListFromArray(A);

        List<Integer> sorted = initial.stream()
            .sorted()
            .filter(x -> x > 0).distinct().toList();

        if (sorted.isEmpty()) {
            return 1;
        }

        if (sorted.get(0) > 1) {
            return 1;
        } else {
            for (int i = 0; i < sorted.size() - 1; ++i) {
                int diff = sorted.get(i + 1) - sorted.get(i);
                if (diff > 1) {
                    return sorted.get(i) + 1;
                }
            }
            return sorted.size();
        }
    }

    public static int solutionFirstAttempt(int[] A) {
        List<Integer> initial = fillInListFromArray(A);
        List<Integer> sorted = initial.stream()
            .sorted()
            .filter(x -> x > 0)
            .distinct().toList();

        if (sorted.isEmpty() || sorted.get(0) > 1) {
            return 1;
        }

        int min = 1;
        int firstVal = sorted.get(0);
        if (firstVal > 1) {
            return min;
        } else if (firstVal == 1) {
            ++min;
            for (int i = 1; i < sorted.size(); ++i) {
                if (sorted.get(i) != min) {
                    return min;
                } else {
                    ++min;
                }
            }
        }
        return min;
    }

    private static int binarySearch(int[] sortedArray, int valueToFind, int first, int last) {
        int index = -1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (sortedArray[mid] < valueToFind) {
                first = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                last = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }

}

/*
*         List<Integer> sorted = initial.stream()
        //Optional<Integer> op =  initial.stream()
                .sorted()
                .filter(x -> x > 0)
                .distinct()
                //.min((o1, o2) -> (o1.intValue() - o2.intValue()));
                .sorted((o1, o2) -> (o1.intValue() - o2.intValue()))
                //.peek()
              //  .sorted((o1, o2) -> Comparator.comparing(o2.intValue() - o1.intValue()))// o1.compareTo(o2))
        //Comparator.comparing((o1, o2) -> o2.intValue() - o1.intValue() ))
                //.min((x,y) -> { (y-x) > 1 })
              //  .filter((x,y) ->  (y-x) > 1 )
                .collect(Collectors.toList());

        String str = "";

* (new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });*/
