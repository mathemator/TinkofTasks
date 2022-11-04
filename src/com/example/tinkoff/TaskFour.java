package com.example.tinkoff;

import java.util.Arrays;
import java.util.Scanner;

public class TaskFour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(sumOfChanges(k, numbers));
    }

    private static int findMaxRank(int[] numbers) {
        int maxRank = 0;
        int[] copyNumbers = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0; i < copyNumbers.length; i++) {
            int numberRank = 0;
            while (copyNumbers[i] / 10 > 0) {
                numberRank++;
                copyNumbers[i] = copyNumbers[i] / 10;
            }
            if (numberRank > maxRank) {
                maxRank = numberRank;
            }
        }
        return maxRank;
    }

    private static long sumOfArray(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] changeNumbers(int[] numbers, int k) {
        int numbersLength = numbers.length;
        int maxRank = findMaxRank(numbers);
        int[] copyNumber = Arrays.copyOf(numbers, numbers.length);
        reverseSort(copyNumber);
           while (maxRank >= 0 && k > 0) {
            int rank = (int) Math.pow(10, maxRank);
            sortByRank(copyNumber, rank);
            for (int i = 0; i < numbersLength; i++) {
                int tmp = copyNumber[i] / rank;
                if (tmp > 0 && tmp % 10 != 9) {
                    int checkRank = (int) Math.pow(10, maxRank + 1);

                    if (copyNumber[i] / checkRank > 0) {
                        copyNumber[i] = copyNumber[i] / checkRank * checkRank + 9 * rank + copyNumber[i] % rank;
                    } else {
                        copyNumber[i] = copyNumber[i] % rank + 9 * rank;
                    }
                    k--;
                    if (k == 0) {
                        break;
                    }
                }
            }
            maxRank--;
        }

        return copyNumber;
    }

    private static long sumOfChanges(int k, int[] numbers) {
        return sumOfArray(changeNumbers(numbers, k)) - sumOfArray(numbers);
    }

    private static void reverseSort(int[] numbers) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > numbers[i - 1]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = tmp;
                    isSorted = false;
                }
            }

        }
    }

    private static void sortByRank(int[] numbers, int rank) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < numbers.length; i++) {
                int tmp = numbers[i] / rank;
                if (tmp > 0) {
                    int tmp1 = numbers[i] % (rank * 10) / rank;
                    int tmp2 = numbers[i - 1] % (rank * 10) / rank;
                    if (tmp1 < tmp2) {
                        int temp = numbers[i];
                        numbers[i] = numbers[i - 1];
                        numbers[i - 1] = temp;
                        isSorted = false;
                    }
                }
            }
        }
    }
}