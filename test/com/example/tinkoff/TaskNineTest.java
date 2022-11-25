package com.example.tinkoff;


import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TaskNineTest extends TestCase {

    @Test
    public void test1() {
        test(235, new int[]{35, 40, 101, 59, 63});
        test(621, new int[]{20,50,101,200,150,50,150,20,300,10,50,101,20});
        test(621, new int[]{20,101,50,10,300,20,150,50,150,200,101,50,20});
        test(303, new int[]{101, 101, 101, 101, 101});
        test(303, new int[]{101, 101, 101, 101, 101, 101});
        test(302, new int[]{20, 101, 200, 50, 101, 30, 200});
        test(200, new int[]{50,20,70,30,30});
        test(205, new  int[]{105, 50, 105, 50});
        test(150, new int[]{50,100});
    }

    private void test(int sum, int[] numbers) {
        Lunches lunches = new Lunches(numbers);
        Assert.assertEquals(sum, lunches.sum());

    }
}