package nvidia;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * eg {4,5,34,33,32,11,10,31} 
 * ans is {31,32,33,34} 
 */
public class ConsequitiveNoInArr {

	public static void main(String[] args) {
		//int[] arr = { 4, 5, 34, 33, 32, 11, 10, 31 };
		int[] arr = { 4, 36, 5, 33, 32, 34, 11, 10, 31, 35 };
		//int[] arr = { 1, 7, 12, 3, 9, 18, 4, 25, -6, 2 };
		findSubArr(arr);
		findSubArrHash(arr);
	}

	public static void findSubArr(int[] arr) {
		boolean[] visited = new boolean[arr.length];
		Set<Integer> longestSeq = new TreeSet<Integer>();
		Set<Integer> currentSeq = new TreeSet<Integer>();
		currentSeq.add(arr[0]);
		visited[0] = true;
		int max = arr[0];
		int min = arr[0];
		int i = 0;
		int j = 1;
		int skipAt = -1;
		boolean changed = false;
		while (i < arr.length) {
			while (j < arr.length) {
				if (visited[j]) {
					j++;
					continue;
				}
				if (arr[j] == max + 1) {
					max = arr[j];
					currentSeq.add(arr[j]);
					visited[j] = true;
					changed = true;
				} else if (arr[j] == min - 1) {
					min = arr[j];
					currentSeq.add(arr[j]);
					visited[j] = true;
					changed = true;
				} else if (skipAt == -1) {
					skipAt = j;
				}
				j++;
			}
			//skip element and new min/max was found (recheck)
			if (skipAt != -1 && changed) {
				j = skipAt;
			//old seq is finished, start a new seq from the first unvisited element	
			} else {
				if (currentSeq.size() > longestSeq.size()) {
					longestSeq.clear();
					longestSeq.addAll(currentSeq);
				}
				while (i < visited.length && visited[i]) {
					i++;
				}
				if (i == visited.length) {
					break;
				}
				max = arr[i];
				min = arr[i];
				visited[i] = true;
				j = i + 1;
				currentSeq.clear();
				currentSeq.add(arr[i]);
			}
			changed = false;
			skipAt = -1;
		}
		System.out.println(longestSeq);		
	}
	
	public static void findSubArrHash(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(i, arr[i]);
		}
		boolean[] visited = new boolean[arr.length];
		Set<Integer> longestSeq = new TreeSet<Integer>();
		Set<Integer> currentSeq = new TreeSet<Integer>();
		currentSeq.add(arr[0]);
		int max = arr[0];
		int min = arr[0];
		visited[0] = true;
		int j = 1;
		while (j < arr.length) {
			if (map.values().contains(max + 1)) {
				Integer index = getIndexForValue(map, visited, max + 1);
				if (index != null) {
					max = max + 1;
					currentSeq.add(max);
					visited[index] = true;
					j++;
				}
			} else if (map.values().contains(min - 1)) {
				Integer index = getIndexForValue(map, visited, min - 1);
				if (index != null) {
					min = min - 1;
					currentSeq.add(min);
					visited[index] = true;
					j++;
				}
			} else {
				if (currentSeq.size() > longestSeq.size()) {
					longestSeq.clear();
					longestSeq.addAll(currentSeq);
				}
				currentSeq.clear();
				for (int i = 0; i < visited.length; i++) {
					if (!visited[i]) {
						currentSeq.add(arr[i]);
						max = arr[i];
						min = arr[i];
						visited[i] = true;
						j++;
						break;
					}
				}
			}
		}
		System.out.println(longestSeq);
	}

	private static Integer getIndexForValue(Map<Integer, Integer> map, boolean[] visited, Integer value) {
		Integer index = null;
		for (Integer key : map.keySet()) {
			Integer v = map.get(key);
			if (v.equals(value) && !visited[key]) {
				index = key;
				break;
			}
		}
		return index;
	}
}
