package scaler.intermediate.prefix.session;

public class Prefix {

    public static void main(String[] arg) {

    }

    public static void prefix(int[] a) {
        int n = a.length;
        int[] prefix = new int[n];

        prefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }
    }
}
