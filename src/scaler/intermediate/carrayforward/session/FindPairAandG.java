package scaler.intermediate.carrayforward.session;

public class FindPairAandG {

    public static void main(String[] arg) {
        System.out.println(countPairs(new char[]{'b', 'c', 'a', 'g', 'g', 'a', 'a', 'g'}));
    }

    public static int findPair(char[] a) {
        int n = a.length, count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 'a') {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] == 'g') count = count + 1;
                }
            }
        }
        return count;
    }

    /*
    We talk about carry forward technique, we can go from right.
    Take count of 'g' -> We need how many 'g' are there
    Take ans when we find 'a' -> if a -> ans = count + ans;
     */

    public static int countPairs(char[] a) {
        int n = a.length, count = 0, ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == 'g') {
                count = count + 1;
            } else if (a[i] == 'a') {
                ans = count + ans;
            }
        }

        return ans;
    }
}
