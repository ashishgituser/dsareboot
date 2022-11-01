package dsa450.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an array 'nums' consisting of first N positive integers.
But from the N integers, one of the integers occurs twice in the array, and one of the integers is missing.
You need to determine the repeating and the missing integer.

Let the array be [1, 2, 3, 4, 4, 5]. In the given array ‘4’ occurs twice and the number ‘6’ is missing.

 */
public class FindTheRepeatingAndMissingNumber {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 2, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(findMissingAndRepeatingXOR(arr)));
    }

    /*
    Approach - 1 (Brute force approach)
    -------------------------
    1. Find the missing number -> go from 1 to n and then find the missing no.
    2. Using the frequency technique we can find out which is occurring twice.
    T.C => O(n2)
    S.C => O(1)
     */
    public static int[] findRepeatingAndMissingNumbersBF(int[] arr) {
        int n = arr.length, missing = -1, repeating = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) count = count + 1;
            }
            if (count > 1) {
                repeating = arr[i];
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean isMissing = true;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) isMissing = false;
            }
            if (isMissing) missing = arr[i];
        }

        missing = missing != -1 ? missing : n;

        return new int[]{repeating, missing};

    }

    /*
    Approach - 2 (Brute force with hash set)
    ------------------------------------
    In the above solution, we are looking for an element in array again and again.
    We can avoid that and make it O(1) time complexity with hash set.

     */
    public static int[] findMissingAndRepeatingHashMap(int[] arr) {
        Map<Integer, Integer> table = new HashMap<>();
        int n = arr.length, missing = n, repeating = -1;

        for (int i = 0; i < n; i++) {
            int no = arr[i];
            if (table.containsKey(no)) {
                table.put(no, table.get(no) + 1);
            } else {
                table.put(no, 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (table.get(arr[i]) > 1) {
                repeating = arr[i];
            }
            if (!table.containsKey(arr[i])) {
                missing = arr[i];
            }
        }

        return new int[]{repeating, missing};
    }

    /*
    Approach - 3
    ---------------------------------------------------
    We can use the approach of visit and mark.
    We can traverse the array, while traversing we can use array value as index and mark that index value as negative by making it negative.
    if again we go to that element and found that value already visited that is repeating no.
    And to find out missing no traverse the array and look for positive number.
     */
    public static int[] findMissingAndRepeatingVisitAndMark(int[] arr) {
        int n = arr.length, missing = n, repeating = -1;

        for (int i = 0; i < n; i++) {
            int value = Math.abs(arr[i]);
            if (arr[value - 1] > 0) {
                arr[value - 1] = -arr[value - 1];
            } else {
                repeating = value;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = (i + 1);
            }
        }

        return new int[]{repeating, missing};
    }

    /*
    Approach - 3
    --------------------------------------
    To find out repeating no, we can make use of XOR operator's property A ^ A = 0, A ^ A ^ A = A

    Let x and y be the desired output elements.
    Calculate XOR of all the array elements.
    xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]

    XOR the result with all numbers from 1 to n
    xor1 = xor1^1^2^…..^n

    In the result xor1, all elements would nullify each other except x and y.
    All the bits that are set in xor1 will be set in either x or y.
    So if we take any set bit (We have chosen the rightmost set bit in code) of xor1 and divide
    the elements of the array in two sets – one set of elements with the same bit set and other set
    with same bit not set. By doing so, we will get x in one set and y in another set. Now if we do XOR of
    all the elements in first set, we will get x, and by doing same in other set we will get y.

     */
    public static int[] findMissingAndRepeatingXOR(int[] nums) {
        int n = nums.length;
        int xor1;
        int set_bit_no;

        int i;
        int x = 0, y = 0;

        xor1 = nums[0];

        for (i = 1; i < n; i++)
            xor1 = xor1 ^ nums[i];

        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        set_bit_no = xor1 & ~(xor1 - 1);

        for (i = 0; i < n; i++) {
            if ((nums[i] & set_bit_no) != 0) x = x ^ nums[i];

            else y = y ^ nums[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0) x = x ^ i;

            else y = y ^ i;
        }

        return new int[]{y, x};
    }
}
