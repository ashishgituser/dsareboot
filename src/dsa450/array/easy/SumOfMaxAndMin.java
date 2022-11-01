package dsa450.array.easy;

import java.util.Arrays;

/*
You are given an array “ARR” of size N. Your task is to find out the sum of maximum and minimum elements in the array.
 */
public class SumOfMaxAndMin {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 4, 5, 6, 6, 6};
        System.out.println(sumOfMaxMin(arr, arr.length));
    }

    /*
    Approach - 1
    -------------------
    1. Create max and min variable.
    2. Go from 0 to n - 1 and update min and max
    T.C. = O(n)
    S.C. = O(1)
     */
    public static int sumOfMaxMin(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return (max + min);
    }

    /*
    Approach - 2
    ---------------
    1. Sort the array in asc order using quick sort or merge sort.
    2. return the sum of arr[0] + arr[n-1]
    T.C. = O(n log n)
    S.C. = O(1)
     */
    public static int sumOfMaxUsingSort(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] + arr[0];
    }

    /*
    Approach - 3
    --------------------
    I can use two pointer approach.
    1. Compare l and r values extract min and max
    2. then compare min with minValue and max with maxValue
     */
    public static int sumOfMaxMin(int[] arr, int n) {
        int l = 0, r = n - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (l <= r) {
            int minValue = Math.min(arr[l], arr[r]);
            int maxValue = Math.max(arr[l], arr[r]);
            min = Math.min(min, minValue);
            max = Math.max(max, maxValue);
            l = l + 1;
            r = r - 1;
        }
        return (max + min);
    }
}
