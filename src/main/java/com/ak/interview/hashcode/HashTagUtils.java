package com.ak.interview.hashcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTagUtils {

    private static final List<String> POSTS = new ArrayList<>(
            Arrays.asList(
                    "Ghbdtn dctv",
                    "Привет #Питер #Москва всем",
                    "Привет #Питер",
                    "Привет #Хабаровск"));

    public static void main(String[] args) {
        List<String> hashTags;
        //How it should be done:
        hashTags = getSortedHashTagsStream(POSTS);
        hashTags.forEach(System.out::println);

        //How it should NOT be done:
        hashTags = getSortedHashTagsSelfWritten(POSTS);
        hashTags.forEach(System.out::println);
    }

    protected static List<String> getSortedHashTagsStream(List<String> posts) {
        return posts.stream().map(s -> s.split(" "))
                .flatMap(x -> Arrays.stream(x).filter(s -> s.contains("#")))
                .sorted().toList();
    }

    protected static List<String> getSortedHashTagsSelfWritten(List<String> posts) {
        List<String> hashTags = new ArrayList<>();

        for (String s : posts) {
            while (s.length() > 0) {
                s = saveTagReturnRest(s, hashTags);
            }
        }
        return hashTags.stream().sorted().toList();
    }

    private static String saveTagReturnRest(String newString, List<String> hashTags) {
        int firstIndex = newString.indexOf("#");

        if (firstIndex == -1) { //when there is no #
            return "";
        }

        String substringFromFirstIndex = newString.substring(newString.indexOf("#"));//#fh #tu
        String substringFromFirstIndexWithoutHash = substringFromFirstIndex.substring(1);//fh #tu

        int secondIndex = substringFromFirstIndexWithoutHash.indexOf("#");

        if (secondIndex > 0) {//when there is at least one more # in String except first one
            String firstTag = newString.substring(firstIndex, firstIndex + secondIndex);
            hashTags.add(firstTag);
            return newString.substring(firstIndex + secondIndex + 1);
        } else { //when there is only one # in String
            int spaceIndex = substringFromFirstIndex.indexOf(" ");
            if (spaceIndex > 0) {
                String firstTag = newString.substring(firstIndex, firstIndex + spaceIndex);
                hashTags.add(firstTag);
            } else {
                hashTags.add(substringFromFirstIndex);
            }
            return "";
        }
    }
}
