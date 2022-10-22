package scaler.advance.searching1.session;

public class FindFrequencyOfKthElement {

    public static void main(String[] arg) {
        int[] arr = new int[]{-5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 10, 15, 15};
        int firstOccurrence = findFirstOccurrence(arr, 5);
        int lastOccurrence = findLastOccurrence(arr, 5);
        System.out.println("Frequency " + (lastOccurrence - firstOccurrence + 1));
    }

    /*
    N2 -> find and count
    N  -> Use hash map
    third is use the binary search approach.
    1. Find the first occurrence of element index.
    2. Find the last occurrence of element index.
    then ans -> last - first + 1;
     */
    public static int findFirstOccurrence(int[] arr, int k) {
        int l = 0, r = arr.length - 1, first = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) {
                first = mid;
                r = mid - 1;
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return first;
    }

    public static int findLastOccurrence(int[] arr, int k) {
        int l = 0, r = arr.length - 1, last = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) {
                last = mid;
                l = mid + 1;
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return last;
    }
}
