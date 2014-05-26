package godaddy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*
 * http://matematyka.pisz.pl/strona/1013.html
 * 
 * http://www.careercup.com/question?id=15647663
 * 
 * if we fill first 4 locations with any of 7 numbers {0,1,2,5,6,8,9}. 
 * Rest of the 4 locations in a valid number will be filled by(in corrosponding digit) {0,1,2,5,9,8,6}. 
 * Hence, total number of valid 8 digits numbers 7^4/10^8.
 */
public class NumbersUpsideDown {

    public static void main(String[] args) {
        Queue<Integer> nums = new LinkedList<Integer>();
        Set<Integer> result = new TreeSet<Integer>();
        nums.offer(37);
        int bitCount = Integer.bitCount(37);
        while (!nums.isEmpty()) {
            int factor = 2;
            int num = nums.poll();
            System.out.println("** Num: " + num);
            while (factor < num) {
                int c = num - factor;
                if (Integer.bitCount(c) == bitCount) {
                    System.out.println("****Trans: " + c);
                    if (!result.contains(c)) {
                        result.add(c);
                        nums.offer(c);
                    }
                }
                factor *= 2;
            }
        }
        result.add(37);
        for (Integer i : result) {
            System.out.println(i + " - " + Integer.toBinaryString(i));
        }
        System.out.println(result);
    }
}
