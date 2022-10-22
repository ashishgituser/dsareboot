package scaler.advance.array3.session;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindFirstMissingPositiveNo {
    public static void main(String[] arg) {

        System.out.println(findMissingPositive(new int[]{1, 2, 5, 4, 3}));
    }

    public static int findMissingN2(int[] a) {
        int n = a.length, missing = -1;

        for (int i = 1; i <= n + 1; i++) {
            boolean flag = false;
            for (int k : a) {
                if (k == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                missing = i;
                break;
            }
        }

        return missing;
    }

    public static int missingUsingHashSet(int[] a) {
        Set<Integer> data = new HashSet<>();
        for (int d : a) if (d > 0) data.add(d);

        int i = 1;
        while (i <= a.length) {
            if (!data.contains(i)) return i;
            i = i + 1;
        }

        return i + 1;
    }

    public static int findMissingUsingSort(int[] a) {
        int n = a.length;
        Arrays.sort(a);

        for (int i = 1; i < n; i++) {
            if (a[i] > 0) {
                if (a[i] - a[i - 1] != 1) return a[i - 1] + 1;
            }
        }

        return n + 1;
    }

    public static int findMissingBooleanArray(int[] a) {
        int n = a.length;
        boolean[] table = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                table[a[i]] = true;
            }
        }

        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (!table[i]) return i;
        }

        return n + 1;
    }

    public static int findMissingPositive(int[] a) {
        int n = a.length, i = 0;

        while (i < n) {
            if (a[i] >= 1 && a[i] <= n) {
                int index = a[i] - 1;
                if (a[index] != a[i]) {
                    int temp = a[index];
                    a[index] = a[i];
                    a[i] = temp;
                }
                else {
                    i = i + 1;
                }
            }
            else {
                i = i + 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if ((j + 1) != a[j]) return j + 1;
        }

        return (n + 1);
    }
}
