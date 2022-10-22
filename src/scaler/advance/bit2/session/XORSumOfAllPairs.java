package scaler.advance.bit2.session;

public class XORSumOfAllPairs {

    public static void main(String[] arg) {
        System.out.println(findSum(new int[]{3, 5, 6, 8}));
    }

    /*
    Contribution technique
    count the set bits from 0 to 31 bits
    Now we can use this count.
    count -> set bits
    (n - count) -> unset bits
    Then we can get the pairs -> (count * (n - count))
    then we calculated the upper triangle, then we can get total pair with -> result * 2;
     */
    public static int findSum(int[] a) {
        int n = a.length, result = 0;

        for (int i = 0; i < 32; i++) {
            int x = 0;
            for (int j = 0; j < n; j++) {
                if ((a[j] & (1 << i)) != 0) x = x + 1;
            }
            result = result + (x * (n - x)) * (i << 1);
        }

        return (result * 2);
    }
}
