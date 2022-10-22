package dsa450.array;

public class MaxContiguousSubArraySum {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(maxSubArraySumKadanes(arr));
    }

    /*
    Approach - 1
    --------------------
    Consider all sub arrays and find the max sum between them.
    {1} - 1
    {1, 2} - 3
    {1, 2, 3} - 6
    {1, 2, 3, -2} - 6
    {1, 2, 3, -2, 5} - 9 so on..
    T.C. = O(n 2)
    S.C. = O(1)
     */
    public static int maxSubArraySum(int[] arr) {
        int maxSum = arr[0], n = arr.length;
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /*
    Approach - 2
    --------------------
    We can make use of kadane's algo.
    How did we come to this conclusion
    1. contiguous sub array
    2. array contains positive and negative elements.
    3. need to find max sum
     */
    public static int maxSubArraySumKadanes(int[] arr) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
}
