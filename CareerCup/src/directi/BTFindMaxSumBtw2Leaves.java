package directi;

public class BTFindMaxSumBtw2Leaves {

	/*
	 * int maxSumOfLeafpaths(node* root, int * maxSum){
    if (root==NULL)
        return -1;
    if (root->right==NULL && root->left ==NULL)
        return root->data; 
    int leftSum =  maxSumOfLeafpaths(root->left, maxSum);
    int rightSum =  maxSumOfLeafpaths(root->right, maxSum);
    int maxSumAtCurrLevel =  MAX(leftSum,rightSum)+ root->data;
    if (leftSum+rightSum+ root->data > *maxSum){
        *maxSum =  leftSum+rightSum+ root->data;
    }
    return maxSumAtCurrLevel;
}
	 */

}
