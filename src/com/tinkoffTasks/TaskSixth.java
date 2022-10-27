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
        foundIndexes(players);
    }

    private static int countWrongPositions = 0;
    private static int firstIndex = -1;
    private static int secondIndex = -1;

    private static void foundCountWrongPositions(int[] players) {
        for (int i = 0; i < players.length; i++) {
            if ((players[i] + i) % 2 == 0) {
                countWrongPositions++;
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                }
            }
        }
        System.out.println(countWrongPositions);
    }

    private static void foundIndexes(int[] players) {
        foundCountWrongPositions(players);
        if (countWrongPositions != 2) {
            firstIndex = -1;
            secondIndex = -1;
        } else if (players[firstIndex] % 2 == 0 && players[secondIndex] % 2 == 1){
            firstIndex++;
            secondIndex++;
        } else if (players[firstIndex] % 2 == 1 && players[secondIndex] % 2 == 0) {
            firstIndex++;
            secondIndex++;
        } else {
            firstIndex = -1;
            secondIndex = -1;
        }

        System.out.println(firstIndex + " " + secondIndex);

    }
}


