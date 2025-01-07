package com.ak.leetcode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

//2540. Minimum Common Value
public class MinimumCommonValue {

    private static final Logger logger = Logger.getLogger(MinimumCommonValue.class.getName());

    private static final int[] initialArray11 = new int[]{1, 2};
    private static final int[] initialArray12 = new int[]{2, 4};
    private static final int[] initialArray21 = new int[]{2, 3};
    private static final int[] initialArray22 = new int[]{3, 5};

    public static void main(String[] args) {

        int firstTestResult = doSmth(initialArray11, initialArray12);
        int secondTestResult = doSmth(initialArray21, initialArray22);

        logger.log(Level.INFO, String.valueOf(firstTestResult));
        logger.log(Level.INFO, String.format("Second result is %s", secondTestResult));
    }

    private static int doSmth(int[] nums1, int[] nums2) {
        AtomicInteger returnVal = new AtomicInteger(-1);

        for (int i = 0; i < nums1.length; ++i) {
            int finalI = i;
            returnVal.set(
                Arrays.stream(nums2)
                    .filter(y -> y == nums1[finalI])
                    .findFirst()
                    .orElse(-1));
            if (returnVal.get() != -1) {
                break;
            }
        }
  /*
        Arrays.stream(nums1).forEach(x -> { //returnVal.set(
            if(returnVal.get() == -1)
                returnVal.set(
                    Arrays.stream(nums2).filter(y -> y == x).findFirst().orElse(-1)
                    );
              //          .forEach(y -> { if( y == x) {
                //            System.out.println(x);
                //            returnVal.set(y);} }
        //        )
        //);
        });
*/
  /*
        Arrays.stream(nums1).forEach(x -> { if(Arrays.stream(nums2).anyMatch(n -> n == x)) {
            System.out.println(x);
            if(returnVal.get() == -1)
                returnVal.set(x);
        } });
*/
        return returnVal.get();
    }
}
