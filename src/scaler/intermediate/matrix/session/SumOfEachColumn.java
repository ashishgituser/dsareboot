package scaler.intermediate.matrix.session;

public class SumOfEachColumn {

    public static void main(String[] arg) {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 4}};
        sumOfEachColumn(matrix);
    }

    public static void sumOfEachColumn(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, sum = 0;
        for (int i = 0; i < m; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + matrix[j][i];
            }
            System.out.println("Sum of column [" + i + "] = " + sum);
        }
    }
}
