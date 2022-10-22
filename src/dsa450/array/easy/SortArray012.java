package dsa450.array.easy;

import java.util.Arrays;

public class SortArray012 {
    public static void main(String[] arg) {
        int[] arr = {0, 1, 1, 1, 2, 2, 2, 0, 0, 0};
        System.out.println(Arrays.toString(arr));
        sortTwoPointer(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Approach - 1
    -------------------------
    Count total number of 0,1 and 2
    and then insert them in order
    T.C. -> O(n)
    S.C. -> O(1)
     */
    public static void sort(int[] arr) {
        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zero++;
            if (arr[i] == 1) one++;
            if (arr[i] == 2) two++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (zero > 0) {
                arr[i] = 0;
                zero--;
            } else if (one > 0) {
                arr[i] = 1;
                one--;
            } else {
                arr[i] = 2;
                two--;
            }
        }
    }

    /*
    Approach - 2 - Using two pointer approach
    ----------------------------
    1. We will create three variable zeroIndex - to keep track of zeros
                                     twoIndex  - to keep track of 2 at the end
                                     i         - ith index will keep on going from left till twoIndex.
    2. If current element is zero, we need to place it at zeroIndex position, so we will swap it with (i and zeroIndex)
       we will increment zeroIndex and i
    3. If current element is two which should be at the end. we will place 2 at the twoIndex.
       we will decrement twoIndex, because we already have placed it.
       but we will not increment i this time, because it can be zero or 1. so it should be taken next.
    4. if it is 1 then we will leave it as it is.
     */
    public static void sortTwoPointer(int[] arr) {
        int zeroIndex = 0, twoIndex = arr.length - 1, i = 0;
        while (i <= twoIndex) {
            if (arr[i] == 0) {
                swap(arr, zeroIndex++, i++);
            } else if (arr[i] == 2) {
                swap(arr, twoIndex--, i);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
