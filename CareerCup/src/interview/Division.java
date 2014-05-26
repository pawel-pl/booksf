package interview;

public class Division {

    public int quotient(int a, int b) {
        int q = 1;

        while (q * b < a)
            q *= 2;

        return binSearch(q >> 1, q, a, b);
    }
    
    public int binSearch(int start, int end, int a, int b) {
        int mid = (start + end) >> 1;
        if (start == mid || mid == end)
            return mid;

        if (mid * b == a)
            return mid;
        else if (mid * b < a)
            return binSearch(mid, end, a, b);
        else
            return binSearch(start, mid, a, b);
    }
    
    public void divide(int a, int b) {
        int quotient = quotient(a, b);
        System.out.println("Quotient: " + quotient);

        int k = 5;
        int d[] = new int[k];
        int remainder = a - quotient * b;
        for (int index = 0; index < 5; index++) {
            remainder *= 10;
            d[index] = quotient(remainder, b);
            remainder -= d[index] * b;
        }

        System.out.print("Digits: ");
        for (int digit : d)
            System.out.print(digit);
    }

    public static void main(String[] args) {
        Division d = new Division();
        //d.divide(1023, 19);
        d.divide(20, 6);
    }
}
