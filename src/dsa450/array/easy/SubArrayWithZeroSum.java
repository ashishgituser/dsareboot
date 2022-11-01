package dsa450.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
You are given ‘N’ integers in the form of an array ‘ARR’. Count the number of subarrays having their sum as 0.
Let ‘ARR’ be: [1, 4, -5]
The subarray [1, 4, -5] has a sum equal to 0. So the count is 1.

 */
public class SubArrayWithZeroSum {

    public static void main(String[] arg) {
        int[] arr = {-1, 0, 1, -1};
        System.out.println(countSubArraysWithZero(arr));
    }

    /*
    Approach - 1 (Brute Force)
    ---------------------
    Consider all sub arrays.
     */
    public static int countSubArrays(int[] arr) {
        int n = arr.length, count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (sum == 0) {
                    count = count + 1;
                }
            }
        }

        return count;
    }

    /*
    Approach - 2 (Using hash map)
    -----------------------------
    The basic idea is to store the sum of the array while traversing the array.
    We store the sum of the elements traveled. Whenever we find a sum already present in a hashmap,
    we increase our count by the value stored in the hashmap.

    For example:

    If we have a subarray starting from index 0 and ending at index 2 has a sum of 10.
    If there is another subarray starting from index 0 and ending at index 5 has a sum of 10.

    Then the sum of elements from index 3 to index 5 should be 0.

    In this way, we can find the number of subarrays having sum 0 by using the hashmap.
    For each sum found, we add it to our hashmap.

    -1 0 1 -1 = 4

    sum = -1
    sum = -1
    sum =  0
    sum = -1

    count = 0, sum = 0, i = 0, map<0, 1>

    i = 0, sum = -1, count = 0, map<0, 1><-1, 1>
    i = 1, sum = -1, count = 1, map<0, 1><-1, 2>
    i = 2, sum =  0, count = 2, map<0, 2><-1, 2>
    i = 3, sum = -1, count = 4, map<0, 2><-1, 3>
           0  1 2  3
          -1  0 1 -1
     sum  -1 -1 0 -1
     count 0  1 2  4
     freq  1  2 2  3
     */
    public static int countSubArraysWithZero(int[] arr) {
        int n = arr.length, sum = 0, count = 0;
        Map<Integer, Integer> table = new HashMap<>();
        table.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];

            if (table.containsKey(sum)) {
                count = count + table.get(sum);
                table.put(sum, table.get(sum) + 1);
            }
            else {
                table.put(sum, 1);
            }
        }

        return count;
    }
}
