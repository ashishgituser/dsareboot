package scaler.advance.array1.session;

public class MaximumSubArraySum {

    public static void main(String[] arg) {
        findIndexUsingKadanesAlgo(new int[]{-20, 10, -12, 6, 5, -3, 8, 9});
    }

    // N2 consider all sub array
    public static void findMaxSubArraySum(int[] a) {
        int n = a.length;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + a[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println("Max sub array sum = " + maxSum);
    }


    // find the max sub array sum
    public static void usingKadanesAlgo(int[] a) {
        int n = a.length, sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0;
        }
        System.out.println("Max sub array sum = " + maxSum);
    }

    // find index of the sub array with max
    public static void findIndexUsingKadanesAlgo(int[] a) {
        int n = a.length, sum = 0, maxSum = Integer.MIN_VALUE, start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            if (sum > maxSum) {
                end = i;
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        System.out.println("Max sub array sum = " + maxSum + ", [" + start + ", " + end + "]");
    }
}
