package scaler.advance.array3.session;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class MergeInterval {

    public static void main(String[] arg) {
        List<Interval> intervals = List.of(
                new Interval(1, 3),
                new Interval(4, 7),
                new Interval(10,14),
                new Interval(16, 19),
                new Interval(21, 24),
                new Interval(27, 30),
                new Interval(32, 35)
        );

        System.out.println(mergeIntervals(intervals, 12, 22));
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals, int iStart, int iEnd) {
        List<Interval> newIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end <= iStart) {
                newIntervals.add(intervals.get(i));
            }
            else if (intervals.get(i).start > iEnd) {
                newIntervals.add(new Interval(iStart, iEnd));
                while (i < intervals.size()) {
                    newIntervals.add(intervals.get(i));
                    i = i + 1;
                }
                return newIntervals;
            }
            else {
                iStart = Math.min(intervals.get(i).start, iStart);
                iEnd   = Math.max(intervals.get(i).end, iEnd);
            }
        }

        newIntervals.add(new Interval(iStart, iEnd));

        return newIntervals;

    }

}
