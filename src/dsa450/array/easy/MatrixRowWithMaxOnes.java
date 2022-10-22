package dsa450.array.easy;

import java.util.ArrayList;
import java.util.List;

public class MatrixRowWithMaxOnes {

    public static void main(String[] arg) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(0, 0, 0, 1));
        matrix.add(List.of(0, 0, 1, 1));
        matrix.add(List.of(0, 1, 1, 1));
        matrix.add(List.of(0, 0, 0, 0));
        System.out.println(findRowTwoPointer(matrix, matrix.size(), matrix.get(0).size()));
    }

    /*
    Approach - 1
    ------------------------------------
    We need to go row by row and see which row has maximum 1's
     */
    public static int findRow(List<List<Integer>> matrix, int n, int m) {
        int row = -1, maxOne = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 1) {
                    count = count + 1;
                }
            }
            if (count > maxOne) {
                row = i;
                maxOne = count;
            }
        }
        return row;
    }

    /*
    Approach - 2
    -------------------------------------
    We can use two pointer to travel from top right to bottom left.
    We need to move into two direction.
    1. Start moving from right to left until you find 1
    2. When you find zero then move one row down and then start moving left to right
     */
    public static int findRowTwoPointer(List<List<Integer>> matrix, int n, int m) {
        int row = -1, r = 0, c = m - 1;
        while (r < n && c >= 0) {
            if (matrix.get(r).get(c) == 1) {
                c = c -1;
                row = r;
            }
            else {
                r = r + 1;
            }
        }
        return row;
    }
}
