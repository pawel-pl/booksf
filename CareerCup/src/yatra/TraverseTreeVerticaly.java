package yatra;

public class TraverseTreeVerticaly {

	/*
	 * http://www.careercup.com/question?id=14800891
	 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
	 * 
	 * I am assuming that we have to print going from the left lines to the
	 * right lines, and top to bottom on a given line.
	 * 
	 * Each node is on a vertical line and can be assigned a number. The line
	 * corresponding to the root being zero. If a node has the vertical line
	 * number v, then its left child has number v-1, and right child has v+1.
	 * 
	 * So we can do a breadth first search, collecting all nodes with the same
	 * vertical line in a list.
	 * 
	 * Once we are done, we can print the lists, in sorted order of the vertical
	 * number. // preorder trav
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
