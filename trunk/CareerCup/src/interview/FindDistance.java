package interview;

public class FindDistance {

    public static void main(String[] args) {

	findDistance("hello how are you", "hello", "you");
	findDistance("hello how are hello you", "hello", "you");
	findDistance("you are hello", "hello", "you");
	findDistance("hello how are hello", "hello", "you");
    }

    public static int findDistance(String s, String word1, String word2) {
	String[] words = s.split(" ");
	int p = -1;
	int dist = s.length();
	for (int i = 0; i < words.length; i++) {
	    if (words[i].equals(word1)) {
		p = i;
	    } else if (words[i].equals(word2)) {
		if (p != -1 && i - p < dist) {
		    dist = i - p;
		}
		p = -1;
	    }
	}
	return dist == s.length() ? -1 : dist;
    }

}
