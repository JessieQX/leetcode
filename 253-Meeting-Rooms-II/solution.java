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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, (o1, o2) -> o1.end - o2.end);
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
        // List<Interval> res = new ArrayList<>();
        // if (intervals == null || intervals.length == 0) return 0;
        // //Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        // Arrays.sort(intervals, new Comparator<Interval>(){
        //     public int compare(Interval a, Interval b) {
        //         if (a.start != b.start) {
        //             return a.start - b.start;
        //         } else {
        //             return b.end - a.end;
        //         }
        //     }
        // });
        // int start = intervals[0].start;
        // int end = intervals[0].end;
        // for (int i = 1; i < intervals.length; i++) {
        //     if (intervals[i].start >= end) {
        //         end = intervals[i].end;
        //     } else {
        //         res.add(new Interval(start, end));
        //         start = intervals[i].start;
        //         end = intervals[i].end;
        //     }
        // }
        // res.add(new Interval(start, end));
        // return res.size();
    }
}