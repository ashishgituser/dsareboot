package scaler.advance.bit1.session;

public class CountSetBits {

    public static void main(String[] arg) {
        int n = 3;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(countBits2(n));
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
        }

        return count;
    }

    public static int countBits2(int n) {
        int count = 0;
        while (n > 0) {
            n = (n & (n - 1));
            count = count + 1;
        }
        return count;
    }
}
