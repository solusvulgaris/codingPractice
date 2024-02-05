package com.ak.codingame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RockPaperScissorsLizardSpock {
    public static String[] result = new String[2];
    public static String[] input = new String[]{
        "8",
                "4", "R",
                "1", "P",
                "8", "P",
                "3", "R",
                "7", "C",
                "5", "S",
                "6", "L",
                "2", "L"};

/*    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt(); //number of participants
            List<Player> players = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                players.add(new Player(in.nextInt(), in.next()));
            }
        }
    }*/

    public static void main() {
        int N = Integer.valueOf(input[0]); //number of participants
        List<Player> players = new ArrayList<>();
        for (int i = 1; i < N * 2; i = i + 2) {
            players.add(new Player(Integer.valueOf(input[i]), input[i + 1]));
        }
        game(players);
    }

    protected static void game(List<Player> players) {
        List<Player> participants = players;
        do {
            participants = playRound(participants);
        } while (participants.size() > 1);

        String winnerNum = String.valueOf(participants.get(0).num);
        String winnerOpponents = participants.get(0).opponents.stream()
                .map(Player::getNum)
                .map(Object::toString)
                .collect(Collectors.joining(" "));//separated by spaces

        // Write an answer using System.out.println()
        System.out.println(winnerNum);
        System.out.println(winnerOpponents);

        result[0] = winnerNum;
        result[1] = winnerOpponents;
    }

    private static List<Player> playRound(List<Player> players) {
        // To debug: System.err.println("Debug messages...");
        System.err.println("New Round, players count = " + players.size());
        List<Player> players1 =
                players.stream()
                        .filter(x -> (players.indexOf(x) % 2 == 0))
                        .collect(Collectors.toList());
        List<Player> players2 =
                players.stream()
                        .filter(x -> players.indexOf(x) % 2 != 0)
                        .collect(Collectors.toList());

        int playersCount = Math.min(players1.size(), players2.size());
        List<Player> winners = new ArrayList<>();
        for (int i = 0; i < playersCount; ++i) {
            Optional<Player> playerOpt = Player.play(players1.get(i), players2.get(i));
            playerOpt.ifPresent(winners::add);
        }
        return winners;
    }

    static class Player implements Comparable<Player> {
        int num;
        String value;
        List<Player> opponents = new ArrayList<>();

        public int getNum() {
            return num;
        }

        public String getValue() {
            return value;
        }

        public Player(int num, String value) {
            this.num = num;
            this.value = value;
        }

        public void addOpponent(Player opponent) {
            opponents.add(opponent);
        }

        @Override
        public int compareTo(Player otherPlayer) {
            System.err.println("First player: " + num + " " + value);
            if (this.value.equals(otherPlayer.value)) {
                System.err.println("Second player: " + otherPlayer.num + " " + otherPlayer.value);
                return -Integer.compare(this.num, otherPlayer.num);
            }

            switch (value) {
                case "R":
                    System.err.println("Second player: " + otherPlayer.num + " " + otherPlayer.value);
                    switch (otherPlayer.getValue()) {
                        case "P":
                        case "S":
                            return -1;
                        case "C":
                        case "L":
                            return 1;
                    }
                case "P":
                    System.err.println("Second player: " + otherPlayer.num + " " + otherPlayer.value);
                    switch (otherPlayer.getValue()) {
                        case "R":
                        case "S":
                            return 1;
                        case "C":
                        case "L":
                            return -1;
                    }
                case "C":
                    System.err.println("Second player: " + otherPlayer.num + " " + otherPlayer.value);
                    switch (otherPlayer.getValue()) {
                        case "R":
                        case "S":
                            return -1;
                        case "P":
                        case "L":
                            return 1;
                    }
                case "L":
                    System.err.println("Second player: " + otherPlayer.num + " " + otherPlayer.value);
                    switch (otherPlayer.getValue()) {
                        case "R":
                        case "C":
                            return -1;
                        case "P":
                        case "S":
                            return 1;
                    }
                case "S":
                    System.err.println("Second player: " + otherPlayer.num + " " + otherPlayer.value);
                    switch (otherPlayer.getValue()) {
                        case "R":
                        case "C":
                            return 1;
                        case "L":
                        case "P":
                            return -1;
                    }
                default:
                    return 0;
            }
        }

        public static Optional<Player> play(Player player1, Player player2) {
            switch (player1.compareTo(player2)) {
                case 0:
                    System.err.println("Two equals players!");
                    throw new RuntimeException();
                case 1: // w == 1 --> winner is player1
                    player1.addOpponent(player2);
                    return Optional.of(player1);
                case -1: // w == -1 --> winner is player2
                    player2.addOpponent(player1);
                    return Optional.of(player2);
                default:
            }
            return Optional.empty();
        }
    }
}
