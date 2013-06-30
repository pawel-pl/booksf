package barclays;

public class RemoveDupsFromString {

    public static void main(String[] args) {

	removeDuplicates();
    }

    public static void removeDuplicates() {

	char[] chArray = { 'a', 'a', 'b', 'c', 'a', 'b', 'd', 'c', 'c', 'd', 'a', 'a' };
	char[] finalArray = new char[12];
	int k = 0;

	System.out.println(chArray);
	for (int i = 0; i < chArray.length; i++) {
	    if (chArray[i] == ' '){
		continue;
	    }
	    char tmpChar = chArray[i];
	    for (int j = i + 1; j < chArray.length; j++) {
		if (chArray[j] == tmpChar) {
		    chArray[j] = ' ';
		}
	    }
	    finalArray[k++] = chArray[i];
	}
	System.out.println(finalArray);
    }
}
