package com.example.tinkoff;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TaskSevenTest extends TestCase {
    private int[] numbers;
    private void fillArray(int... numbers) {
        this.numbers = numbers;
    }
    private void test (int[] numbers, int index, int number) {
        fillArray(numbers);
        Assert.assertArrayEquals(new int[]{index,number}, TaskSeven.result(numbers));
    }

    @Test
    public void test1(){
        test(new int []{1,3,1},1,2);
        test(new int[]{1,2,3}, -1,-1);
        test(new int[]{2,5,4,4,3}, 4,1);
        test(new int[]{1,5,2,3,4}, -1,-1);
        test(new int[]{5,1,2,3,4}, -1,-1);
        test(new int[]{3,5,1,2,2}, -1,-1);
        //test(new int[]{2,3,4}, 3,1);
        test(new int[]{3,1,5,5,2},3,4);
        test(new int[]{5,3,1,4,4},4,2);
        test(new int[]{2,1,3,3,4},-1,-1);
    }


}
