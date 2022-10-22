package dsa450.array.easy;


import java.util.Arrays;

/*
{4, -9, -2, 6, -8} => {-9, 4, -2, 6, -8}
{1, 2, 3, -5}      => {-5, 1, 2, 3}

 */
public class RearrangeArrayWithNegAndPos {
    public static void main(String[] arg) {
        // int[] arr = {4, -9, -2, 6, -8};
        int[] arr = {1, 2, 3, -5};
        System.out.println(Arrays.toString(arr));
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Approach - 1 (Brute Force)
    -----------------------
    Take extra array and start putting neg and positive numbers
     */
    public static void rearrangeBrute(int[] arr) {
        int n = arr.length, ni = 0, pi = 0;
        int[] negElements = new int[n];
        int[] posElements = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) negElements[ni++] = arr[i];
            if (arr[i] >= 0) posElements[pi++] = arr[i];
        }

        int l = 0, m = 0, i = 0;
        while (l < ni && m < pi) {
            if (i % 2 == 0) {
                arr[i++] = negElements[l++];
            } else {
                arr[i++] = posElements[m++];
            }
        }
        while (l < ni) arr[i++] = negElements[l++];
        while (m < pi) arr[i++] = posElements[m++];
    }

    /*
    Approach - 2
    ----------------------------
    Better approach is to consider the position - -9, 4, -2, 6, -8
    0  1  2  3  4
    4 -9 -2  6 -8

    what we are saying -> at odd positions negative elements will come
                          at even positions positive number will come.
    Now we will create two variables
    i = 0, will go from left to right to each element asking are you on current position
    c = 0, we are using this variable to place element at current place.

    1. if current element is negative and c % 2 == 0, which means
       current element is negative and position is even. which is wrong, we need to swap
       c = c + 1
    2. if current element is positive and c % 2 == 1, which means
       current element is positive but position is odd. which is wrong, we need to swap
       c = c + 1
    3. Current element is at its correct place. do nothing move on i = i + 1

     */
    public static void rearrange(int[] arr) {
        int n = arr.length;
        int i = 0, c = 0;

        while (i < n) {
            if (arr[i] < 0 && c % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[c];
                arr[c] = temp;
                c = c + 1;
            } else if (arr[i] >= 0 && c % 2 == 1) {
                int temp = arr[i];
                arr[i] = arr[c];
                arr[c] = temp;
                c = c + 1;
            } else {
                i = i + 1;
            }
        }
    }
}
