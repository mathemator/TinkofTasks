package com.example.tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class TaskSeven {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[count];
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] result = result(numbers);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] result(int[] numbers) {
        SecretSanta secretSanta = new SecretSanta(numbers);

        List<Integer> zero = secretSanta.filter(0);
        List<Integer> two = secretSanta.filter(2);

        if (zero.size() == 1 && two.size() == 1) {
            int newRecipient = zero.get(0);
            int hasTwo = two.get(0);

            SecretSanta secretSanta1 = secretSanta.copy();
            int newIndex = secretSanta1.get(hasTwo).remove(0);
            secretSanta1.get(newRecipient).add(newIndex);

            if (secretSanta1.checkLoop()) {
                return new int[]{newIndex, newRecipient};
            }

            secretSanta1 = secretSanta.copy();
            newIndex = secretSanta1.get(hasTwo).remove(1);
            secretSanta1.get(newRecipient).add(newIndex);

            if (secretSanta1.checkLoop()) {
                return new int[]{newIndex, newRecipient};
            }
        }
        return new int[]{-1, -1};
    }

    static class SecretSanta {
        private Map<Integer, List<Integer>> map = new HashMap<>();

        public SecretSanta(int[] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                map.put(i + 1, new ArrayList<>());
            }
            for (int i = 0; i < numbers.length; i++) {
                List<Integer> list = map.get(numbers[i]);
                list.add(i + 1);

            }
        }

        public SecretSanta(Map<Integer, List<Integer>> map) {
            this.map = map;
        }

        private boolean checkLoop() {
            int number = 1;
            int counter = 0;
            do {
                if (map.get(number).size() != 1) {
                    return false;
                }
                number = map.get(number).get(0);
                counter++;

            } while (number != 1);

            if (counter == map.size()) {
                return true;
            }
            return false;
        }

        private List<Integer> filter(int size) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == size) {
                    list.add(entry.getKey());
                }
            }
            return list;
        }


        private void printMap() {
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        public List<Integer> get(int key) {
            return map.get(key);
        }

        public SecretSanta copy() {
            Map<Integer, List<Integer>> newMap = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                newMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
            return new SecretSanta(newMap);
        }
    }
}
