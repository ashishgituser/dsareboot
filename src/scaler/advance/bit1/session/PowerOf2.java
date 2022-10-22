package scaler.advance.bit1.session;

public class PowerOf2 {

    public static void main(String[] arg) {
        System.out.println(isPowerOfTwoAnd(16));
    }

    public static boolean isPowerOfTwoLoop(int n) {
        while (n != 1) {
            if (n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }

    // All no which are power of 2 have, exactly 1 bit
    public static boolean isPowerOfTwoAnd(int n) {
        return (n & (n - 1)) == 0; // N & (N - 1) it basically unset the closest bit.
    }
}
