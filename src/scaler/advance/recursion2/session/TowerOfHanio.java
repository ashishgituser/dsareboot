package scaler.advance.recursion2.session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TowerOfHanio {
    public static void main(String[] arg) {
        System.out.println(towerOfHanoi(3));
    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        toh(A, 1, 3, 2, result);
        return result;
    }

    public static void toh(int n, int src, int dest, int mid, ArrayList<ArrayList<Integer>> moves) {
        if (n == 0) return;
        toh(n - 1, src, mid, dest, moves);
        moves.add(new ArrayList<>(Arrays.asList(n, src, dest)));
        toh(n - 1, mid, dest, src, moves);
    }
}
