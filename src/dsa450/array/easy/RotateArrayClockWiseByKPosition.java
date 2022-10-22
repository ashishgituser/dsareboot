package dsa450.array.easy;

import java.util.Arrays;

public class RotateArrayClockWiseByKPosition {
    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 11);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Approach - 1
    ---------------------
    For clock wise rotation, element at the end will come on front of the array and rest elements will be shifted
    there are three-step process to do so.
    1. reverse array from 0 to n - k - 1
    2. reverse array from n - k to n - 1
    3. reverse the whole array and you will get your answer
     */
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // to overcome from overflow condition, it will reset and start the rotation from start.
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l++, r--);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
