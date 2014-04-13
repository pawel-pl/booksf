package amazon;

/*
 * http://www.careercup.com/question?id=20038664
 * http://www.careercup.com/question?id=4785236420329472#comment4785236420329472
 * http://www.careercup.com/question?id=6345092675665920
 * http://www.careercup.com/question?id=6588887669407744
 * http://www.careercup.com/question?id=5955807912919040
 */
public class TreeDepth {

    int counter = -1;
    public static void main(String[] args) {
	
	//String s = "PPPLLLPLL";
	String s = "PLL";
	System.out.println(new TreeDepth().findDepth(s.toCharArray()));
    }
    
    public int findDepth(char[] tree) {
	
	counter++;
	if(tree[counter] == 'L') {
	    return 0;
	}
	int ld = findDepth(tree);
	int rd = findDepth(tree);
	
	return 1 + Math.max(ld, rd);
    }
}
