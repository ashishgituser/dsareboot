package dsa450.array.easy;

/*
You have been given an array/list 'ARR' consisting of 'N' integers.
Your task is to find the majority element in the array.
If there is no majority element present, print -1.

A majority element is an element that occurs more than floor('N' / 2) times in the array.
 */
public class MajorityElement {

    public static void main(String[] arg) {
        int[] arr = {2, 3, 9};
        System.out.println(findMajority(arr));
    }

    public static int findMajority(int[] arr) {
        int count = 0, n = arr.length;
        int majorityElement = findMajorityElement(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] == majorityElement) count = count + 1;
        }
        return count > (n / 2) ? majorityElement : -1;
    }

    /*
    By using moores voting algo

    count = 1, element = 2

    index    0  1  2  3  4
             2  3  9  2  2
    ------------------------
    element  0  1  2  3  3
    count    1  1  1  1  2

    index    0  1  2  3  4  5  6
             8  8  8  8  8  9  1
    -----------------------------
    element  0  0  0  0  0  0  0
    count    1  2  3  4  5  4  3
     */
    public static int findMajorityElement(int[] arr) {
        int count = 0, eleIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[eleIndex]) {
                count = count + 1;
            } else {
                count = count - 1;
            }

            if (count == 0) {
                eleIndex = i;
                count = 1;
            }
        }

        return arr[eleIndex];
    }
}
