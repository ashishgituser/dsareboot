package dsa450.array.easy;

import java.util.ArrayList;
import java.util.Arrays;

/*
Ninja and his friend are playing a game in which his friend selects an integer 'N'.
He then picks 'N' random numbers and places them in an array/list ‘NUMARRAY’.

He asks Ninja to find all those numbers which are equal to their index values
i.e. 'NUMARRAY[i]' = ‘i’ where ‘i’ ranges from 0 to 'N' - 1.

Let ‘NUMARRAY’ = [-4, -2, 2, 5]. Here, only 'NUMARRAY[2]' = 2. So, our answer is 2.

Sample Input 2 :
2
4
0 1 2 3
4
-1 1 2 5
Sample Output 2:
0 1 2 3
1 2

 */
public class ValueEqualToIndexValue {

    public static void main(String[] arg) {
        int[] arr = {0, 1, 2, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(valueEqualToIndicesTwoPointer(arr, arr.length));
    }

    /*
    Approach - 1
    ----------------------------------
    We know that arr[i] should be equal to i.
    Then, we can iterate from zero to n - 1 and then check if arr[i] == i.
    T.C = O(n)
    S.C = O(1)
     */

    public static ArrayList<Integer> valueEqualToIndices(int[] numArray, int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (numArray[i] == i) result.add(i);
        }

        if (result.size() == 0) result.add(-1);

        return result;
    }

    /*
    Approach - 2 (if result order is not an issue)
    -----------------------------------

    We can use two pointer approach to look from left and right.
    if arr[l] == l result.add(l)
    if arr[r] == r result.add(r)

     */
    public static ArrayList<Integer> valueEqualToIndicesTwoPointer(int[] numArray, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int l = 0, r = n - 1;

        while (l <= r) {
            if (numArray[l] == l) {
                result.add(l);
            }
            if (numArray[r] == r) {
                result.add(r);
            }
            l = l + 1;
            r = r - 1;
        }

        return result;
    }
}
