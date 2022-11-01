package scaler.advance.bit2.session;

public class MissingNoInNaturalNos {

    public static void main(String[] arg) {
        System.out.println(missingNoUsingXOR(new int[] {1, 2, 3, 4, 5}));
    }

    public static int missingNo(int[] a) {
        int n = a.length + 1;
        int totalSum = (n * (n + 1)) / 2;
        int arraySum = 0;
        for (int e : a) arraySum = arraySum + e;
        return (totalSum - arraySum);
    }

    public static int missingNoUsingXOR(int[] a) {
        int xOR1 = 0, xOR2 = 0;
        for (int i = 0; i < a.length; i++) {
            xOR1 = xOR1 ^ a[i];
            xOR2 = xOR2 ^ (i + 1);
        }
        xOR2 = xOR2 ^ a.length + 1;
        return (xOR1 ^ xOR2);
    }
}
