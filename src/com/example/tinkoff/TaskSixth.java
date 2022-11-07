package com.example.tinkoff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskSixth {
    static class Player {
        private int number;
        private int position;
        private boolean isRightPos;

        Player(int position, int number) {
            this.number = number;
            this.position = position;
            if ((number + position) % 2 == 0) {
                isRightPos = true;
            } else {
                isRightPos = false;
            }
        }

        public boolean isRightPos() {
            return isRightPos;
        }

        public int getPosition() {
            return position;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] indexes = findIndexes(numbers);
        System.out.println(indexes[0] + " " + indexes[1]);

    }

    protected static int[] findIndexes(int[] numbers) {
        Player[] players = fillPlayers(numbers);
        if (checkPositions(players)) {
            return new int[]{1, 3};
        }
        List<Player> wrongEvenPos = new ArrayList();
        List<Player> wrongNotEvenPos = new ArrayList();
        for (Player player : players) {
            if (!player.isRightPos()) {
                if (player.getPosition() % 2 == 0) {
                    wrongEvenPos.add(player);
                } else {
                    wrongNotEvenPos.add(player);
                }
            }
        }
        if (wrongEvenPos.size() == 1 && wrongNotEvenPos.size() == 1) {
            int firstIndex = wrongEvenPos.get(0).getPosition();
            int secondIndex = wrongNotEvenPos.get(0).getPosition();
            if (firstIndex < secondIndex) {
                return new int[]{firstIndex, secondIndex};
            }
            return new int[]{secondIndex, firstIndex};
        }
        return new int[]{-1, -1};
    }

    private static Player[] fillPlayers(int[] numbers) {
        int n = numbers.length;
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new TaskSixth.Player(i + 1, numbers[i]);

        }
        return players;
    }

    private static boolean checkPositions(Player[] players) {
        for (Player player : players) {
            if (!player.isRightPos) {
                return false;
            }
        }
        return true;
    }
}

