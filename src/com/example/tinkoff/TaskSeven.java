package com.example.tinkoff;

import java.util.Arrays;
import java.util.Scanner;

public class TaskSeven {
    public static void main(String[] args)  {
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
                if (i + 1 == numbers[i]) {
                    int[] copy = Arrays.copyOf(numbers, numbers.length);
                    copy[i] = number;
                    if (checkLoop(copy)) {
                        return new int[]{i + 1, number};
                    }
                } else if (countOfGivers(numbers[i], numbers) == 2) {
                    int[] copy = Arrays.copyOf(numbers, numbers.length);
                    copy[i] = number;
                    if (checkLoop(copy)) {
                        return new int[]{i + 1, number};
                    }
                }
            }

        }
        return new int[]{-1, -1};

    }

    private static int findNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int count = countOfGivers(i + 1, numbers);
            if (count == 0) {
                return  i + 1;
            }
        }
        return -1;
    }

    private static int countOfGivers(int number, int[] numbers) {
        int givers = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number && numbers[i] != i+1) {
                givers++;
            }
        }
        return givers;
    }

    private static boolean checkLoop(int[] numbers) {
        boolean[] checkLoop = new boolean[numbers.length + 1];
        checkLoop[0] = true;
        int target = 1;
        while (!checkLoop[target]) {
            checkLoop[target] = true;
            target = numbers[target - 1];
        }
        for (boolean isTrue : checkLoop) {
            if (!isTrue) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[] copy) {
        for (int num : copy) {
            System.out.print(num + " ");
        }
    }

}
//    private static boolean checkArray(int[] numbers) {
//        int counter = 1;
//        int number = 1;
//        while (numbers[number - 1] != 1) {
//            if (countOfGivers(number, numbers) == 1) {
//                number = numbers[number - 1];
//                counter++;
//            } else {
//                break;
//            }
//        }
//        if (counter == numbers.length) {
//            return true;
//        }
//        return false;
//    }


