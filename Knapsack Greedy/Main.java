package com.sunchit.company;

import java.util.*;

public class Main {
    public static void knapsack(int n,int []item, float[] weight, float[] profit, float max) {
        float tp = 0, u;
        int i;
        u = max;
        float[] x = new float[20];
        for (i = 0; i < n; i++)
            x[i] = (float) 0.0;
        for (i = 0; i < n; i++) {
            if (weight[i] > u) {
                break;
            } else {
                x[i] = (float) 1.0;
                tp = tp + profit[i];
                u = (int) u - weight[i];
            }
        }
        if (i < n)
            x[i] = u / weight[i];
        tp = tp + (x[i] * profit[i]);
        System.out.println("Resultant Vector");
        for (i = 0; i < n; i++)
            System.out.println("Item:\t"+item[i]+"\tratio:\t"+x[i]);
        System.out.println("Profit Max:" + tp);
    }

    public static void main(String[] args) {
        float weight[] = new float[20];
        float profit[] = new float[20];
        float capacity;
        int num, i, j;
        float ratio[] = new float[20], temp;
        int item[] = new int[10];
        Scanner sn = new Scanner(System.in);
        System.out.println("\nEnter the no. of objects:- ");
        num = sn.nextInt();
        for (i = 0; i < num; i++)
            item[i] = i + 1;
        System.out.println("\nEnter the weights and profits of each object:- ");
        for (i = 0; i < num; i++) {
            weight[i] = sn.nextFloat();
            profit[i] = sn.nextFloat();
        }
        System.out.println("\nEnter the capacity of knapsack:- ");
        capacity = sn.nextFloat();
        for (i = 0; i < num; i++) {
            ratio[i] = profit[i] / weight[i];
        }
        for (i = 0; i < num; i++) {
            for (j = i + 1; j < num; j++) {
                if (ratio[i] < ratio[j]) {
                    temp = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i] = temp;

                    temp = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp;

                    temp = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp;

                    temp = item[j];
                    item[j] = item[i];
                    item[i] = (int) temp;
                }
            }
        }
        knapsack(num,item, weight, profit, capacity);
    }
}
