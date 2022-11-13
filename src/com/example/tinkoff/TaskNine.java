package com.example.tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class TaskNine {

    public static void main(String[] args) throws IOException {
        List<Integer> lunches = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < count; i++) {
            lunches.add(Integer.parseInt(bufferedReader.readLine()));
        }
        Lunches lunch = new Lunches(lunches);
        lunch.sumWithSale();
        System.out.println(lunch.getSum());

    }
     public static class Lunches {

        private  List<Integer> lunches = new ArrayList<>();
        private  int sum = 0;
        private  int maxPrice = -1;

        public Lunches(List<Integer> lunches) {
            this.lunches = lunches;
        }

        public int getSum() {
            return sum;
        }

        public void sumWithSale() {
            int price = 0;
            do {
                price = lunches.get(0);
                if (price != maxPrice) {
                    sum += price;
                }
                lunches.remove(0);
            } while (price <= 100 && lunches.size() > 0);
            if (lunches.size() > 0) {
                maxPrice = maxPrice();
                sumWithSale();
            }
        }

         private int maxPrice() {
            int maxPrice = -1;
            if (lunches.size() > 0) {
                for (Integer price : lunches) {
                    if (price > 100) {
                        return maxPrice;
                    } else if (price > maxPrice) {
                        maxPrice = price;
                    }
                }
            }
            return maxPrice;
        }
    }
}
