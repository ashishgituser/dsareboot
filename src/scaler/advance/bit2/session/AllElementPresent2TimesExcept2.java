package scaler.advance.bit2.session;

public class AllElementPresent2TimesExcept2 {

    public static void main(String[] arg) {
        findNo(new int[]{1, 1, 2, 3, 2, 4});
    }

    public static void findNo(int[] a) {
        int xORSum = 0, n = a.length;

        for (int i = 0; i < n; i++) {
            xORSum = xORSum ^ a[i];
        }

        int setBit = -1;
        for (int i = 0; i < 32; i++) {
            if ((xORSum & (1 << i)) == 1) {
                setBit = i;
                break;
            }
        }

        int xORA = 0, xORB = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] & (1 << setBit)) != 0) {
                xORA = xORA ^ a[i];
            } else {
                xORB = xORB ^ a[i];
            }
        }

        System.out.println(xORA + ", " + xORB);
    }
}
