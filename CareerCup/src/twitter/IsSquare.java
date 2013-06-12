package twitter;

public class IsSquare {

	static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static double dist(Point p1, Point p2) {

		int x = p1.x - p2.x;
		int y = p1.y - p2.y;

		return Math.hypot(x, y);
	}

	public static void main(String[] args) {

		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 3);
		Point p3 = new Point(3, 1);
		Point p4 = new Point(3, 3);

		double dist1 = dist(p1, p2);
		double dist2 = dist(p1, p3);
		double dist3 = dist(p1, p4);

		double a, b, c;
		if (dist1 == dist2) {
			a = dist1;
			b = dist2;
			c = dist3;
		} else if (dist1 == dist3) {
			a = dist1;
			b = dist3;
			c = dist2;
		} else if (dist2 == dist3) {
			a = dist2;
			b = dist3;
			c = dist1;
		} else {
			System.out.println("Not square");
			return;
		}
		double d = Math.pow(a, 2) + Math.pow(b, 2);
		double e = Math.pow(c, 2);
		if (Math.abs(d - e) < 0.01) {
			System.out.println("Square");
		} else {
			System.out.println("Not Square");
		}
	}

}
