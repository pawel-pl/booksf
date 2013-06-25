package akamai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VideoInterval {

    public static class Interval {
	Integer start;
	Integer end;

	public Interval(int start, int end) {
	    this.start = start;
	    this.end = end;
	}

	public static void sort(List<Interval> intervals) {

	    Collections.sort(intervals, new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
		    return o1.start.compareTo(o2.start);
		}

	    });
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	List<Interval> intervals = new ArrayList<VideoInterval.Interval>();
	// 1-7, 10-15, 5-11, 20-25
	intervals.add(new Interval(1, 7));
	intervals.add(new Interval(10, 15));
	intervals.add(new Interval(5, 11));
	intervals.add(new Interval(20, 25));
	Interval.sort(intervals);

	Interval first = intervals.get(0);
	int sum = first.end - first.start;
	int currentEnd = first.end;
	for (int i = 1; i < intervals.size(); i++) {
	    Interval next = intervals.get(i);
	    if (next.start < currentEnd) {
		// fully included - skip
		if (next.end <= currentEnd) {
		    continue;
		    // partially included - add remaining part
		} else {
		    sum += next.end - currentEnd;
		    currentEnd = next.end;
		}
		// excluded - add whole interval
	    } else {
		sum += next.end - next.start;
		currentEnd = next.end;
	    }
	}

	System.out.println((float) (sum + 1) / 50); // +1 include last minute -
						    // [1 - 7] is 7 not 6
    }

}
