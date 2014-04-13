package interview;

/*
 * http://www.careercup.com/question?id=5752271719628800
 */
public class FindProductOfThree {

    public static void main(String[] args) {

        int n = 3;
        int[] arr = { 4, 1, -7, -8, 9 };
        findProduct(arr, n);
    }

    public static void findProduct(int[] arr, int n) {
        int product = 1;
        int maxProd = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
            if (i >= n - 1) {
                if (i == n - 1) {
                    maxProd = product;
                    startIndex = 0;
                    endIndex = i;
                } else {
                    product /= arr[i - n];
                    if (product > maxProd) {
                        maxProd = product;
                        startIndex = i - n + 1;
                        endIndex = i;
                    }
                }
            }
        }
        System.out.println("Start index: " + startIndex + ", endIndex: " + endIndex + ", product: " + maxProd);
    }
}
