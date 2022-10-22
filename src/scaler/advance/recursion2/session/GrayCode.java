package scaler.advance.recursion2.session;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    /*
    Generate sequence of number in which two adjacent numbers have exactly one different bit.
    1100
    1110

    Idea is basically - to generate n bit sequence, generate for n - 1, and for n - 1 -> n - 2
    keep on doing till you reach n == 1, for n == 1, there are only two numbers -> 0 and 1 which are different.
    Now the idea is to basically back track from here.
    If you have generated the sequence for n == 1, which is 0 and 1.
    for n == 2, you can reuse the result.
    step 1 -> add 0/1 at the beginning which will not affect the result.
    step 2 -> add the last result as it is which will give us the different bit.
    step 3 -> now keep on adding last result from last size() - 1.

     */
    public static void main(String[] arg) {
        System.out.println(generate(3));
    }

    public static List<Integer> generate(int n) {

        if (n == 1) return List.of(0, 1);

        List<Integer> previousList = generate(n - 1);
        List<Integer> result = new ArrayList<>(previousList);

        for (int i = previousList.size() - 1; i >= 0; i--) {
            result.add(previousList.get(i) + (int) Math.pow(2, n - 1));
        }

        return result;
    }
}
