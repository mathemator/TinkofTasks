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
        for (int index : findIndexes(players)) {
            System.out.println(index);
        }
    }
    private static int[] findIndexes(int[] players) {
        int[] pair = {-1, -1};
        int firstIndex = 0;
        int secondIndex = 0;
        int countWrongPositions = 0;
        for (int i = 0; i < players.length; i++) {
            if ((players[i] + i) % 2 == 0) {
                countWrongPositions++;
                if (firstIndex == 0) {
                    firstIndex = i;
                } else if (secondIndex == 0) {
                    secondIndex = i;
                }
            }
        }
        if (countWrongPositions == 2 && (players[firstIndex] + players[secondIndex]) % 2 != 0) {
            pair[0] = firstIndex + 1;
            pair[1] = secondIndex + 1;
        }
        return pair;
    }
}


