package scaler.intermediate.matrix.session;

public class PrintDiagonalElements {

    public static void main(String[] arg) {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 5, 7}};
        printMatrix(matrix);
        System.out.println("Diagonal left to right");
        printDiagonalLeftToRight(matrix);
        System.out.println("Diagonal right to left");
        printDiagonalRightToLeft(matrix);
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

    public static void printDiagonalLeftToRight(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            System.out.println(matrix[i][i]);
        }
    }

    public static void printDiagonalRightToLeft(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = m - 1; i >= 0; i--) {
            System.out.println(matrix[n - 1 - i][i]);
        }
    }
}
