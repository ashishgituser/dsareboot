package scaler.intermediate.matrix.session;

public class SumOfEachRow {

    public static void main(String[] arg) {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 4}};
        sumOfEachRow(matrix);
    }

    public static void sumOfEachRow(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < m; j++) {
                sum = sum + matrix[i][j];
            }
            System.out.println("Sum of row [" + i + "] = " + sum);
        }
    }
}
