package com.example.tinkoff;

import java.util.Scanner;

public class TaskFives {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        переменные почти всегда (кроме, например, тех, что в цикле for(i=0;...)) лучше называть осмысленно, типа leftBorder? 
        */
        long l = scanner.nextLong();
        long r = scanner.nextLong();

       System.out.println(findCountTests(l, r));
    }

    /*
    имя метода тоже не вполне по-английски звучит. возможные варианты,
    в зависимости от смысла это findTestCount - число тестов?
    хорошо, что имена методов начинаются с глаголов
    */
    private static int findCountTests(long l, long r) {
        int countTests = 0;
        int minRank = findRank(l);
        int maxRank = findRank(r);

        while (maxRank >= minRank) {
            for (int i = 1; i <= 9; i++) {
                long testNumber = findMultiplyNumber(maxRank) * i;
                if (testNumber >= l && testNumber <= r) {
                    countTests++;
                }
            }
            maxRank--;
        }
        return countTests;
    }

    /*
    возможно, лучше подойдёт слово multiplicator
    */
    private static long findMultiplyNumber(int rank) {
        long multiplyNumber = 1;
        while (rank > 0) {
            multiplyNumber += (long) Math.pow(10, rank);
            rank--;
        }
        return multiplyNumber;
    }

    private static int findRank(long n) {
        int rank = 0;
        while (n > 0) {
            if (n / 10 > 0) {
                rank++;
            }
            n = n/ 10;
        }
        return rank;
    }
}

