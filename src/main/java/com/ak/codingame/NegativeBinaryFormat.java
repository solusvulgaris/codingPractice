package com.ak.codingame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NegativeBinaryFormat {
    public static void main(String args[]) {
        //Scanner in = new Scanner(System.in);
        //String N = in.nextLine();
        //System.err.println(N);

        String N = "10101";
        int length = N.length();
        int s = 0;
        for(int i = 0; i < length; ++i) {
            s += Math.pow(-2,i);
        }
        String N1 = "10";// result -2

        List<String> listOfChars =
                N.chars()
                        .mapToObj(x -> Character.toString((char) x))
                        .collect(Collectors.toList());
       // final int length = listOfChars.size();
        double d = listOfChars.stream()
                //значение цифры - последнее
                .map(x -> Integer.valueOf(x))
                //если список состоит только из 1 и 0 как .indexOf(value) узнает корректный индекс?
                .map(x -> x * Math.pow(-2, (length - 1) - listOfChars.indexOf(x)))
                .reduce(0.0, Double::sum);


        int s1 = 0;
        for (int i = 0; i < listOfChars.size(); ++i) {
            System.err.println(Integer.valueOf(listOfChars.get(i)));
            System.err.println(Math.pow(-2, i));
            s += Integer.valueOf(listOfChars.get(i)) * Math.pow(-2, i);
        }
        //return s;

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

       // System.out.println(getCommonDecimal_oldCode(N));
       // System.out.println(getCommonDecimal_streams(N)); -> куча треша
    }

    public static int getCommonDecimal_oldCode(String N) {
        int length = N.length();
        char[] chars = N.toCharArray();
        List<String> charsS = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            charsS.add(String.valueOf(chars[length - 1 - i]));
        }

        int s = 0;
        for (int i = 0; i < length; ++i) {
            System.err.println(Integer.valueOf(charsS.get(i)));
            System.err.println(Math.pow(-2, i));
            s += Integer.valueOf(charsS.get(i)) * Math.pow(-2, i);
        }
        return s;
    }

    public static int getCommonDecimal_streams(String N) {
        IntStream charsStream = N.chars(); //don`t know what to do with this

        charsStream
                .mapToObj(x -> Character.toString ((char) x))
                .forEach(System.out::println);
        /*
        String[] strings = new String[] {"a", "b", "c", "d"};
        List<String> alpha = Arrays.asList(strings);//alpha.stream()
        int[] array = new int[]{1, 2, 3};//Arrays.stream(array)
        int[] firstArray = Arrays.stream(array)
                .map(i -> i + 1)
                .toArray();
        int[] secondArray =
                Arrays.stream(firstArray)
                        .flatMap(x -> Arrays.stream(new int[]{x, x + 1, x + 2}))
                        //.flatMap(x -> Arrays.stream(new int[]{x, x + 1, x + 2}))
                        //.flatMapToInt(x -> Arrays.stream(x.codePointAt(0))) //преобразовываем Stream<int[]> в Stream
                        //.collect(Collectors.toList());//map(Person::getName).collect(Collectors.toCollection(TreeSet::new)); /
                        .toArray(); // преобразовываем Stream в int[] - как вернуть список стримов, а не в один стрим?!
*/
        //список потоков, в каждом потоке м.б. список списков, в каждом могут быть несколько строк
 /*
        List<Stream<List<String>>> listOfStreamOfListsOfStrings =
                Stream.of(N)
                        .map(x -> Stream.of(getList(x)))
                        .collect(Collectors.toList());
        //список потоков, каждый содержит несколько строк
        List<Stream<String>> listOfStreamOfStrings =
                Stream.of(N)
                        .flatMap(x -> Stream.of(getStream(x)))
                        .collect(Collectors.toList());
        List<List<String>> listOfString =
                Stream.of(N)
                        .map(x -> getList(x))
                        .collect(Collectors.toList());
*/
        char[] chars = N.toCharArray();// text.charAt(i) // int codePoint = text.codePointAt(i);
        /*
        String[] strings = new String[]{"a", "b", "c"};
        List<String> listOfStrings = Arrays.asList(strings);
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        */
        //Collections.addAll(list, chars); - ERROR
        //Collections.addAll(list, listOfStrings); - ERROR

        String[] strings = new String[]{"first", "second", "third"};
        Stream.of(strings).forEach(System.out::println);
        List<String> stringList = Arrays.asList(strings);

        int[] ints = new int[]{1, 2, 3};
        //List<Integer> integersLazy = Arrays.stream(ints).boxed().collect(Collectors.toList());
        Stream.of(ints).forEach(System.out::println);


        //List<Integer> oneMoreList = ArrayUtils.toObject(ints);//Apache Commons Lang


        //List<Integer> listOfIntegerFromIntArray =
            Stream.of(ints)
                .flatMap(x -> Arrays.stream(x).boxed()
                //{
                    //List<Integer> integersLazy = Arrays.stream(x).boxed().collect(Collectors.toList())
                    /*
                    List<Integer> integers = new ArrayList<>();
                    for(int i = 0; i< x.length; ++i) {
                        integers.add(x[i]);
                        System.out.println(x[i]);
                    }*/
                //}
                )
                .forEach(System.out::println);
             //   .collect(Collectors.toList());


        //List<String> listOfChars =
                Stream.of(chars)
                        .map(x -> String.valueOf(x))//поток состоящий из массива, а не поток из букв
                //.collect(Collectors.toList());
                .forEach(System.out::println);

        List<String> listOfChars =
                N.chars()
                        .mapToObj(x -> Character.toString((char) x))
                        .collect(Collectors.toList());
        listOfChars.stream().forEach(System.out::println);

/*        List<Integer> oneMoreList = ArrayUtils.toObject(ints)
        Collections.sort(oneMoreList);*/

        return 0;
    }

    public static List<String> getList(String s) {
        List<String> allCharsAsStrings = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char charAtIndex = s.charAt(i);
            allCharsAsStrings.add(String.valueOf(charAtIndex));
        }
        return allCharsAsStrings;
    }

    public static Stream<String> getStream(String s) {
        List<String> allCharsAsStrings = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char charAtIndex = s.charAt(i);
            allCharsAsStrings.add(String.valueOf(charAtIndex));
            //Stream.of(String.valueOf(charAtIndex));//StreamOfString
        }
        return allCharsAsStrings.stream();
    }

    public static Stream<String> getCharStream(String s, int index) {
        char charAtIndex = s.charAt(index);
        return Stream.of(String.valueOf(charAtIndex));//StreamOfString
    }
}
