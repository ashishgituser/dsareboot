package scaler.advance.array1.session;

import java.util.Arrays;

public class BeggersOutSide {

    public static void main(String[] arg) {
        int[][] queries = new int[][]{{1, 3}, {4, 2}, {2, 1}, {1, -1}};
        distributeRangeValuesUsingPrefix(queries, 7);
    }

    public static void distributeRangeValues(int[][] queries, int n) {
        int[] result = new int[n];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int value = queries[i][1];

            for (int j = start; j < n; j++) {
                result[j] = result[j] + value;
            }
        }
        System.out.println(Arrays.toString(result));
    }

    /*
    Another approach is to use concept of prefix array.
    We will be adding value at given place first, then we will build the prefix array.
    Delay the result. When you are asked to give final result out of given queries. Then think of delaying the result.
     */

    public static void distributeRangeValuesUsingPrefix(int[][] queries, int n) {
        int[] result = new int[n];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            result[index] = result[index] + value;
        }

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + result[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
