package com.sunchit.company;

import java.util.*;

class second implements Runnable {
    private int x;

    second(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("Square of the number is " + (x * x));
    }
}

class third implements Runnable {
    private int x;

    third(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("Cube of the number is " + (x * x * x) + "\n");
    }
}

class first extends Thread {
    public void run() {
        int num;
        int i;
        Random r = new Random();
        try {
            for (i = 0; i < 5; i++) {
                num = r.nextInt(100);
                System.out.println("Generated number is " + num);
                Thread t2 = new Thread(new second(num));
                t2.start();
                Thread t3 = new Thread(new third(num));
                t3.start();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        first a = new first();
        a.start();
    }
}