package com.ak.codingame;

import com.ak.hackerrank.DiagonalDifference.Pair;
import java.util.*;
import java.io.*;
import java.math.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Auto-generated code below aims at helping you parse the standard input according to the problem statement.
 **/
class Player {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Window {

        int X;
        int Y;
        String result;

        public Window(int x, int y) {
            this.X = x;
            this.Y = y;
        }
    }

    static List<Window> windows = new ArrayList<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        System.err.println(W + " " + H);
        System.err.println(N);
        System.err.println(X0 + " " + Y0);
        int nextX = X0;
        int nextY = Y0;
        // String[][] prevResults = new String[H][W];
        // game loop
        while (true) {
            System.err.println("START");
            String bombDir = in.next();
            System.err.println("BombDir: " + bombDir);

            windows.add(new Window(nextX, nextY, bombDir));
            // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            // x0:y0 x1:y0
            // x0:y1 x1:y1
            // U - x the same y - 1 > 0
            // R - y the same x + 1 < W
            // D - x the same y + 1 < H
            // L - y the same x - 1 > 0
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            List<Window> revertWindows = windows;
            Collections.reverse(revertWindows);

            String symbol = "U";
            if (bombDir.contains(symbol)) {
                int startPoint = 0;
                startPoint = getStartPoint(revertWindows, symbol, startPoint);
                //System.err.println("StartPoint: " + startPoint);
                nextY = (nextY - startPoint) / 2 + startPoint;
            }

            symbol = "R";
            if (bombDir.contains(symbol)) {
                //System.err.println("RIGHT");
                int startPoint = W;
                startPoint = getStartPoint(revertWindows, symbol, startPoint);
                nextX = (startPoint - nextX) / 2 + nextX;
            }
            symbol = "L";
            if (bombDir.contains(symbol)) {
                int startPoint = 0;
                startPoint = getStartPoint(revertWindows, symbol, startPoint);
                nextX = (nextX - startPoint) / 2 + startPoint;
            }
            symbol = "D";
            if (bombDir.contains(symbol)) {
                //System.err.println("DOWN");
                int startPoint = H;
                startPoint = getStartPoint(revertWindows, symbol, startPoint);
                nextY = (startPoint - nextY) / 2 + nextY;
            }

            Window nextCoordinate = new Window(nextX, nextY);

            if (checkIfExist(nextCoordinate.getX(), nextCoordinate.getY())) {
                //System.err.println("Exist");
                nextCoordinate = getNearC(nextCoordinate);
            }

            nextX = nextCoordinate.getX();
            nextY = nextCoordinate.getY();

            // the location of the next window Batman should jump to.
            System.out.println(nextX + " " + nextY);
        }
    }

    private static boolean checkIfExist(int nextX, int nextY) {
        for (var coordinate : windows) {
            if (coordinate.getX() == nextX && coordinate.getY() == nextY) {
                //System.err.println(nextX + " " + nextY);
                return true;
            }
        }
        return false;
    }

    private static Window getNearC(Window coordinate) {
        String prevResult = "";
        for (Window w : windows) {
            if ((w.X == coordinate.getX()) && (w.Y == coordinate.getY())) {
                prevResult = w.getResult();
                break;
            }
        }
        int nextX = coordinate.getX();
        int nextY = coordinate.getY();
        if (prevResult.contains("R") && (!checkIfExist(nextX + 1, nextY))) {
            nextX = nextX + 1;
            //System.err.println("Move Right");
            return new Window(nextX, nextY);

        }
        if (prevResult.contains("L") && (!checkIfExist(nextX - 1, nextY))) {
            nextX = nextX - 1;
            //System.err.println("Move Left");
            return new Window(nextX, nextY);

        }
        if (prevResult.contains("U") && (!checkIfExist(nextX, nextY - 1))) {
            nextY = nextY - 1;
            //System.err.println("Move Up");
            //System.err.println(nextX + " " + nextY);
            return new Window(nextX, nextY);

        }
        if (prevResult.contains("D") && (!checkIfExist(nextX, nextY + 1))) {
            nextY = nextY + 1;
            //System.err.println("Move Down");
            return new Window(nextX, nextY);

        }
        return new Window(nextX, nextY);
    }

    private static int getStartPoint(
        List<Window> revertWindows,
        String symbol,
        int startPoint) { // H (min), W (min), 0 (max)
        boolean min = startPoint != 0;

        for (Window prevCoordinates : revertWindows) {
            String prevResult = prevCoordinates.getResult();
            System.err.println("Prev: " + prevCoordinates.getX() + " " + prevCoordinates.getY());
            System.err.println("PrevRes: " + prevResult);
            if (!prevResult.contains(symbol)) {
                if ((symbol.equals("D")) || (symbol.equals("U"))) {
                    int prev = prevCoordinates.getY();
                    if (((min) && (prev < startPoint)) || ((!min) && (prev > startPoint))) {
                        startPoint = prev;
                    }
                } else if ((symbol.equals("L")) || (symbol.equals("R"))) {
                    int prev = prevCoordinates.getX();
                    if (((min) && (prev < startPoint)) || ((!min) && (prev > startPoint))) {
                        startPoint = prev;
                    }
                }
            }
        }
        return startPoint;
    }
}