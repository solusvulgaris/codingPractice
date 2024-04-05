package com.ak.codingame;

import java.util.HashSet;
import java.util.Set;

//     i
//     0    j = 0 1 2 | 3 4 5 | 6 7 8
//     1    j = 0 1 2 | 3 4 5 | 6 7 8
//     2    j = 0 1 2 | 3 4 5 | 6 7 8
//              ---------------------
//     3    j = 0 1 2 | 3 4 5 | 6 7 8
//     4    j = 0 1 2 | 3 4 5 | 6 7 8
//     5    j = 0 1 2 | 3 4 5 | 6 7 8
//              ---------------------
//     6    j = 0 1 2 | 3 4 5 | 6 7 8
//     7    j = 0 1 2 | 3 4 5 | 6 7 8
//     8    j = 0 1 2 | 3 4 5 | 6 7 8
public class SudokuValidator {

    private static final int[][] massive = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4}
    };

    public static void main(String[] args) {
        /* //Embeded code block from codingame platform

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        Scanner in = new Scanner(System.in);
        int[][] massiv = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int n = in.nextInt();
                massiv[i][j] = n;
            }
        }
        */

        for(int k = 0; k < 9; k += 3 ) {
            for (int m = 0; m < 9; m += 3) {
                checkOneSquare(k, m, massive);
            }
        }

        for(int i = 0; i < 9; i++) {
            Set<Integer> line = new HashSet<>();
            Set<Integer> row = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                line.add(massive[i][j]);
                row.add(massive[j][i]);
            }
            if((line.size() < 9) || (row.size() < 9)) {
                System.out.println("false");
            }
        }

        System.out.println("true");
    }

    protected static void getSquare(int k, int m, int[][] massive, Set<Integer> square) {
        for(int i = k; i < k + 3; i++) {
            for (int j = m; j < m + 3; j++) {
                square.add(massive[i][j]);
            }
        }
    }

    protected static void checkOneSquare(int k, int m, int[][] massive) {
        Set<Integer> square = new HashSet<>();
        getSquare(k, m, massive, square);
        check(square);
    }

    protected static void check(Set<Integer> square){
        if(square.size() < 9) {
            System.out.println("false");
        }
    }
}
