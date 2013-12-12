package inmobi;

public class MaximumProductSubarray {

    public static void main(String[] args) {

	// int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
	int arr[] = { -7, -10, -10 };
	int n = arr.length;
	System.out.printf("Maximum Sub array product is %d", maxSubarrayProduct(arr, n));

    }

    /*
     * negative product contains maxProd + one (latest) negative value or is equal 1.
     * If we find sec negative value then maxProd is = negProd * negativeProduct
     * negProd contains one more
     * -2,2,3 - negProd = -223 posProd 23
     * -2.3,4,-2 , -2,3,4,-5 - pos = whole new neg = 3,4,-2 = oldPos * -5
     */
    private static int maxSubarrayProduct(int arr[], int n) {

	int currentMaxProd = 1;
	int currentNegProd = 1;
	int maxProduct = 1;
	for (int i = 0; i < n; i++) {
	    /*
	     * min_ending_here only if min_ending_here is negative
	     */
	    if (arr[i] > 0) {
		currentMaxProd = currentMaxProd * arr[i];
		currentNegProd = Math.min(currentNegProd * arr[i], 1);
	    } else if (arr[i] == 0) {
		currentMaxProd = 1;
		currentNegProd = 1;
	    /*
	     * max_ending_here can either be 1 or positive. min_ending_here can either be 1 or negative.
	     */
	    } else {
		int temp = currentMaxProd;
		currentMaxProd = Math.max(currentNegProd * arr[i], 1);
		currentNegProd = temp * arr[i];
	    }
	    if (maxProduct < currentMaxProd)
		maxProduct = currentMaxProd;
	}

	return maxProduct;
    }
}
