package com.example.tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskSeven1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[count];
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] result = result1(numbers);
        System.out.println(result[0] + " " + result[1]);
    }

    static int[] result1(int[] numbers) {
        int newRecipient = filter(numbers,0);
        if (newRecipient != -1) {
            int hasTwoGivers = filter(numbers,2);
            if(hasTwoGivers !=-1) {
                for (int i = 0; i < numbers.length; i++) {

                    if (numbers[i] == hasTwoGivers) {
                        int[] newArr = Arrays.copyOf(numbers, numbers.length);
                        newArr[i] = newRecipient;
                        if (checkArr(newArr)) {
                            return new int[]{i + 1, newRecipient};
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }



    private static int filter(int[] numbers, int n) {
        int count = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (countOfGivers(i + 1, numbers) == n) {
                if (count != -1) {
                    count = -1;
                    break;
                } else {
                    count = i + 1;
                }
            }
        }
        return count;
    }

    private static int countOfGivers(int n, int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkArr(int[] numbers) {
        int num = 1;
        int count = 0;
        do {
            num = numbers[num - 1];
            count++;

        } while (num != 1);
        if (count == numbers.length) {
            return true;
        }
        return false;
    }
}
