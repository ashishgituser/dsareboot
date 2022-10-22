package scaler.advance.searching1.session;

public class FindLocalMinimumElement {

    /*
    Local minimum is the element which is smaller from both i - 1 and i + 1
    We can simply use loop and check each element a[i-1] > a[i] < a[i+1].
    Otherwise we can use binary search approach with 4 cases.
     */
    public static void main(String[] arg) {
        System.out.println(findElement(new int[]{9, 8, 7, 3, 6, 4, 1, 5}));
    }

    public static int findElement(int[] arr) {
        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.println((arr[mid - 1]) + " , " + arr[mid] + ", " + arr[mid + 1]);
            if ((arr[mid - 1] > arr[mid]) && (arr[mid] < arr[mid + 1])) {
                return arr[mid];
            } else if (arr[mid - 1] < arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
