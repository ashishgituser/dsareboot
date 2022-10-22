package scaler.advance.searching1.session;

public class SearchKthElement {
    public static void main(String[] arg) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
    }

    /*
    Dividing the search space.
    T.C. -> O(long n) -> N -> N/2 -> N/4 --- till 1.
     */
    public static int search(int[] a, int k) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] == k) {
                return mid;
            } else if (a[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
