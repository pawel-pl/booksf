package bazaarvoice;

import common.helper.TreeNode;

public class FindColorClusterInBT {

    public static int findCluster(TreeNode root) {

	if (root == null) {
	    return 0;
	}
	int leftCount = findCluster(root.getChildren().get(0));
	int rightCount = findCluster(root.getChildren().get(1));
	int result = leftCount + rightCount;
	if (root.getChildren().get(0) != null && root.getChildren().get(0) != null) {// and
										     // colors
										     // the
										     // same
	    result += 1;
	}

	return result;
    }
}
