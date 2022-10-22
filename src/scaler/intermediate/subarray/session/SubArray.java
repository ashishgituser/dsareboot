package scaler.intermediate.subarray.session;


public class SubArray {

    public static void main(String[] arg) {
        totalSumOfAllSubArrayUsingCarryForward(new int[] {1, 2, 3, 4});
    }

    // Print all sub array
    public static void subArray1(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k] + ",");
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }

    // O(n 3) approach
    public static void eachSubArraySum(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + a[k];
                }
                System.out.println("Sub Array sum = " + sum);
            }
        }
    }

    // O(n 2) approach using prefix sum
    public static void eachSubArraySumUsingPrefix(int[] a) {
        int n = a.length;
        int[] prefix = new int[n];

        prefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) sum = prefix[j];
                else sum = prefix[j] - prefix[i - 1];
                System.out.println("Sub array sum = " + sum);
            }
        }
    }

    public static void eachSubArraySumUsingPrefixWithoutExtraSpace(int[] a) {
        int n = a.length, sum = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + a[j];
                System.out.println("Prefix sum = " + sum);
            }
        }
    }

    public static void totalSumOfAllSubArray(int[] a) {
        int n = a.length, sum = 0, totalSum = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + a[j];
                System.out.println("Prefix sum = " + sum);
                totalSum = totalSum + sum;
            }
        }

        System.out.println("Total sum = " + totalSum);
    }

    // Carry forward technique
    public static void totalSumOfAllSubArrayUsingCarryForward(int[] a) {
        int n = a.length, totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum = totalSum + (((i + 1) * (n - i)) * a[i]);
        }

        System.out.println("Total sum = " + totalSum);
    }
}
