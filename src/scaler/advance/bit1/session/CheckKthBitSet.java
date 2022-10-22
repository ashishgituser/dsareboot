package scaler.advance.bit1.session;

public class CheckKthBitSet {

    public static void main(String[] arg) {
        int n = 20;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(isKthBitSetRightShift(n, 3));
    }

    public static boolean isKthBitSet(int n, int k) {
        return (n & (1 << (k - 1))) != 0;
    }

    public static boolean isKthBitSetRightShift(int n, int k) {
        return ((n >> k - 1) & 1) != 0;
    }
}
