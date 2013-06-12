package tata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class AnagramInaLine {

	public static String sortString(String s) {

		char cs[] = s.toLowerCase().toCharArray();
		Arrays.sort(cs);
		return new String(cs);
	}

	public static void main(String st[]) {
		String para = "Parts of the world have sunlight for close to 24 hours during summer. Dan went to the north pole to lead an expedition during summer. He had a strap on his head to identify himself as the leader. Dan had to deal with the sun never going down for 42 consecutive days and his leadership strap soon became a blindfold. He wondered what kind of traps lay ahead of him";
		Set<String> l = null;
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();

		StringTokenizer t = new StringTokenizer(para);
		while (t.hasMoreElements()) {
			String stg = (String) t.nextElement();
			String modS = sortString(stg);

			if (map.containsKey(modS)) {
				l = map.get(modS);
				l.add(stg);
			} else {
				Set<String> l1 = new java.util.HashSet<String>();
				l1.add(stg);
				map.put(modS, l1);
			}

		}
		for (String s : map.keySet()) {
			if (map.get(s).size() > 1) {
				for (String ls : map.get(s)) {
					System.out.print(ls + " ");
				}
				System.out.println();

			}
		}
	}
}
