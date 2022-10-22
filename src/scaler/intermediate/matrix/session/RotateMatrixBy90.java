package scaler.intermediate.matrix.session;

public class RotateMatrixBy90 {

    public static void main(String[] arg) {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 5, 7}};
        printMatrix(matrix);
        transpose(matrix);
        reverseRow(matrix);
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

    public static void reverseRow(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int s, e;
        for (int i = 0; i < n; i++) {
            s = 0;
            e = m - 1;
            while (s < e) {
                int ele = matrix[i][e];
                matrix[i][e] = matrix[i][s];
                matrix[i][s] = ele;
                s = s + 1;
                e = e - 1;
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
