package dsa450.array.easy;

import java.util.*;

/*
You are given an array ‘Arr’ consisting of ‘N’ distinct integers and a positive integer ‘K’.
Find out Kth smallest and Kth largest element of the array.
It is guaranteed that K is not greater than the size of the array.

Let ‘N’ = 4,  ‘Arr’ be [1, 2, 5, 4] and ‘K’ = 3.
then the elements of this array in ascending order is [1, 2, 4, 5].

Clearly, the 3rd smallest and largest element of this array is 4 and 2 respectively.

After sorting the array
-------------------------------------
smallest => k - 1
and largest => n - k

 */
public class KthSmallestAndLargestElement {

    /*
    7 10 4 20 15
    4 7 10 15 20
     */
    public static void main(String[] arg) {
        int[] arr = {5, 4, 3, 2, 1};
        kthSmallestLargestMinMaxheap(arr, 1);
    }

    /*
    Approach 1 : Brute force
    --------------------
    1. keep on comparing for min element and update the counter.
    2. once the counter is equal to k then stop.
    T.C. - O(n 2)
    S.C. - O(1)
     */
    public static int kthSmallestElement(int[] arr, int k) {
        int n = arr.length, count = 1, preMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            preMin = Math.min(preMin, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (count == k) break;
            int newMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (arr[j] < newMin && arr[j] > preMin) {
                    newMin = arr[j];
                }
            }
            preMin = newMin;
            count = count + 1;
        }
        return preMin;
    }

    /*
    Approach - 2
    -------------------
    we can use collection sort / array sort method to first sort the array and find the kth
     */

    public static void kthSmallestAndLargest(int[] arr, int k) {
        Arrays.sort(arr);

        System.out.println(k + "th smallest - " + arr[k - 1]);
        System.out.println(k + "th largest - " + arr[arr.length - k]);
    }

    /*
    Approach - 3
    --------------------------
    We can use the priority queue or heap. Min and max heap.
    Study heap???????????????????
    Come back after you read about heap
    T.C => O(n)
    S.C => O(k)
     */
    public static void kthSmallestLargestMinMaxheap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) minHeap.remove();
        }

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) maxHeap.remove();
        }

        System.out.println(k + "th smallest - " + maxHeap.peek());
        System.out.println(k + "th largest - " + minHeap.peek());
    }
}
