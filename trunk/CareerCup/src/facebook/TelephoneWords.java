package facebook;

import java.util.HashMap;
import java.util.Map;

public class TelephoneWords {

    public static void main(String[] args) {

	Map<Character, char[]> map = new HashMap<Character, char[]>();
	map.put('f', new char[] { 'F', '4' });
	map.put('b', new char[] { 'B', '8' });
	String s = "fab";
	printStrings(s.toCharArray(), new StringBuilder(), map, 0);
    }

    public static void printStrings(char[] s, StringBuilder sb, Map<Character, char[]> map, int pos) {

	if (sb.length() == s.length) {
	    System.out.println(sb);
	    return;
	}
	char[] subs = map.get(s[pos]);
	sb.append(s[pos]);
	printStrings(s, sb, map, pos + 1);
	sb.setLength(sb.length() - 1);
	if (subs != null) {
	    for (int i = 0; i < subs.length; i++) {
		sb.append(subs[i]);
		printStrings(s, sb, map, pos + 1);
		sb.setLength(sb.length() - 1);
	    }
	}
    }
}
