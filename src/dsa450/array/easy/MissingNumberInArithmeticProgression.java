package dsa450.array.easy;

import java.util.Arrays;

/*
You are given a sorted array of ‘N’ distinct integers that are in the Arithmetic Progression sequence
except for one element which is missing from the sequence.
You have to find that missing number from the given sequence.

1. A sequence [arr0, arr1,…, arr(n-1)] is called an Arithmetic progression if for each 'i' ( 0 ≤ i &lt; n - 1) the value arr[i+1] − arr[i] is the same.
2. There is exactly one missing number in the given sequence.
3. All the numbers present in the sequence are distinct.
4. It is the guarantee that the first and last elements of the sequence are not missing elements.

Arithmetic Progression (AP) is a sequence of numbers in order, in which the difference between any two consecutive numbers is a constant value.
It is also called Arithmetic Sequence.
For example, the series of natural numbers: 1, 2, 3, 4, 5, 6,… is an Arithmetic Progression,
which has a common difference between two successive terms (say 1 and 2) equal to 1 (2 -1).
Even in the case of odd numbers and even numbers, we can see the common difference between two successive terms will be equal to 2.

Notation in Arithmetic Progression
--------------------------------------
First term (a)
Common difference (d)
nth Term (an)
Sum of the first n terms (Sn)

-------------------------------------------------------
General Form of AP	      = a, a + d, a + 2d, a + 3d, . . .
The nth term of AP	   an = a + (n – 1) × d
Sum of n terms in AP   S  = n/2[2a + (n − 1) × d]
Sum of all terms in a finite AP with the last term as ‘l’	n/2(a + l)
 */
public class MissingNumberInArithmeticProgression {

    public static void main(String[] arg) {
        int[] arr = {1, 4, 10};
        System.out.println(Arrays.toString(arr));
        System.out.println("Missing - " + findMissingBinarySearch(arr));
    }

    /*
    Approach - 1 (Brute force)
    -----------------------------------------------
    Since, array is sorted, and we know that in AP the common difference between two terms should be equal.
    Then we can simply iterate and check.
    1. Find the common difference - d = (arr[n - 1] - arr[0]) / d
     */
    public static int findMissing(int[] arr) {
        int n = arr.length, d = (arr[n - 1] - arr[0]) / n;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] != d) {
                return arr[i] + d;
            }
        }

        return -1;
    }

    /*
    Approach - 2 (Using XOR)
    -----------------------------------
    We can find missing number with the help of XOR
    1 4 7
    1 + (0 * 3) = 1
    1 + (1 * 3) = 4
    1 + (2 * 3) = 7
    1 + (3 * 3) = 10
    1 4 10 - existing AP - xor - 15
    1 4 7 10 - real AP  - xor - 7
    now xor both
    15 ^ 1 = 14
    14 ^ 4 = 10
    10 ^ 7 = 13
    13 ^ 10 = 7 - missing number
     */
    public static int findMissingUsingXOR(int[] arr) {
        int n = arr.length, d = (arr[n - 1] - arr[0]) / n, a = arr[0];
        int xorSum = 0;

        for (int i = 0; i < n; i++) {
            xorSum = xorSum ^ arr[i];
        }
        System.out.println(xorSum);
        for (int i = 0; i <= n; i++) {
            xorSum = xorSum ^ (a + (i * d));
        }

        return xorSum;
    }

    /*
    Approach - 2 (Binary Search)
    --------------------------------------------------
     */
    public static int findMissingBinarySearch(int[] arr) {
        int n = arr.length, low = 0, high = n - 1, d = (arr[n - 1] - arr[0]) / 2;

        while (low < high) {
            // Find the middle index
            int mid = low + (high - low) / 2;

            // if mid and the immediate next element to mid are not in AP, then missing element is arr[mid] + d.
            if (arr[mid + 1] - arr[mid] != d) return arr[mid] + d;

            // if mid and the immediate previous element to mid are not in AP, then missing element is arr[mid-1] + d.
            if (mid > 0 && arr[mid] - arr[mid - 1] != d) return arr[mid - 1] + d;

            // if elements of the left half are in AP, then missing element is in right half.
            if (arr[mid] == arr[0] + mid * d) low = mid + 1;

                // else missing element is in the left half.
            else high = mid - 1;
        }

        return -1;
    }

}
