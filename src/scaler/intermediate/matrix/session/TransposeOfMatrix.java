package scaler.intermediate.matrix.session;

public class TransposeOfMatrix {

    public static void main(String[] arg) {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 5, 7}};
        printMatrix(matrix);
        transpose(matrix);
        printMatrix(matrix);
    }

    public static void transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int e = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = e;
            }
        }
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
