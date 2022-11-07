package com.example.tinkoff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        List<Player> players = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            players.add(new Player(i + 1, scanner.nextInt()));
        }
        int [] indexes = findIndexes(players);
        System.out.println(indexes[0] + " " + indexes[1]);

    }

    private static int[] findIndexes(List<Player> players) {
        int[] indexes = {-1, -1};
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
        if (wrongEvenPos.size() == wrongNotEvenPos.size()) {
            int firstIndex = wrongEvenPos.get(0).getPosition();
            int secondIndex = wrongNotEvenPos.get(0).getPosition();
            indexes = new int[]{firstIndex, secondIndex};
        }
        return indexes;
    }

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
}

