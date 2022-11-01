package com.example.tinkof;

import java.util.Arrays;
import java.util.Scanner;

public class TaskSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] result = result(numbers);
        System.out.println(result[0] + " " + result[1]);

    }

    private static int findIndex(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == i + 1) {
                return i + 1;
            } else {
                for (int j = 0; j < numbers.length; j++) {
                    if (i != j && numbers[i] == numbers[j]) {
                        return j + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static int[] result(int[] numbers) {
        int index = findIndex(numbers);
        if (index != -1) {
            for (int i = 1; i <= numbers.length; i++) {
                int[] copyNumbers = Arrays.copyOf(numbers, numbers.length);
                if (copyNumbers[index - 1] != i) {
                    copyNumbers[index - 1] = i;
                    if (findIndex(copyNumbers) == -1) {
                        return new int[]{index, i};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}