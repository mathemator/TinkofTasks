package com.example.tinkoff;

import java.util.Arrays;
import java.util.Scanner;

public class TaskSixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] players = new int[n];
        for (int i = 0; i < n; i++) {
            players[i] = scanner.nextInt();
        }
        int[] pair = findIndexes(players);
        System.out.println(pair[0] + " " + pair[1]);
    }

    private static boolean checkPlayers(int[] players) {
        for (int i = 0; i < players.length; i++) {
            if ((i + players[i]) % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] findIndexes(int[] players) {
        int[] pair = new int[]{-1, -1};
        for (int i = 0; i < players.length; i++) {
            for (int j = i + 1; j < players.length; j++) {
                int[] copyPlayers = Arrays.copyOf(players, players.length);
                int tmp = copyPlayers[i];
                copyPlayers[i] = copyPlayers[j];
                copyPlayers[j] = tmp;
                if (checkPlayers(copyPlayers)) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return pair;
    }
}
