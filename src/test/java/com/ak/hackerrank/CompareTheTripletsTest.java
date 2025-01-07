package com.ak.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareTheTripletsTest {

    @Test
    @DisplayName("CompareTheTripletsTest")
    void testCompareTheTriplets() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        Assertions.assertEquals(
            CompareTheTriplets.compareTriplets(list1, list1),
            new ArrayList<>(Arrays.asList(0, 0)));
    }
}
