package com.ak.codingame;

import com.ak.codingame.RockPaperScissorsLizardSpock.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RockPaperScissorsLizardSpockTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[]{
                                "8",
                                "4", "R",
                                "1", "P",
                                "8", "P",
                                "3", "R",
                                "7", "C",
                                "5", "S",
                                "6", "L",
                                "2", "L"},
                        new String[]{
                                "2",
                                "6 5 1"
                        })
        );
    }


    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("")
    void longestCommonSequenceTest(String[] input, String[] result) {
        int N = Integer.valueOf(input[0]); //number of participants
        List<Player> players = new ArrayList<>();
        for (int i = 1; i < N * 2; i = i + 2) {
            players.add(new Player(Integer.valueOf(input[i]), input[i + 1]));
        }

        RockPaperScissorsLizardSpock.game(players);
        Assertions.assertEquals(result[0], RockPaperScissorsLizardSpock.result[0]);
        Assertions.assertEquals(result[1], RockPaperScissorsLizardSpock.result[1]);
    }
}
