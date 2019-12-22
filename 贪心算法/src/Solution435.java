import java.util.Arrays;
import java.util.Comparator;

class Solution435 {

    // 辅助类
    public static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i].start >= intervals[j].end) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }

        }
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(1, 3)};
        System.out.println((new Solution435()).eraseOverlapIntervals(interval1));

        Interval[] interval2 = {new Interval(1, 2),
                new Interval(1, 2),
                new Interval(1, 2)};
        System.out.println((new Solution435()).eraseOverlapIntervals(interval2));

        Interval[] interval3 = {new Interval(1, 2),
                new Interval(2, 3)};
        System.out.println((new Solution435()).eraseOverlapIntervals(interval3));
    }
}