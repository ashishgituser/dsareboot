package dsa450.array.easy;

import java.util.Arrays;

/*
You have been given an integer array/list (ARR) of size N.
You have to return an array/list PRODUCT such that
PRODUCT[i] is equal to the product of all the elements of ARR except ARR[i]

Each product can cross the integer limits, so we should take modulo of the operation.
Take MOD = 10^9 + 7 to always stay in the limits.

Sample Input 1 :
2
3
1 2 3
3
5 2 2
Sample Output 1 :
6 3 2
4 10 10

 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] arg) {
        int[] arr = {0, 1, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(productWithDivideApproach(arr)));
    }

    /*
    Approach - 1 (Brute force)
    --------------------------
    We can use O(n2) approach, pick one element and calculate the product of remaining ones.
     */
    public static int[] getProductArrayExceptSelf(int[] arr) {
        int n = arr.length;
        int[] product = new int[n];

        for (int i = 0; i < n; i++) {
            int ans = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) ans = ans * arr[j];
            }
            product[i] = ans;
        }

        return product;
    }

    /*
    Approach - 2 (prefix and suffix product)
    ------------------------------------------
    Since, we are calculating the product of remaining elements again and again, we can do something about it.
          1 2 3 - product [6, 3, 2]

    prefix[0] = 1

    i = 1 -> left[1] = left[0] * arr[0] = 1 * 1 = 1
    i = 2 -> left[2] = left[1] * arr[1] = 1 * 2 = 2
    prefix[1, 1, 2]

    suffix[2] = 1

    i = 1 -> right[1] = right[2] * arr[2] = 1 * 3 = 3
    i = 0 -> right[0] = right[1] * arr[1] = 3 * 2 = 6

    suffix[6, 3, 1]
     */

    public static int[] getProduct(int[] arr) {
        int n = arr.length;
        int[] product = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * arr[i - 1];
        }

        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * arr[i + 1];
        }

        for (int i = 0; i < n; i++) {
            product[i] = leftProduct[i] * rightProduct[i];
        }

        return product;
    }

    /*
    Approach - 3 (If array does not contain zero)
    ---------------------------------
    Ge the total product of the whole array.
    Now product[i] = totalProduct / arr[i]
     */
    public static int[] productWithDivideApproach(int[] arr) {
        int n = arr.length, totalProduct = 1;
        int[] product = new int[n];

        for (int i = 0; i < n; i++) {
            totalProduct = totalProduct * arr[i];
        }

        for (int i = 0; i < n; i++) {
            product[i] = totalProduct / arr[i];
        }

        return product;
    }

    /*
    Approach - 3 (without using any extra space)
    -------------------------------------

     */

    public static int[] getProductWithoutAnyExtraSpace(int[] arr) {
        int n = arr.length;
        int[] product = new int[n];

        product[0] = arr[0];
        for (int i = 1; i < n; i++) {
            product[i] = product[i - 1] * arr[i];
        }

        int pr = 1;
        for (int i = n - 1; i > 0; i--) {
            product[i] = product[i - 1] * pr;
            pr = pr * arr[i];
        }

        product[0] = pr;

        return product;
    }
}
