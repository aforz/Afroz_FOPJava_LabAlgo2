package com.gl.lab.problem2;

import java.util.Scanner;

public class MinNoOfNotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of currency denominations ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("enter the currency denominations value\n");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        System.out.println("enter the amount you want to pay");
        int targetAmt = sc.nextInt();
        int[] sortedArray = sortArray(arr);
        int[] counts = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            if (targetAmt >= sortedArray[i]) {
                counts[i] = targetAmt / sortedArray[i];
                targetAmt = targetAmt % sortedArray[i];
            }
        }
        System.out.println("Your payment approach in order to give min no of notes will be");
        for (int i = size - 1; i >= 0; i--) {
            if (counts[i] != 0) {
                System.out.println(sortedArray[i] + " : " + counts[i]);
            }
        }
    }

    private static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
