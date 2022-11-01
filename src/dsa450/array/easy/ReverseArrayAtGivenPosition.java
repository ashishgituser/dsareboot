package dsa450.array.easy;

import java.util.Arrays;

/*
We have an array ARR = {1, 2, 3, 4, 5, 6} and M = 3 , considering 0
based indexing so the sub array {5, 6} will be reversed and our
output array will be {1, 2, 3, 4, 6, 5}.
 */
public class ReverseArrayAtGivenPosition {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        reverse(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Using two pointer approach we can do that.
     */
    public static void reverse(int[] arr, int pos) {
        int l = pos + 1, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l = l + 1;
            r = r - 1;
        }
    }
}
