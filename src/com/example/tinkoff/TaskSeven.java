package com.example.tinkoff;

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

    protected static int[] result(int[] numbers) {
        int number = findNumber(numbers);
        if (number != -1) {
            for (int i = 0; i < numbers.length; i++) {
                int[] copy = Arrays.copyOf(numbers, numbers.length);
                if (i + 1 == numbers[i] || numbers[i] > numbers.length) {
                    copy[i] = number;
                    if (checkArray(copy)) {
                        return new int[]{i + 1, number};
                    }

                } else if (countOfGivers(numbers[i], numbers) > 1) {
                    copy[i] = number;
                    if (checkArray(copy)) {
                        return new int[]{i + 1, number};
                    }
                }
            }

        }
        return new int[]{-1, -1};

    }

    private static int findNumber(int[] numbers) {
        int number = -1;
        for (int i = 0; i < numbers.length; i++) {
            int count = countOfGivers(i + 1, numbers);
            if (count == 0 && number == -1) {
                number = i + 1;
            } else if (count == 0 && number != -1) {
                number = -1;
                break;
            }
        }
        return number;
    }

    private static int countOfGivers(int number, int[] numbers) {
        int givers = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (number != i + 1 && numbers[i] == number) {
                givers++;
            }
        }
        return givers;
    }

    private static boolean checkArray(int[] numbers) {
        int counter = 1;
        int number = 1;
        while (numbers[number - 1] != 1) {
            number = numbers[number - 1];
            counter++;
        }
        if (counter == numbers.length) {
            return true;
        }
        return false;
    }
}