package com.example.tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class TaskNine {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int[] prices = new int[count];
        for (int i = 0; i < count; i++) {
            prices[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Lunches lunches = new Lunches(prices);
        System.out.println(lunches.sum());
    }
}

class Lunches {
    private List<Lunch> lunches = new ArrayList<>();

    public Lunches(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            lunches.add(new Lunch(i, prices[i]));
        }
    }

    private Map<Lunch, Lunch> economy = new HashMap<>();

    public int sum() {
        Lunch firstCoupon = getNextCoupon(lunches.size());
        if (firstCoupon != null) {
            economy(firstCoupon);
        }
        System.out.println("_________________________________");
        for (Map.Entry<Lunch, Lunch> pair : economy.entrySet()) {
            System.out.println("coupon: " + pair.getKey() + " spend on: " + pair.getValue());
        }
        int sum = 0;
        for (Lunch lunch : lunches) {
            if (economy.values().contains(lunch)) {
                continue;
            }
            sum += lunch.getPrice();
        }

        return sum;
    }

    private void economy(Lunch lunch) {
        Lunch maxPrice = getMaxPrice(lunch);
        if (economy.containsKey(maxPrice)) {
            Lunch maxPrice1 = getExpectedMaxPrice(lunch);
            if (maxPrice1.getPrice() == -1) {
                Lunch nextCoupon = getNextCoupon(lunch.getNumber());
                if (nextCoupon != null) {
                    economy(nextCoupon);
                }
            }
            Lunch maxPrice2 = economy.get(maxPrice);
            if (maxPrice1.getPrice() + maxPrice2.getPrice() >= maxPrice.getPrice()) {
                economy.put(lunch, maxPrice1);
            } else {
                economy.remove(maxPrice);
                economy.put(lunch, maxPrice);
            }
        } else {
            economy.put(lunch, maxPrice);
        }
        Lunch nextCoupon = getNextCoupon(lunch.getNumber());
        if (nextCoupon != null) {
            economy(nextCoupon);
        }
    }


    private Lunch getMaxPrice(Lunch lunch) {
        Lunch maxPrice = new Lunch(0, 0);
        for (int i = lunch.getNumber() + 1; i < lunches.size(); i++) {
            Lunch newLunch = lunches.get(i);
            if (!economy.values().contains(newLunch) && newLunch.getPrice() > maxPrice.getPrice()) {
                maxPrice = newLunch;
            }
        }
        return maxPrice;
    }

    private Lunch getExpectedMaxPrice(Lunch lunch) {
        Lunch maxPrice = new Lunch(0, -1);
        for (int i = lunch.getNumber() + 1; i < lunches.size(); i++) {
            Lunch newLunch = lunches.get(i);
            if (newLunch.getPrice() > maxPrice.getPrice() && !economy.values().contains(newLunch) && !economy.containsKey(newLunch)) {
                maxPrice = newLunch;
            }
        }
        return maxPrice;
    }


    private Lunch getNextCoupon(int index) {
        for (int i = index - 1; i >= 0; i--) {
            Lunch lunch = lunches.get(i);
            if (lunch.getPrice() > 100 && lunch.getNumber() != lunches.size() - 1) {
                return lunch;
            }
        }
        return null;
    }
}

class Lunch {
    private int number;
    private int price;

    public Lunch(int number, int price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return number + " : " + price;
    }
}
