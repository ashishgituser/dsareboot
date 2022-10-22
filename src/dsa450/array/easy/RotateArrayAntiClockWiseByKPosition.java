package dsa450.array.easy;

import java.util.Arrays;

public class RotateArrayAntiClockWiseByKPosition {
    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Approach - 1
    ---------------------
    arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
    Output: 3 4 5 6 7 1 2

    rotate right -> clock wise
    rotate left  -> anti clock wise

    1 2 3 4 5 6 7

    Anti clock wise -> left rotation
    2 3 4 5 6 7 1
    3 4 5 6 7 1 2

    1 2 3 4 5 6 7

    Clock wise -> right rotation
    7 2 3 4 5 6 1
    6 7 3 4 5 1 2

    To rotate array anti clock wise, we need to perform three steps.
    Step 1 - reverse(arr, 0, k - 1)
    Step 2 - reverse(arr, k, n - 1)
    Step 3 - reverse(arr, 0, n - 1)

     */
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // to overcome from overflow condition, it will reset and start the rotation from start.
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
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
