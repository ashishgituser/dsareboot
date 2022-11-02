package dsa450.array.easy;

/*
You are given a positive integer ‘N’. Your task is to find and return its square root.
If ‘N’ is not a perfect square, then return the floor value of sqrt(N).

For ‘N’  = 25, return 5 , for ‘N’ = 20 return 4, for ‘N’ = 2 return 1.

Sample Input 1:
2
4
6
Sample Output 1:
2
2
Explanation Of Sample Input 1:
In the first test case, the square root of the given number 4 is 2.

In the second test case, the square root of the given number 6 lies between 2 and 3, so the floor value is 2.
 */
public class SquareRootOfNumber {

    public static void main(String[] arg) {
        System.out.println(squareRootUsingBinarySearch(100));
    }

    /*
    Approach - 1 (Brute force)
    -----------------------------------------
    We know square root of a number lies between 1 to N. So, we can seach for that number from 1 to N.
    what is square root -> sqrt(N) = y -> N == pow(y, 2).
    So we need to search for a number whose pow(y, 2) == N that means it is square root.
    otherwise, we need to take lesser number.
     */
    public static int sqrtN(long N) {
        int ans = 0;
        for (int i = 1; i < N; i++) {
            if (i * i == N) {
                ans = i;
            } else if ((i * i) < N) {
                ans = i;
            } else if ((i + 1) * (i + 1) > N) {
                break;
            }
        }

        return ans;
    }

    /*
    Approach - 2 (Binary Search)
    -------------------------------------
    Since, we know we have to search for a number which can be square root of N.
    We can do so with the help of binary search as well.
    1. if N == (N / mid) we found the number
    2. if N <  (N / mid), we store mid and move next. l = mid + 1
    3. else h = mid - 1
    4. if we did not find any answer inside loop then return ans at the end.
     */

    public static int squareRootUsingBinarySearch(long N) {
        long low = 0, high = N, ans = 0, mid = 0;

        while (low <= high) {
            mid = (low + (high - low) / 2);

            if (N == 0) return 0;
            if (N == 1) return 1;

            if (mid == (N / mid)) return (int) mid;
            else if (mid < (N / mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }


}
