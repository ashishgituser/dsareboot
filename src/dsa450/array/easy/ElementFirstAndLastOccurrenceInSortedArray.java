package dsa450.array.easy;

import java.util.Arrays;

/*
You have been given a sorted array/list ARR consisting of ‘N’ elements.
You are also given an integer ‘K’.

1. If ‘K’ is not present in the array, then the first and the last occurrence will be -1.
2. ARR may contain duplicate elements.

For example, if ARR = [0, 1, 1, 5] and K = 1, then the first and last occurrence of 1 will be 1(0 - indexed) and 2.
 */
public class ElementFirstAndLastOccurrenceInSortedArray {

    public static void main(String[] arg) {
        int[] arr = {0, 0, 1, 1, 2, 2, 2, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(findFirstAndLastUsingTwoPointer(arr, 2)));
    }

    /*
    Approach - 1
    --------------------------
    We can find first and last occurrence with the help of a flag
     */
    public static int[] findFirstAndLastOn(int[] arr, int k) {
        int first = -1, last = -1;
        boolean firstFound = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                if (!firstFound) {
                    first = i;
                    firstFound = true;
                }
                last = i;
            }
        }

        return new int[]{first, last};
    }

    /*
    Approach - 2
    -------------------------------
    We can minimize the iteration with the help of two pointers.
    take two variables start = 0, end = n - 1;
    go from left to until we find the first
    go from right to left until we find last
     */
    public static int[] findFirstAndLastUsingTwoPointer(int[] arr, int k) {
        int i = 0, j = arr.length - 1, first = -1, last = -1;

        while (i <= j) {
            if (arr[i] == k && first == -1) {
                first = i;
            }

            if (arr[j] == k && last == -1) {
                last = j;
            }
            i = i + 1;
            j = j - 1;
        }
        return new int[]{first, last};
    }

    /*
    Approach - 3
    -------------------------
    Binary search.
    Since array is in sorted state.
    We can use of binary search.
    1. to find first occurrence, we need to move to left till we find the k element.
    2. to find last  occurrence, we need to move to right till we find the k element.
     */

    public static int[] firstAndLastBS(int[] arr, int k) {
        int first = findOccurrence(arr, k, true);
        int last  = findOccurrence(arr, k, false);
        return new int[]{first, last};
    }

    public static int findOccurrence(int[] arr, int k, boolean isFirst) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == k) {
                ans = mid;
                if (isFirst) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }

            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
