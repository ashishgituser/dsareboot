package dsa450.array.easy;

import java.util.HashSet;
import java.util.Set;

/*
You are given an array/list ‘ARR’ consisting of ‘N’ distinct integers arranged in ascending order.
You are also given an integer ‘TARGET’.
Your task is to count all the distinct pairs in ‘ARR’ such that their sum is equal to ‘TARGET’.
 */
public class PairSum {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(countPairTwoPointer(arr, 7));
    }

    /*
    Approach - 1
    -----------------------
    Consider all pairs which is n2 approach.
     */
    public static int countPairSumBrute(int[] arr, int k) {
        int n = arr.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k) count = count + 1;
            }
        }
        return count;
    }

    /*
    Approach - 2 Set
    -------------------------------
    1 2 3 4 5 k = 6
    target - arr[i] = put it in set.
    6 - 1 = 5
    6 - 2 = 4
    6 - 3 = 3
    6 - 4 = 2
    6 - 5 = 1
     */
    public static int countPairHashSet(int[] arr, int k) {
        int n = arr.length, count = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                count = count + 1;
            }
            set.add(k - arr[i]);
        }
        return count;
    }

    /*
    Approach - 3 two pointer
    -------------------------------
    This approach can only be used if array is sorted.
    We can see if a[i] == a[j] then we have pair and j = j - 1
    otherwise we can move j = j - 1 if arr[i] + arr[j] > k
    else i = i + 1;
    1 2 3 4 5 - k = 2
    1 5 -> 6 dec j = j - 1
    1 4 -> 5 inc i = i + 1
    2 4 -> 6 dec j = j - 1
    T.C. = O(Log n)
    S.C. = O(1)
     */
    public static int countPairTwoPointer(int[] arr, int k) {
        int n = arr.length, count = 0, i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] + arr[j] == k) {
                count = count + 1;
                i = i + 1;
            } else if (arr[i] + arr[j] < k) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
        return count;
    }
}
