package scaler.intermediate.matrix.session;

public class PrintElements {

    public static void main(String[] arg) {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 4}};
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
