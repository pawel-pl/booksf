package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindWordsInSegment {

    public static void main(String[] args) {

        String s = "this part of text that includes words and list but not list of words and if you need a list which contains many more words you should try a longer list of terms or list of words";
        String[] dict = { "list", "of", "words" };
        findSegment(s.split(" "), dict);
    }

    public static void findSegment(String[] text, String[] dict) {
        Map<String, Integer> wordToIndexMap = new HashMap<String, Integer>();
        Queue<Integer> positions = new PriorityQueue<Integer>();
        int missingWords = dict.length;
        int minDist = Integer.MAX_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < dict.length; i++) {
            wordToIndexMap.put(dict[i], null);
        }
        for (int i = 0; i < text.length; i++) {
            if (!wordToIndexMap.containsKey(text[i])) {
                continue;
            }
            if (missingWords > 0 && wordToIndexMap.get(text[i]) == null) {
                missingWords--;
            }
            if (wordToIndexMap.get(text[i]) != null) {
                positions.remove(wordToIndexMap.get(text[i]));
            }
            wordToIndexMap.put(text[i], i);
            positions.add(i);
            if (missingWords == 0 && (i - positions.peek() + 1 < minDist)) {
                minDist = i - positions.peek() + 1;
                startIndex = positions.peek();
                endIndex = i;
            }
        }
        if (missingWords == 0) {
            System.out.println("Segment starts: " + startIndex + ", ends: " + endIndex);
        } else {
            System.out.println("Segment not found");
        }
    }
}
