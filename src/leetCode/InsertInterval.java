package leetCode;

import java.util.ArrayList;

public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        
        if (intervals == null || len == 0 ) {
            ArrayList<Interval> result = new ArrayList<Interval>();
            result.add(newInterval);
            return result;
        }
        
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > newInterval.start) {
                if (i != 0 && intervals.get(i-1).end >= newInterval.start) {
                    newInterval = merge(intervals.get(i-1), newInterval);
                    intervals.remove(i - 1);
                    i = i - 1;
                }
                while (i <= intervals.size() - 1 && intervals.get(i).start <= newInterval.end) {
                    newInterval = merge(intervals.get(i), newInterval);
                    intervals.remove(i);
                }
                intervals.add(i, newInterval);
                return intervals;
            }
        }
        if (intervals.get(len - 1).end >= newInterval.start) {
            newInterval = merge(intervals.get(len - 1), newInterval);
            intervals.remove(len - 1);
        }
        intervals.add(newInterval);
        return intervals;
    }
    
    public static Interval merge(Interval a, Interval b) {
        Interval newInterval = new Interval();
        newInterval.start = Math.min(a.start, b.start);
        newInterval.end = Math.max(a.end, b.end);
        return newInterval;
    }
}