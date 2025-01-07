package com.ak.leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ShortestPalindrome {

    private static final Logger logger = Logger.getLogger(ShortestPalindrome.class.getName());
    public static final String TEST = "aacecaaa";// "cacbe";

    public static void main(String[] args) {
        //isPolindrom("aaa");
        //isPolindrom("aa");
        //str = "aa";
        logger.log(Level.INFO, "{0}", shortestPalindrome(TEST));
    }


    //"cac be"
    //"a a c e c a a a"
    // 0 1 2 3 4 5 6 7
    protected static String shortestPalindrome(String s) {
        if (s.trim().isEmpty() || s.trim().length() == 1) {
            return s;
        }
        int x = 0;
        int y = s.length() - 1;
        int index = 0;
        //for(int i = 0; i < s.length(); ++i) {
        while (x != y || x - 1 != y) {
            if (s.charAt(x) == s.charAt(y)) {
                ++x;
                --y;
            } else {
                //оставить x как есть и уменьшать y до тех пор пока не найду одинаковые
                --y;
                index = y;
                //index = i; break;
            }
        }
        /*
        while (s.charAt(x) != s.charAt(y)) {
            --y;
            if (x == y || y == x - 1) return s;//для ченых и для нечетных
        }
*/
        String newString = s.substring(y + 1);
        StringBuilder prefix = new StringBuilder();
        prefix.append(newString).reverse().append(s);

        return prefix.toString();
    }

    //Time Limit Exceeded
    public static String shortestPalindromeFirstSollution(String s) {
        //if(s.chars().distinct().count() == 1) return s;
        String tempStr = s;
        int count = 0;
        while (!isPolindrom(tempStr)) {
            char[] chars = s.toCharArray();

            StringBuilder prefix = new StringBuilder();
            for (int i = chars.length - 1; i >= chars.length - 1 - count; --i) {
                prefix.append(chars[i]);
            }
            ++count;
            tempStr = prefix + s;
        }

        return tempStr;
        //res.append(s.substring(end, s.length())).reverse().append(s.substring(0, end)).append(s.substring(end, s.length()));
    }

    //            "ecdadce",
    //            "ecdaadce"
    protected static boolean isPolindromString(String str) {
        char[] ch = str.toCharArray();

        int middle = ch.length / 2;
        String subStr1 = str.substring(0, middle);
        StringBuilder subStr2 = new StringBuilder();
        int mod = ch.length % 2;
        int min = mod == 0 ? middle - 1 : middle;
        for (int i = ch.length - 1; i > min; --i) {
            subStr2.append(ch[i]);
        }

        return subStr1.equals(subStr2.toString());
    }

    protected static boolean isPolindromChar(String str) {
        if (str.trim().isEmpty() || str.trim().length() == 1) {
            return true;
        }
        char[] ch = str.toCharArray();
        int x = 0;
        int y = ch.length - 1;
        while (ch[x] == ch[y]) {
            ++x;
            --y;
            if (x == y || y == x - 1) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isPolindrom(String str) {
        if (str.trim().isEmpty() || str.trim().length() == 1) {
            return true;
        }
        //char[] ch = str.toCharArray();
        int x = 0;
        int y = str.length() - 1;
        while (str.charAt(x) == str.charAt(y)) {
            ++x;
            --y;
            if (x == y || y == x - 1) {
                return true;// == 0) return true;
            }
        }
        return false;
    }

    public String shortestPalindromeAlternativeSollution(String s) {
        StringBuilder res = new StringBuilder();
        int j = 0;
        int end = s.length();
        while (true) {
            j = 0;
            for (int i = (end - 1); i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
            }
            if (j == end) {
                break;
            }
            end = j;
        }
        res.append(s.substring(end, s.length())).reverse().append(s.substring(0, end)).append(s.substring(end, s.length()));
        return res.toString();
    }

}
