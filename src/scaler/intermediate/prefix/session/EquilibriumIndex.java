package scaler.intermediate.prefix.session;

public class EquilibriumIndex {

    public static void main(String[] a) {
        System.out.println(isEquilibriumIndexWithoutExtraSpace(new int[]{1, 2, 3, 4, 8, 10}));
    }

    public static int isEquilibriumIndex(int[] a) {
        int n = a.length;
        int[] prefix = new int[n];

        prefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }

        for (int i = 1; i < n - 1; i++) {
            if (prefix[i - 1] == (prefix[n - 1] - prefix[i])) return i;
        }
        return -1;
    }

    public static int isEquilibriumIndexWithoutExtraSpace(int[] a) {
        int n = a.length, leftSum = 0, rightSum = 0;

        for (int i = 0; i < n; i++) {
            rightSum = rightSum + a[i];
        }

        for (int i = 0; i < n; i++) {
            rightSum = rightSum - a[i];
            if (rightSum == leftSum) return i;
            leftSum = leftSum + a[i];
        }

        return -1;
    }
}
