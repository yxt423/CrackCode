package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int len = intervals.size();
        if (intervals == null || len == 0 || len == 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new IntervalComparator());
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval cur = intervals.get(0);
        for (int i = 1; i < len; i++) {
            Interval itv = intervals.get(i);
            if (cur.end >= itv.start) {
                cur.end = Math.max(itv.end, cur.end);
                cur.start = Math.min(itv.start, cur.start);
            } else {
                result.add(cur);
                cur = itv;
            }
        }
        result.add(cur);
        
        return result;
    }
    
    public static void main(String argv[]) {
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	Interval in1 = new Interval(1,4);
    	Interval in2 = new Interval(2,4);
    	intervals.add(in1);
    	intervals.add(in2);
    	System.out.println(merge(intervals));
    }
}

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}


