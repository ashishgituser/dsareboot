package scaler.advance.searching1.session;

public class FindOneOddNumber {

    public static void main(String[] arg) {
        System.out.println(findOdd(new int[]{3, 3, 1, 1, 8, 8, 10, 10, 9, 6, 6, 2, 2, 4, 4}));
    }

    public static int findOdd(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if ((arr[mid - 1] != arr[mid]) && (arr[mid] != arr[mid + 1])) {
                return arr[mid];
            }
            int first = mid;
            if (arr[mid - 1] == arr[mid]) {
                first = mid - 1;
            }
            if (first % 2 == 0) {
                l = first + 2;
            } else {
                r = first - 1;
            }
        }
        return -1;
    }
}
