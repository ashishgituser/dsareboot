package dsa450.array.easy;

import java.util.Arrays;

/*
You are given an array ‘ARR’ of size ‘N’ containing each number between 1 and ‘N’ - 1 at least once.
There is a single integer value that is present in the array twice.
Your task is to find the duplicate integer value present in the array.

Find Duplicate
1. Array will always have duplicate
2. Array will container numbers from 1 to N - 1
 */
public class DuplicateInArray {
    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 4, 4};
        System.out.println(duplicateXor(arr));
    }

    /*
    Approach - 1
    -----------------
    Brute force approach
    T.C. = O(n2)
    S.C. = O(1)
     */
    public static int findDuplicate(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) count = count + 1;
            }
            if (count > 1) return arr[i];
        }
        return -1;
    }

    /*
    Approach - 2
    ---------------------------------
    Sort the numbers in asc order and check if two adjacent numbers are same.
    T.C. = O(N long N)
    S.C. = O(1)
     */
    public static int findDuplicateSort(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return arr[i];
        }
        return -1;
    }

    /*
    Approach -3
    ---------------------------------------
    Using frequency - either we can use hashmap.
    or we can use array table because array contains numbers from 1 to n - 1
    T.C. - O(N)
    S.C. - O(N)
     */
    public static int findDuplicateFrequencyTable(int[] arr) {
        int n = arr.length;
        int[] table = new int[n];

        for (int i = 0; i < n; i++) {
            table[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (table[i] > 1) return table[i];
        }

        return -1;
    }

    /*
    Approach - 4 (XOR)
    ---------------------------------------
    We can make use of XOR. We know the xor property A ^ A = 0
    Since we have elements from 1 to N - 1, then we can do two things.
    1. Create xorSum and xor all the elements of the array.
    2. Then use this xorSum and then xor all the elements from 1 to N
    Basically we are creating the duplicate 1 ^ 1 = 0, then in case of 4
    4 ^ 4 ^ 4 = 4
     */
    public static int duplicateXor(int[] arr) {
        int xorSum = 0;
        for (int i = 0; i < arr.length; i++) {
            xorSum = xorSum ^ arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            xorSum = xorSum ^ i;
        }
        return xorSum;
    }
}
