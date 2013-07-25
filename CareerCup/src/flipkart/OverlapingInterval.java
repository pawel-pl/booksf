package flipkart;

import java.util.Arrays;

/*
 * Think of it as a room and the intervals are times when a person is in the room. 
 * You are looking for time when max number of people are in a room.
 */
public class OverlapingInterval {

    public static class Point implements Comparable<Point> {

	private Integer value;
	private boolean isLeft;

	public Point(int value) {

	    this.value = value;
	}

	@Override
	public int compareTo(Point o) {

	    return this.value.compareTo(o.value);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	// int[] intervals = { 0, 5, 2, 9, 8, 10, 6, 9 };
	int[] intervals = { 1, 20, 2, 8, 2, 22, 3, 15, 8, 12, 14, 17, 19, 20 };
	Point[] points = new Point[intervals.length];
	for (int i = 0; i < intervals.length; i++) {
	    Point p = new Point(intervals[i]);
	    if (i % 2 == 0) {
		p.isLeft = true;
	    }
	    points[i] = p;
	}
	Arrays.sort(points);
	int count = 0;
	int maxCount = 0;
	for (int i = 1; i < points.length; i++) {
	    if (points[i].isLeft) {
		count++;
		maxCount = Math.max(maxCount, count);
	    } else {
		count--;
	    }
	}
	System.out.println(maxCount);
    }
}
