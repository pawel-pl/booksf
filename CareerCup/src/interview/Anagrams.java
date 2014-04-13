package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {

	findAnagrams(new String[] { "star", "astr", "car", "rac", "st" });
    }

    public static void findAnagrams(String[] arr) {
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	for (String s : arr) {
	    char[] temp = s.toCharArray();
	    Arrays.sort(temp);
	    String sortedString = new String(temp);
	    List<String> anagrams = null;
	    if (map.containsKey(sortedString)) {
		anagrams = map.get(sortedString);
	    } else {
		anagrams = new ArrayList<String>();
		map.put(sortedString, anagrams);
	    }
	    anagrams.add(s);
	}
	for (String key: map.keySet()) {
	    System.out.println(map.get(key));
	}
    }
}
