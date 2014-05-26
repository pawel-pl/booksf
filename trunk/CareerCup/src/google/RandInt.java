package google;

// http://www.careercup.com/question?id=6065702117048320

public class RandInt {

    public static void main(String[] args) {

        int N = 10;
        int[] k = { 1, 5, 7 };
        int currentNum = 0;
        int num = 3;// uniform(N - k.length);
        int i = 0;
        boolean print = true;
        while (i < k.length && num > 0) {
            if (currentNum < k[i]) {
                num--;
                if (num == 0) {
                    System.out.println(currentNum);
                    print = false;
                    break;
                }
                currentNum++;
            } else if (currentNum == k[i]) {
                currentNum++;
                i++;
            } else {
                i++;
            }
        }
        if (print)
            System.out.println(currentNum + num);

    }

    public void randomNumber() {

        int N = 10;
        int[] k = { 1, 5, 7 };
        int jumps = 0;
        int i = 0;
        int num = 2;// uniform(N - k.length);
        while (i < k.length && jumps + num >= k[i]) {
            ++jumps;
            ++i;
        }
        System.out.println(jumps + num);
    }

    public int randomNumber(int N, int[] K) { // K is sorted
        int x = 5;// uniform(N - K.length); // 1 .. N - K.length
        int last = 0, i;
        for (i = 0; i < K.length; i++) {
            if (K[i] - last > x)
                return x + last;
            x -= (K[i] - last - 1); // we've seen K[i] - last - 1 valid numbers
            last = K[i];
        }
        return x + K[K.length - 1];
    }
}
