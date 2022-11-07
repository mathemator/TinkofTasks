package com.example.tinkoff;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TaskSev {
    static class Graph {
        private Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        private boolean all(boolean[] arr) {
            for (boolean b : arr) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }

        public Graph(Map<Integer, List<Integer>> map) {
            this.map = map;
        }

        public Graph(int size) {
            for (int i = 0; i < size; i++) {
                map.put(i + 1, new ArrayList<>());
            }
        }

        public void add(int key, List<Integer> list) {
            map.put(key, list);
        }

        public List<Integer> get(int key) {
            return map.get(key);
        }

        public Graph userClone() {
            Map<Integer, List<Integer>> newMap = new LinkedHashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                newMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
            return new Graph(newMap);
        }

        public boolean checkLoop() {
            boolean[] seen = new boolean[map.size() + 1];
            seen[0] = true;

            int target = 1;
            while (!seen[target]) {
                seen[target] = true;
                target = map.get(target).get(0);
            }
            return all(seen);
        }

        public List<Integer> filter(int size) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == size) {
                    list.add(entry.getKey());
                }
            }
            return list;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[count];
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] result = result(numbers);
        System.out.printf("%d %d\n", result[0], result[1]);
    }

    protected static int[] result(int[] numbers) {
        Graph graph = new Graph(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            List<Integer> list = graph.get(numbers[i]);
            if (list == null) {
                List<Integer> newList = new ArrayList<>();
                newList.add(i + 1);
                graph.add(numbers[i], newList);
            } else {
                list.add(i + 1);
            }
        }
        List<Integer> positionTwo = graph.filter(2);
        List<Integer> positionZero = graph.filter(0);

        if (positionTwo.size() == 1 && positionZero.size() == 1) {
            int two = positionTwo.get(0);
            int zero = positionZero.get(0);

            Graph variant1 = graph.userClone();
            int el1 = variant1.get(two).remove(0);
            variant1.get(zero).add(el1);

            Graph variant2 = graph.userClone();
            int el2 = variant2.get(two).remove(1);
            variant2.get(zero).add(el2);

            if (variant1.checkLoop()) {
                return new int[]{el1, zero};
            } else if (variant2.checkLoop()) {
                return new int[]{el2, zero};
            }
        }
        return new int[]{-1, -1};
    }
}

