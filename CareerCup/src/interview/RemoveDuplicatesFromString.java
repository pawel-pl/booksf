package interview;

public class RemoveDuplicatesFromString {

    public static void main(String[] args) {

//        System.out.println(removeDups("ABCCBCBA"));
//        System.out.println(removeDups("CCCACCAA"));
        System.out.println(removeDups("AACCABB"));
    }

    public static String removeDups(String s) {
        StringBuilder sb = new StringBuilder(s);
        int numOfSameChars = removeDups(sb, 0);
        if (numOfSameChars != 0) {
            sb.delete(0, numOfSameChars);
        }
        return sb.length() == 0 ? "-1" : sb.toString();
    }

    public static int removeDups(StringBuilder sb, int pos) {
        if (pos == sb.length() - 1) {
            return 0;
        }
        int numOfSameChars = removeDups(sb, pos + 1);
        if (sb.charAt(pos) == sb.charAt(pos + 1)) {
            return numOfSameChars != 0 ? numOfSameChars + 1 : 2;
        } else if (numOfSameChars > 0) {
            sb.delete(pos + 1, pos + 1 + numOfSameChars);
            if (pos != sb.length() - 1 && sb.charAt(pos) == sb.charAt(pos + 1)) {
                return 2;
            }
        }
        return 0;
    }
}
