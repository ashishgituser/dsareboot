package dsa450.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given two integer arrays ARR1 and ARR2 of length N and M respectively.
You have to return true if ARR2 is a subset of ARR1, otherwise, return false.
arr1[] = {1, 2, 3}
arr2[] = {1, 2}
Array 2 is said to be subset of array 1 if all the elements from array 2 are present in array 1.

2
4
1 2 4 6
3
1 2 6
5
9 3 6 5
3
1 3 3
Sample Output 1:
true
false
Explanation For Sample Input 1:
For the first test case:
Here, all the elements of ARR2 are present in ARR1.

For the second test case:
All the elements of ARR2 are not present in ARR1, because there are two 3 in the ARR2 but only a single 3 in ARR1.
 */
public class SubsetArray {
    public static void main(String[] arg) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 5};
        System.out.println(isSubsetHashMap(arr1, arr2));
    }

    /*
    Approach - 1 (Brute force)
    ------------------------
    We will check each and every element from array 2 in array 1.
    If one of the element is not present then it is not subset.
    T.C = O(m * n)
    S.C = O(1)
     */
    public static boolean isSubset(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        for (int i = 0; i < m; i++) {
            boolean isPresent = false;
            for (int j = 0; j < n; j++) {
                if (arr2[i] == arr1[j]) isPresent = true;
            }
            if (!isPresent) return false;
        }
        return true;
    }

    /*
    Approach - 2
    ----------------------
    We can improve the above solution with the help of hash map.
    We also need to check frequency, how many times element is there in both the arrays.
    T.C. => O(n)
    S.C. => O(n)
     */
    public static boolean isSubsetHashMap(int[] arr1, int[] arr2) {
        Map<Integer, Integer> table = new HashMap();
        for (int i = 0; i < arr1.length; i++) {
            if (table.containsKey(arr1[i])) {
                table.put(arr1[i], table.get(arr1[i]) + 1);
            } else {
                table.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (table.containsKey(arr2[i])) {
                int freq = table.get(arr2[i]) - 1;
                if (freq == 0) table.remove(arr2[i]);
                else table.put(arr2[i], freq);
            } else {
                return false;
            }
        }
        return true;
    }

    /*
    Approach - 3 (If there are no duplicates in the array)
    --------------------------------
    We can further improve the performance of above solution.
    We can first sort the both the array, then we can use two pointer approach
     */
    public static boolean isSubsetTwoPointer(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n = arr1.length, m = arr2.length, i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] != arr2[j]) return false;
            i = i + 1;
            j = j + 1;
        }
        return true;
    }
}
