package scaler.advance.searching1.session;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInRotatedArray {

    public static void main(String[] arg) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        int minIndex = findMin(arr);
        int findIndex = binarySearch(arr, 0, minIndex - 1, 2);
        if (findIndex == -1) {
            findIndex = binarySearch(arr, minIndex, arr.size() - 1, 2);
        }
        System.out.println("Found at - " + findIndex);
    }

    public static int findMin(ArrayList<Integer> arr) {
        int l = 0, r = arr.size() - 1, n = arr.size(), min = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            int next = (mid + 1) % n;
            int pre = (mid + n - 1) % n;

            if ((arr.get(mid) <= arr.get(next)) && (arr.get(mid) <= arr.get(pre))) {
                min = mid;
                break;
            }

            if (arr.get(r) > arr.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return min;
    }

    public static int binarySearch(ArrayList<Integer> arr, int l, int r, int k) {
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr.get(mid) == k) return mid;
            else if (arr.get(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
