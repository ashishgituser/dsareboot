package scaler.advance.array1.session;

import java.util.Arrays;
import java.util.List;

class Range {
    int start;
    int end;
    int value;

    public Range(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}

public class BaggerOutSideRangeGiven {

    public static void main(String[] arg) {
        //List<Range> ranges = List.of(new Range(2, 4, 2), new Range(1, 3, 1), new Range(0, 2, 3), new Range(3, 5, 4));
        List<Range> ranges = List.of(new Range(2, 4, 2));
        rangeQueries(ranges, 6);
    }

    /*
    Using the same prefix sum idea, we can solve this problem too.
    We need to add the value at starting position same as before.
    But for end position, we need to minus the value at position end + 1.
    Why end + 1 ?
    Because
                                0 0 0 0 0 0
     normal way (2, 4, 2) ->        2   2
     after prefix result  ->    0 0 2 2 4 4 -> which is wrong, to overcome this issue, we need to put (-value) at end + 1;
                                0 0 0 0 0 0
     prefix way (2, 4, 2) ->        2     -2
     after prefix result  ->    0 0 2 2 2 0 -> which is right;
     */
    public static void rangeQueries(List<Range> ranges, int n) {
        int[] result = new int[n];

        for (int i = 0; i < ranges.size(); i++) {
            Range range = ranges.get(i);
            result[range.start] += range.value;
            if (range.end + 1 < n) {
                result[range.end + 1] -= range.value;
            }
        }

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + result[i];
        }

        System.out.println(Arrays.toString(result));
    }


}
