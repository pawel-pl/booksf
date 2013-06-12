package tp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * http://p--np.blogspot.fi/2011/07/segment-tree.html
 * https://www.assembla.com/code/code-shengmin/git/nodes/master/quadrant-queries/Solution.cs
 * https://www.hackerrank.com/challenges/quadrant-queries
 * http://woolor.com/InterviewMitra/47/amazon-quadrant-queries
 * http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
 * http://ronzii.wordpress.com/2011/07/08/segment-tree-tutorial/
 */
public class QuadrantQueriesTree {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int numberOfPoints = sc.nextInt();
		SegmentTree tree = new SegmentTree(numberOfPoints);

		int q = sc.nextInt();
		for (; q > 0; q--) {
			String t = String.valueOf(sc.next().charAt(0));
			QueryType type = QueryType.C;
			if (t.equals("X"))
				type = QueryType.X;
			else if (t.equals("Y"))
				type = QueryType.Y;

			int start = sc.nextInt();
			int end = sc.nextInt();
			switch (type) {
			case C:
				int[] result = tree.query(0, 0, numberOfPoints - 1, QueryType.NONE, start - 1, end - 1);
				System.out.println(Arrays.toString(result));
				break;

			default:
				tree.update(0, 0, numberOfPoints - 1, type, start - 1, end - 1);
			}
		}
	}

	static class SegmentTree {

		public Segment[] segments;

		public SegmentTree(int numberOfPoints) {

			int treeSize = (int) (2 * Math.pow(2, Math.ceil(Math.log(numberOfPoints)))) - 1;
			segments = new Segment[treeSize];
			build(0, 0, numberOfPoints - 1);
		}

		public int[] query(int index, int start, int end, QueryType qt, int queryStart, int queryEnd) {

			int[] result = new int[4];
			if (start > end || start > queryEnd || end < queryStart) {
				return result;
			}

			if (start >= queryStart && end <= queryEnd) {

				Segment s = segments[index];
				Segment cs = s.clone();
				cs.swap(qt);
				return cs.pointsCount;
			}

			Segment sg = segments[index];
			qt = Segment.QUERY_TRANSFORM[sg.qt.getIndex()][qt.getIndex()];
			int mid = (start + end) / 2;
			int[] leftResult = query(2 * index + 1, start, mid, qt, queryStart, queryEnd);
			int[] rightResult = query(2 * index + 2, mid + 1, end, qt, queryStart, queryEnd);

			for (int i = 0; i < 4; i++) {
				result[i] = leftResult[i] + rightResult[i];
			}

			return result;
		}

		public void update(int index, int start, int end, QueryType qt, int updateStart, int updateEnd) {

			if (start > end || start > updateEnd || end < updateStart) {
				return;
			}

			if (start >= updateStart && end <= updateEnd) {

				Segment s = segments[index];
				s.swap(qt);
				s.qt = Segment.QUERY_TRANSFORM[s.qt.getIndex()][qt.getIndex()];
				return;
			}

			int mid = (start + end) / 2;
			update(2 * index + 1, start, mid, qt, updateStart, updateEnd);
			update(2 * index + 2, mid + 1, end, qt, updateStart, updateEnd);

			Segment sg = segments[index];
			Segment leftChild = segments[2 * index + 1];
			Segment rightChild = segments[2 * index + 2];
			for (int i = 0; i < 4; i++) {
				sg.pointsCount[i] = leftChild.pointsCount[i] + rightChild.pointsCount[i];
			}

			sg.swap(sg.qt);
		}

		private void build(int index, int start, int end) {

			Segment sg = new Segment();

			if (start == end) {
				Quadrant q = findQuadrant(sc.nextInt(), sc.nextInt());
				sg.pointsCount[q.getNumber()] = 1;
				segments[index] = sg;
				return;
			}

			int mid = (start + end) / 2;
			build(2 * index + 1, start, mid);
			build(2 * index + 2, mid + 1, end);

			Segment leftChild = segments[2 * index + 1];
			Segment rightChild = segments[2 * index + 2];
			for (int i = 0; i < 4; i++) {
				sg.pointsCount[i] = leftChild.pointsCount[i] + rightChild.pointsCount[i];
			}
			segments[index] = sg;
		}

		private Quadrant findQuadrant(int x, int y) {

			if (x > 0 && y > 0)
				return Quadrant.FIRST;
			if (x < 0 && y < 0)
				return Quadrant.THIRD;
			if (x > 0)
				return Quadrant.FORTH;

			return Quadrant.SECOND;
		}
	}

	enum Quadrant {

		FIRST(0), SECOND(1), THIRD(2), FORTH(3);

		private Quadrant(int number) {

			this.number = number;
		}

		private int number;

		public int getNumber() {
			return number;
		}
	}

	enum QueryType {

		X(0), Y(1), XY(2), NONE(3), C(4);

		private int index;

		private QueryType(int index) {

			this.index = index;
		}

		public int getIndex() {

			return index;
		}
	}

	static class Segment implements Cloneable {

		public int[] pointsCount = new int[4];

		public QueryType qt = QueryType.NONE;
		public static final QueryType[][] QUERY_TRANSFORM = new QueryType[4][4];

		
		public Segment clone() {
			
			Segment clone = new Segment();
			clone.pointsCount = new int[4];  
			for (int i = 0; i < 4; i++) {
				clone.pointsCount[i] = this.pointsCount[i];
			}
			
			return clone;
		}

		public void swap(QueryType qt) {

			switch (qt) {
			case X:
				swap(Quadrant.SECOND.number, Quadrant.THIRD.number);
				swap(Quadrant.FIRST.number, Quadrant.FORTH.number);
				break;
			case Y:
				swap(Quadrant.FIRST.number, Quadrant.SECOND.number);
				swap(Quadrant.THIRD.number, Quadrant.FORTH.number);
				break;
			case XY:
				swap(Quadrant.FIRST.number, Quadrant.THIRD.number);
				swap(Quadrant.SECOND.number, Quadrant.FORTH.number);
				break;
			}
		}

		private void swap(int quadrant1, int quadrant2) {

			int temp = pointsCount[quadrant1];
			pointsCount[quadrant1] = pointsCount[quadrant2];
			pointsCount[quadrant2] = temp;
		}

		static {
			for (QueryType qt1 : QueryType.values()) {
				for (QueryType qt2 : QueryType.values()) {
					switch (qt1) {
					case X:
						switch (qt2) {
						case X:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.NONE;
							break;
						case Y:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.XY;
							break;
						case NONE:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.X;
							break;
						case XY:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.Y;
							break;
						}
						break;
					case Y:
						switch (qt2) {
						case X:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.XY;
							break;
						case Y:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.NONE;
							break;
						case NONE:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.Y;
							break;
						case XY:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.X;
							break;
						}
						break;
					case XY:
						switch (qt2) {
						case X:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.Y;
							break;
						case Y:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.X;
							break;
						case NONE:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.XY;
							break;
						case XY:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.NONE;
							break;
						}
						break;
					case NONE:
						switch (qt2) {
						case X:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.X;
							break;
						case Y:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.Y;
							break;
						case NONE:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.NONE;
							break;
						case XY:
							QUERY_TRANSFORM[qt1.getIndex()][qt2.getIndex()] = QueryType.XY;
							break;
						}
						break;
					}
				}
			}
		}
	}
}
