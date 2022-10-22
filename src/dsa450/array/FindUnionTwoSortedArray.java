package dsa450.array;

public class FindUnionTwoSortedArray {
    public static void main(String[] arg) {
        int[] a = {85, 25, 1, 32, 54, 6};
        int[] b = {85, 2};
        union(a, b);
    }

    /*
    Approach - 1
    -----------------------
    two pointer approach, we need to move from left to right till a.length and b.length
    if a[i] == a[j], then print only one of them otherwise move further.
    T.C. = O(n + m)
    S.C. = O(1)
     */
    public static void union(int[] a, int[] b) {
        int n = a.length, m = b.length, i = 0, j = 0;
        while (i < n && j < m) {
            System.out.print(a[i] + " ");
            if (a[i] == b[j]) {
                i = i + 1;
                j = j + 1;
            } else {
                i = i + 1;
            }
        }

        while (i < n) {
            System.out.print(a[i] + " ");
            i = i + 1;
        }
        while (j < m) {
            System.out.print(b[j] + " ");
            j = j + 1;
        }
    }
}
