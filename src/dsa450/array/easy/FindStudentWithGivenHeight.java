package dsa450.array.easy;

/*
There are 'N' students standing in a line, and their heights are given.
But the constraint is that the difference in heights of adjacent students does not exceed 'K', i.e.,

| height[i] - height[i+1] | <= K, where i ∈  (1, N-1)

Your task is to find the position of a student having height 'H'. If no such student is found, return -1.

Positions are counted starting from 0.
If two or more students have height equal to 'H', return the student with the minimum position.

 */
public class FindStudentWithGivenHeight {
    public static void main(String[] arg) {
        int[] arr = {4, 5, 6, 7, 6};
        System.out.println(findPosition(arr, 1, 6));
    }

    /*
    Approach - 1 (Brute force)
    ------------------------------------
    Approach is simple by using the loop and condition to find the position.
    6 20 60, n = 6, k = 20, h = 60, pos = 5
    0  1  2  3  4  5
    20 40 50 70 70 60

    7 2 6, n = 7, k = 2, h = 6, pos = 6
    0 1 2 3  4 5 6
    9 8 9 10 9 8 6
     */
    public static int findPosition(int[] arr, int k, int h) {
        int n = arr.length, pos = -1;

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) <= k && (arr[i] == h)) {
                pos = i;
            }
        }

        if (pos == -1 && arr[n - 1] == h) {
            pos = n - 1;
        }

        return pos;
    }
}
