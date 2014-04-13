package interview;

/*
 * http://www.careercup.com/question?id=5766198755065856
 */
public class MoveLetterToLeft {

    public static void main(String[] args) {
        String s = "a1b2c3d4";
        swapChars(s.toCharArray());
    }

    public static void swapChars(char[] s) {
        int offsetFirstHalf = (s.length / 2) - 1;
        int offsetSecondHalf = (s.length / 4) - 1;
        int swapPos = 1;
        char swapValue = s[swapPos];
        int targetPos = -1;
        while (swapPos != 0) {
            if (swapPos % 2 != 0) {
                if (swapPos < s.length / 2) {
                    targetPos = swapPos + offsetFirstHalf;
                    offsetFirstHalf--;
                } else {
                    targetPos = swapPos + offsetSecondHalf;
                    offsetSecondHalf--;
                }
            } else {
                targetPos = swapPos / 2;
            }
            char temp = s[targetPos];
            s[targetPos] = swapValue;
            swapPos = targetPos;
            swapValue = temp;
        }
    }
}
