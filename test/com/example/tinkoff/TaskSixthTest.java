package com.example.tinkoff;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static com.example.tinkoff.TaskSixth.findIndexes;


public class TaskSixthTest extends TestCase {
    private int[] numbers;

    private void fillPlayers(int[] numbers) {
        this.numbers = numbers;
    }

    private void test(int[] numbers, int firstIndex, int secondIndex) {
        fillPlayers(numbers);
        Assert.assertArrayEquals(new int[]{firstIndex, secondIndex}, findIndexes(numbers));
    }

    @Test
    public void test1() {
        test(new int[]{2, 1}, 1, 2);
        test(new int[]{1, 2, 3, 4, 5, 6}, 1, 3);
        test(new int[]{4, 3, 1, 2, 5, 7, 3, 4}, -1, -1);
        test(new int[]{3, 6, 7, 8, 8, 8, 9, 9, 9}, 5, 8);

    }

}