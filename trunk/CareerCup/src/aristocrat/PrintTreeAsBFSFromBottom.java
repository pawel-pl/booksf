package aristocrat;

import common.helper.BinaryTreeNode;

/*
 * http://www.careercup.com/question?id=14584842
 * 
 *        1
       /    \
      2     3
     /  \    /   \
  4    5 6    7
  
  Output: 4567231
  
  1) BFS 1234567 
  2) right first - 1327654
  3) Add on stack while dequeue
 */
public class PrintTreeAsBFSFromBottom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BinaryTreeNode node1 = new BinaryTreeNode(null, null, 10);
		BinaryTreeNode node2 = new BinaryTreeNode(null, null, 11);
		BinaryTreeNode node3 = new BinaryTreeNode(null, null, 12);
		BinaryTreeNode node4 = new BinaryTreeNode(null, null, 13);
		BinaryTreeNode node5 = new BinaryTreeNode(null, null, 14);
		BinaryTreeNode node6 = new BinaryTreeNode(null, null, 15);
		BinaryTreeNode node7 = new BinaryTreeNode(null, null, 16);
		BinaryTreeNode node8 = new BinaryTreeNode(null, null, 17);

		BinaryTreeNode l2rightright = new BinaryTreeNode(node1, node2, 8);
		BinaryTreeNode l2rightleft = new BinaryTreeNode(node3, node4, 7);
		BinaryTreeNode l2leftright = new BinaryTreeNode(node5, node6, 6);
		BinaryTreeNode l2leftleft = new BinaryTreeNode(node7, node8, 5);

		BinaryTreeNode l1right = new BinaryTreeNode(l2rightleft, l2rightright, 4);
		BinaryTreeNode l1left = new BinaryTreeNode(l2leftleft, l2leftright, 3);

		BinaryTreeNode root = new BinaryTreeNode(l1left, l1right, 2);

		BinaryTreeNode.printTree(root);

	}

}
