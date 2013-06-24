package adobe;

import java.util.HashSet;
import java.util.Set;

public class ContiguousSubString {

    public static void main(String[] args) {

	//String s = "BAACCB";
	String s = "AABC";
	//String s = "ABC";
	Set<Character> uniqueChars = new HashSet<Character>();
	int counter = 0;
	for (int i = 0; i < s.length(); i++) {
	    uniqueChars.clear();
	    uniqueChars.add(s.charAt(i));
	    counter++;
	    System.out.println(s.charAt(i));
	    for (int j = i + 1; j < s.length(); j++) {
		if(!uniqueChars.contains(s.charAt(j))) {
		    uniqueChars.add(s.charAt(j));
		    if(uniqueChars.size() == 3) {
			break;
		    }
		}
		counter++;
		System.out.println(s.substring(i,j+1));
	    }
	}
	System.out.println("Total: "+counter);
    }
}
