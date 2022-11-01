package dsa450.array.easy;

import java.util.Arrays;

/*
You are given an array 'ARR' consisting of 'N' integers.
You need to rearrange the array elements such that all negative numbers appear before all positive numbers.
 */
public class RearrangeArrayToMoveAllNegativeBeforePositive {
    public static void main(String[] arg) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        System.out.println(Arrays.toString(arr));
        moveNegBeforePos(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Approach - 1
    ---------------
    Two pointer approach, i = 0, j = arr.length - 1;
    1. if arr[i] >= 0 then we need to check what about arr[j];
       if (arr[j] < 0) then we need to switch.
       move j = j - 1
    2. if arr[i] < 0 do nothing, increment i
     0  1  2  3   4  5  6   7
     1 -1  3  2  -7 -5  11  6 i = 0, j = 7
     1 -1  3  2  -7 -5  11  6 i = 0, j = 6
     1 -1  3  2  -7 -5  11  6 i = 0, j = 5
    -5 -1  3  2  -7  1  11  6 i = 0, j = 4
    -5 -1  3  2  -7  1  11  6 i = 1, j = 4
    -5 -1  3  2  -7  1  11  6 i = 2, j = 4
    -5 -1 -7  2   3  1  11  6 i = 2, j = 3
     */
    public static void moveAtTheEndTwoPointer(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] >= 0) {
                if (arr[j] < 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j = j - 1;
            }
            else {
                i = i + 1;
            }
        }
    }

    /*
    Another Approach is to use the slow and fast pointer.
    i will go till n and i will check each element if it is neg or pos.
    1. if negative then it's need to place it to it's correct position maintained by zeroIndex.
    2. else do nothong move to next element and repeat.
     */
    public static void moveNegBeforePos(int[] arr) {
        int i = 0, n = arr.length, zeroIndex = 0;
        while (i < n) {
            if (arr[i] < 0) {
                swap(arr, zeroIndex++, i++);
            }
            else {
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
