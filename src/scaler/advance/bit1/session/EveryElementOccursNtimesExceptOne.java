package scaler.advance.bit1.session;

public class EveryElementOccursNtimesExceptOne {

    public static void main(String[] arg) {
        System.out.println(whichNo(new int[] {13, 7, 7, 13, 13, 7, 11}));
    }

    public static int whichNo(int[] a) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int k : a) {
                if ((k & (1 << i)) != 0) count = count + 1;
            }
            if (count % 3 != 0) {
                System.out.println((1 << i));
                result = result + (1 << i);
            }
        }

        return result;
    }
}
