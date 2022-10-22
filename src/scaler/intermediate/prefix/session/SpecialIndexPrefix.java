package scaler.intermediate.prefix.session;

import java.util.Arrays;

public class SpecialIndexPrefix {

    public static void main(String[] arg) {
        specialIndex(new int[] {4, 3, 2, 7, 6, -2});
    }

    public static void specialIndex(int[] a) {
        int n = a.length;
        int[] prefixEven = new int[n];
        int[] prefixOdd = new int[n];

        prefixEven[0] = a[0];

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                prefixEven[i] = prefixEven[i - 1] + a[i];
            } else {
                prefixEven[i] = prefixEven[i - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                prefixOdd[i] = prefixOdd[i - 1] + a[i];
            } else {
                prefixOdd[i] = prefixOdd[i - 1];
            }
        }

        System.out.println(Arrays.toString(prefixEven));
        System.out.println(Arrays.toString(prefixOdd));

        int totalIndex = 0;
        int evenSum, oddSum;

        /*
        When deleting element on index i, we assume that elements will be shifted from right to left.
        That means, even will become odd and odd will become even.
        from (0 to i - 1), there will not be any change in prefix.
        but from (n - 1) to (i) -> elements will be shifted from odd to even and vice versa.
         */

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                evenSum = (prefixOdd[n - 1] - prefixOdd[i]);
                oddSum = (prefixEven[n - 1] - prefixEven[i]);
            }
            else {
                evenSum = prefixEven[i - 1] + (prefixOdd[n - 1] - prefixOdd[i]);
                oddSum = prefixOdd[i - 1] + (prefixEven[n - 1] - prefixEven[i]);
            }

            if (evenSum == oddSum) totalIndex = totalIndex + 1;
        }

        System.out.println("Total Index = " + totalIndex);
    }
}
