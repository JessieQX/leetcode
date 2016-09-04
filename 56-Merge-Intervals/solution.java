/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        //List<List<Integer>> occupation = new ArrayList<>();
        // for (Interval interval : intervals) {
        //     occupation.add(new ArrayList<>(Arrays.asList(interval.start, interval.end)));
        // }
        Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));
        //occupation.sort((a, b) -> a.get(0) - b.get(0));
        //List<Integer> pre = occupation.get(0);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        // for (int i = 1; i < occupation.size(); i++) {
        //     List<Integer> curr = occupation.get(i);
        //     if (pre.get(1) >= curr.get(0)) {
        //         pre.set(1, Math.max(pre.get(1), curr.get(1)));
        //     } else {
        //         Interval inter = new Interval(pre.get(0), pre.get(1));
        //         res.add(inter);
        //         pre = curr;
        //     }
        // }
        // Interval inter = new Interval(pre.get(0), pre.get(1));
        // res.add(inter);
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}