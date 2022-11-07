package com.example.tinkoff;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TaskSeven1Test extends TestCase {

    private int[] numbers;
    private void fillArray(int... numbers) {
        this.numbers = numbers;
    }
    @Test
    public void test1(){
        test(new int []{1,3,1},1,2);
        test(new int[]{1,2,3}, -1,-1);
        test(new int[]{2,5,4,4,3}, 4,1);
        test(new int[]{1,5,2,3,4}, -1,-1);
        test(new int[]{5,1,2,3,4}, -1,-1);
        test(new int[]{3,5,1,2,2}, -1,-1);
        test(new int[]{3,1,5,5,2},3,4);
        test(new int[]{5,3,6,4,4,7,8,9,10,11,12,13,14,15,16,17,18,19,20,1},4,2);
        test(new int[]{2,1,3,3,4},-1,-1);



    }


    private void test (int[] numbers, int index, int number) {
        fillArray(numbers);
        Assert.assertArrayEquals(new int[]{index,number}, TaskSeven1.result1(numbers));
    }

}