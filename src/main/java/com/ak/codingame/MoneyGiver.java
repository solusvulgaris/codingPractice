package com.ak.codingame;

public class MoneyGiver {

    public static void main(String args[]) {
        /*
        Scanner in = new Scanner(System.in);
        int startValue = in.nextInt();
        int budget = in.nextInt();
        */

        int n = howManyTimes_first(10, 125000);//13

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(n);
    }

    public static int howManyTimes_first(int startValue, int budget) {
        int k = 1, n = 0;

        int increaseSumm = startValue;
        while (increaseSumm < budget) {
            increaseSumm = increaseSumm * 2;
            if (increaseSumm < budget) {
                n++;
            }
        }
        return n;

/*        while(budget > 0) {
            budget -= startValue*k;
            k = k*2;
            ++n;
        }
        return n-1;*/
    }
}

