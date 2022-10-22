package scaler.advance.searching1.session;

public class GreatestElementCloseToKButMin {
    public static void main(String[] arg) {
        System.out.println(findCloseMax(new int[]{-5, 2, 3, 6, 9, 10, 11, 14, 18}, 5));
    }

    public static int findCloseMax(int[] arr, int k) {
        int l = 0, r = arr.length - 1, result = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) return mid;
            else if (arr[mid] < k) {
                result = arr[mid];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
