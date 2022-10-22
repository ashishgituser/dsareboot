package scaler.intermediate.prefix.session;

import java.util.Arrays;
import java.util.List;

class Query {
    int s;
    int e;
    int type;

    public Query(int s, int e, int t) {
        this.e = e;
        this.s = s;
        this.type = t;
    }
}

public class PrefixQueriesEvenOddSum {

    public static void main(String[] arg) {
        int[] a = new int[]{2, 3, 1, -1, 0, 8, 5, 4};
        List<Query> queries = List.of(new Query(3, 6, 1), new Query(1, 5, 2));
        evenOddSum(a, queries);
    }


    public static void evenOddSum(int[] a, List<Query> queries) {
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

        for(Query query : queries) {
            if (query.type == 1) {
                System.out.println("Even sum = " + (prefixEven[query.e] - prefixEven[query.s - 1]));
            }
            else if (query.type == 2) {
                System.out.println("Odd sum = " + (prefixOdd[query.e] - prefixOdd[query.s - 1]));
            }
        }
    }

}
