package com.myjava.test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

interface Work {
    public void doWork(int k);
}

class C1 {
    int x;

    C1(int k) {
        x = k;
    }

    public int sum() {
        return x * x;
    }

    @Override
    public String toString() {
        return "===" + x;
    }
}

public class SupplierTest {

    public static void main(String args[]) {
        Work w = new Work() {
            public void doWork(int k) {
                System.out.println("working..");
            }
        };
        w.doWork(2);

        Work w2 = (k) -> {
            System.out.println("working lambda..." + k);
        };
        w2.doWork(5);

        test(() -> {return "aaaa";});

        Supplier<C1> c1Producer = SupplierTest::c1Maker;
        for (int i = 0; i < 4; i++) {
            System.out.println(c1Producer.get());
        }
    }

    public static C1 c1Maker() {
        int k = ThreadLocalRandom.current().nextInt(2, 10);
        C1 c1 = new C1(k);
        return c1;

    }

    public static void test(Supplier<String> c) {
        System.out.println(c.get());

    }

}

/*
 * int sum = widgets.stream() .filter(w -> w.getColor() == RED) .mapToInt(w ->
 * w.getWeight()) .sum();
 */
