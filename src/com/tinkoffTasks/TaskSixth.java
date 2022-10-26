package com.example.tinkof;

import java.util.Scanner;

public class TaskSixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] players = new int[n];
        for (int i = 0; i < n; i++) {
            players[i] = scanner.nextInt();
        }
        System.out.println(findIndexToChange(players, 0) + " " + findIndexToChange(players, 1));

    }
    private static int findIndexToChange(int[] players, int n) {
        if (isReal(players)) {
            for (int i = n; i < players.length; i += 2) {
                if (n == 0 && players[i] % 2 == 0) {
                    return ++i; //номер игрока больше чем индекс в массиве на 1
                }
                if (n == 1 && players[i] % 2 != 0) {
                    return ++i;
                }
            }
        }
        return -1;
    }

    private static boolean isReal(int[] players) {
        // проверяем сколько перестановок нам понадобится
        int countEven = 0;
        int countUneven = 0;
        for (int i = 1; i < players.length; i += 2) {
            if (players[i - 1] % 2 == 0) {
                countEven++;
            }
            if (players[i] % 2 != 0) {
                countUneven++;
            }
        }
        if (countEven == countUneven && countEven == 1) {
            return true;
        }
        return false;
    }
}
