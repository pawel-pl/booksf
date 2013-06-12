package tribal;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortHashMaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		final Map<Integer, Date> m1 = new HashMap<Integer, Date>();
		m1.put(1, df.parse("11/11/11"));
		m1.put(2, df.parse("11/11/12"));
		m1.put(3, df.parse("11/11/13"));
		
		Map<Integer, Date> m2 = new HashMap<Integer, Date>();
		m2.put(4, df.parse("11/11/14"));
		m2.put(5, df.parse("11/11/15"));
		m2.put(6, df.parse("11/11/16"));

		m1.putAll(m2);
		
		Map<Integer, Date> sortedMap = new TreeMap<Integer, Date>(new Comparator<Integer>() {

			@Override
			public int compare(Integer k1, Integer k2) {
				
				return m1.get(k2).compareTo(m1.get(k1));
			}
			
		});
		
		sortedMap.putAll(m1);
		System.out.println(sortedMap.keySet());
		
		System.out.println(sortedMap);
	}

}
