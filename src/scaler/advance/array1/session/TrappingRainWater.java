package scaler.advance.array1.session;

import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] arg) {
        System.out.println(totalWaterUsingTwoPointer(new int[]{5, 2, 3, 6}));
    }

    public static int totalWater(int[] a) {
        int n = a.length, totalWater = 0;
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

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        for (int i = 1; i < n - 1; i++) {
            totalWater = totalWater + ((Math.min(leftMax[i], rightMax[i])) - a[i]);
        }
        return totalWater;
    }

    public static int totalWaterWithoutLeftMaxArray(int[] a) {
        int n = a.length, totalWater = 0, leftMax = a[0];
        int[] rightMax = new int[n];

        rightMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);
        }

        System.out.println(Arrays.toString(rightMax));

        for (int i = 1; i < n - 1; i++) {
            leftMax = Math.max(leftMax, a[i]);
            totalWater = totalWater + ((Math.min(leftMax, rightMax[i])) - a[i]);
        }
        return totalWater;
    }

    public static int totalWaterUsingTwoPointer(int[] a) {
        int l = 0, r = a.length - 1;
        int leftMax = a[l], rightMax = a[r];
        int result = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l = l + 1;
                leftMax = Math.max(leftMax, a[l]);
                result = result + (leftMax - a[l]);
            } else {
                r = r - 1;
                rightMax = Math.max(rightMax, a[r]);
                result = result + (rightMax - a[r]);
            }
        }

        return result;
    }
}
