package interview;

import java.math.BigInteger;

/*
 * http://www.careercup.com/question?id=6109164921159680
 */
public class CountNumbers {

    public static void main(String[] args) {
        int[] counters = new int[10];
        BigInteger n = new BigInteger("11");
        BigInteger start = new BigInteger("1");
        while (start.compareTo(n) == 0 || start.compareTo(n) == -1) {
            String s = start.toString();
            for (int i = 0; i < s.length(); i++) {
                counters[s.charAt(i) - '0']++;
            }
            start = start.add(BigInteger.ONE);
        }
        int num = 0;
        for(int c : counters) {
            System.out.println("Number: "+(num++)+" - count: "+c);
        }
    }
}
