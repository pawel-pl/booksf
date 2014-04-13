package interview;

public class FindFactors {

    public static void main(String[] args) {
        System.out.println(findFactors(24));
    }

    public static String findFactors(int number) {
        String result = "";
        int factor = 9;
        while (factor > 1 && number > 1) {
            while (number % factor == 0) {
                number /= factor;
                result = factor + result;
            }
            factor--;
        }
        return result;
    }
}
