package scaler.advance.bit1.session;

public class OneOddOccurance {

    public static void main(String[] arg) {
        System.out.println(whichNoIsOccuringOdd(new int[]{1, 2, 2, 1, 3, 4, 4, 5, 5}));
    }

    public static int whichNoIsOccuringOdd(int[] a) {
        int n = a.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ a[i];
        }
        return result;
    }
}
