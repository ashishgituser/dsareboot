package scaler.intermediate.carrayforward.session;

public class ShortestRangeWithMinMax {
    public static void main(String[] arg) {
        System.out.println(findLengthShortestRange(new int[]{7, 2, 1, 6, 7, 1, 3, 4, 1}));
    }

    /*
    Approach simple - First find min and max in an array
    Then, if we find min first then find the closest max and ans = min of ans - j - i + 1
    if we find max first then same.
     */
    public static int findLengthShortestRange(int[] a) {
        int n = a.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == min) {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] == max) {
                        ans = j - i + 1;
                        break;
                    }
                }
            } else if (a[i] == max) {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] == min) {
                        ans = j - i + 1;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static int findLength(int[] a) {
        int n = a.length, closestMin = -1, closestMax = -1, ans = Integer.MAX_VALUE, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == min) {
                closestMin = i;
                if (closestMax != -1) {
                    ans = Math.abs(closestMax - closestMin) + 1;
                    break;
                }
            }
            else if (a[i] == max) {
                closestMax = i;
                if (closestMin != -1) {
                    ans = Math.abs(closestMax - closestMin) + 1;
                    break;
                }
            }
        }
        return ans;
    }
}
