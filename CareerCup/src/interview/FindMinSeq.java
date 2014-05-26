package interview;

public class FindMinSeq {

    public static void main(String[] args) {
        System.out.println(minSeq(new int[] { 1, 2, 3, 4, -10, -2, 22 }, 7, 10));
    }

    public static int minSeq(int ar[], int n, int sum) {
        int sumL = 0;
        for (int i = 0; i < n; i++)
            sumL += ar[i];
        int minSeq = n;
        if (sumL < sum)
            return 0;
        int front = 0, end = n - 1;
        while (sumL > sum) {
            if (ar[front] < ar[end]) {
                front++;
                sumL -= ar[front - 1];
            } else {
                end--;
                sumL -= ar[end + 1];
            }
            minSeq--;
        }
        return ++minSeq;
    }
}
