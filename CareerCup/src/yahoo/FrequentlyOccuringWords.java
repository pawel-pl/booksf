package yahoo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequentlyOccuringWords {

	public static void main(String[] args) {

		try {
			File f = new File("c:\\Users\\kaminpaw\\workspace\\CareerCup\\file.txt");
			Scanner sc = new Scanner(f);
			Map<String, Integer> m = new HashMap<String, Integer>();
			while (sc.hasNext()) {
				String next = sc.next();
				if (m.containsKey(next)) {
					m.put(next, m.get(next) + 1);
				} else {
					m.put(next, 1);
				}
			}

			sort(m);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void sort(Map<String, Integer> m) {
		
		List<Integer> values = new ArrayList<Integer>(m.values());
		List<String> keys = new ArrayList<String>(m.keySet());
		
		System.out.println(m);
		System.out.println(keys);
		System.out.println(values);
	}

}
