package a9;

/*
 * http://www.careercup.com/question?id=5140345926975488
 */
public class Combinations {

    int arr[];

    int sumuptoAi(int m, int n) {
        int sum = 0;
        for (int i = m; i <= n; i++)
            sum = sum * 10 + arr[i];
        return sum;
    }

    public boolean Combinations(int start, int sum) {
        if (sum == 0 && start == arr.length)
            return true;

        for (int i = start; i < arr.length; i++) {
            if (Combinations(i + 1, sum - sumuptoAi(start, i)))
                return true;

        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = { 5, 2, 1, 4, 3, 6, 7, 8 };
        Combinations obj = new Combinations();
        obj.arr = arr;
        System.out.println(obj.Combinations(0, 333));
    }

}
