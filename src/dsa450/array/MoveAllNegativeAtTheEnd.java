package dsa450.array;

import java.util.Arrays;

public class MoveAllNegativeAtTheEnd {

    public static void main(String[] arg) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        System.out.println(Arrays.toString(arr));
        moveAtTheEndBruteForce(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Approach 1
    --------------------
    We can use simple approach by using a temp array.
    We will insert positive elements first and then negative element.
    T.C. - O(n)
    S.C. - O(n)
     */
    public static void moveAtTheEndBruteForce(int[] arr) {
        int n = arr.length, index = 0;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) temp[index++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) temp[index++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
