package dsa450.array.easy;

import java.util.ArrayList;

/*
You are given two arrays ‘arr’ of size ‘n’ and ‘queries’ of size ‘q’. For each element ‘q’ in the array 'queries',
your task is to find the sum of all elements in the array ‘arr’ which are less than or equal to ‘q’.

For example:  given array ‘arr = { 1, 2, 3, 3, 4, 5, 6, 7, 9, 10}’ and ‘ queries= { 3, 5}

Then the sum of all elements whose value is less than or equal to

‘queries[0] = 3’ is ‘ 1+2+3+3 =9’.
‘queries[1] = 5’ is ‘1+2+3+3+4+5 =18’.

You have to return the answer of every query { 9, 18}.

2
5 2
1 2 3 4 5
2 4
6 3
2 3 3 4 6 7
3 6 7
Sample Output 1 :
3 10
8 18 25
 */
public class SearchInArrayQuery {

    public static void main(String[] arg) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        arr.add(7);
        ArrayList<Integer> queries = new ArrayList<>();
        queries.add(3);
        queries.add(6);
        queries.add(7);
        System.out.println(searchInTheArrayUsingPrefix(arr, queries, arr.size(), queries.size()));
    }

    /*
    Approach - 1 (Brute force)
    ----------------------------------
    Simple approach is to take number from query and then calculate sum
     */
    public static ArrayList<Integer> searchInTheArrayUsingPrefix(ArrayList<Integer> arr, ArrayList<Integer> queries, int n, int q) {
        ArrayList<Integer> result = new ArrayList<>();
        int sum;

        for (int i = 0; i < q; i++) {
            int query = queries.get(i);
            sum = 0;
            for (int j = 0; j < n; j++) {
                if (arr.get(j) <= query) sum = sum + arr.get(j);
            }
            result.add(sum);
        }
        return result;
    }

    /*
    Approach - 2 (Using prefix array) because array is sorted.
    --------------------------------------------------
    Since, the array is sorted. We can first build up the prefix array sum.
    Then we can find the index of query kth element.
    Now, prefix[kth index] will be containing the sum of all the elements which are less than equal to k.
     */
    public static ArrayList<Integer> searchInTheArray(ArrayList<Integer> arr, ArrayList<Integer> queries, int n, int q) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] prefix = new int[n];

        prefix[0] = arr.get(0);
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr.get(i);
        }

        for (int i = 0; i < q; i++) {
            int index = findIndex(arr, n, queries.get(i));
            if (index != -1) {
                result.add(prefix[index]);
            } else {
                result.add(0);
            }
        }

        return result;
    }

    /*
    Find the last occurance of the element.
    1. if not found and element is greater than the last element -> return n - 1;
    2. if not found and element is greater than the first element -> return -1;
     */
    public static int findIndex(ArrayList<Integer> arr, int n, int no) {

        if (arr.get(n - 1) <= no) return n - 1;
        if (arr.get(0) > no) return -1;

        int l = 0, r = n - 1, ans = -1;
        int mid = l + (r - l) / 2;

        while (l <= r) {
            if (arr.get(mid) == no) {
                ans = mid;
                l = mid + 1;
            } else if (arr.get(mid) < no) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            mid = l + (r - l) / 2;
        }
        return ans;
    }
}
