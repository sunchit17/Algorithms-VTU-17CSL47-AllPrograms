package com.sunchit.company;

import java.util.Scanner;

public class Main {
    static int v[][] = new int[20][20];

    public static int max1(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        int p[] = new int[20];
        int w[] = new int[20];
        int i, j, n, max;
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter no. of items");
        n = sn.nextInt();
        for (i = 1; i <= n; i++) {
            System.out.println("Enter weight & profit of item:" + i);
            w[i] = sn.nextInt();
            p[i] = sn.nextInt();
        }
        System.out.println("Enter Capacity");
        max = sn.nextInt();
        for (i = 0; i <= n; i++)
            v[i][0] = 0;
        for (j = 0; j <= max; j++)
            v[0][j] = 0;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= max; j++) {
                if (w[i] > j)
                    v[i][j] = v[i - 1][j];
                else
                    v[i][j] = max1(v[i - 1][j], v[i - 1][j - w[i]] + p[i]);
            }
        }
        System.out.println("Profit:" + v[n][max]);
        System.out.println("items Selected:");
        j = max;
        for (i = n; i >= 1; i--)
            if (v[i][j] != v[i - 1][j]) {
                System.out.println("\tItem:" + i);
                j = j - w[i];
            }
    }
}