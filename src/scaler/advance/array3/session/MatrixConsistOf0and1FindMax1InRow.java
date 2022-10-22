package scaler.advance.array3.session;

public class MatrixConsistOf0and1FindMax1InRow {

    public static void main(String[] arg) {
        int[][] matrix = new int[][] {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1}
        };

        System.out.println(findMax1InAnyRow(matrix));
    }

    public static int findMax1InAnyRow(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1, count = 0;

        while (r < row && c >= 0) {
            if (matrix[r][c] == 1) {
                c = c - 1;
                count = count + 1;
            }
            else if (matrix[r][c] == 0) {
                r = r + 1;
            }
        }

        return count;
    }
}
