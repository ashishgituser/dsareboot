package scaler.intermediate.carrayforward.session;

public class LeftAndRightMax {

    public static void main(String[] arg) {
        leftRightMax(new int[]{-3, 6, 2, 4, 5, 2, 8, -9, 3, 1});
    }


    /*
    The idea is to first pre-calculate the left and right max in an array.
    Then you can get left and right max for left (i - 1) and right (i + 1) simply.
     */
    public static void leftRightMax(int[] a) {
        int n = a.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], a[i]);
        }

        rightMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);
        }

        int index = 6;
        System.out.println("Left max of " + index + ", " + leftMax[index - 1]);
        System.out.println("Right max of " + index + ", " + rightMax[index + 1]);
    }
}
