package dsa450.array.easy;

import java.util.Arrays;

/*
Given an array 'arr' of size 'N', find the minimum number of swaps required to be made between any two elements
to sort the array in ascending order.
The array does not contain duplicates i.e all the elements of the array are distinct.

Let the given array be [1,5,4,3,2]
we swap index 1 with 4 i.e. 5 -&gt; 2 and 2 with 3 i.e. 4 -&gt; 3 to form the sorted array {1, 2, 3, 4, 5}.

 */
public class MinimumSwapToSortTheArray {

    public static void main(String[] arg) {
        int[] arr = {2, 4, 5, 1, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(sort(arr));
    }

    /*
    Approach - 1
    ---------------------------
    We can use the sorting algorithm which takes minimum swap to sort an array.
    We can use selection sort for that purpose.
     */
    public static int sort(int[] arr) {
        int minIndex, n = arr.length, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (arr[minIndex] < arr[i]) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swaps = swaps + 1;
            }

        }

        return swaps;
    }
}
