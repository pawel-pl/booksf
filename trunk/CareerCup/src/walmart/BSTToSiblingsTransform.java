package walmart;

/*
 * Left-child right-sibling binary tree
 */
public class BSTToSiblingsTransform {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

/*
 * BST * siblingsTransform(BST *root) {
	if(root == NULL) {
		return NULL;
	}
	siblingsTransform(root->left);
	siblingsTransform(root->right);
	if (root->left !=NULL) {
		root->left ->right = root->right;
		root->right = NULL;
	}
	else {
		root->left = root->right;
	}
	return root;
	}
 */
}
