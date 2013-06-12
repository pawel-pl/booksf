package vmware;


/*
 * http://rosettacode.org/wiki/Levenshtein_distance#Java
 * 
 * @ not finished
 */
public class DiffFunction {


    private static int minimum(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(CharSequence str1,
                    CharSequence str2) {
    	
            int[][] distance = new int[str1.length() + 1][str2.length() + 1];

            for (int i = 0; i <= str1.length(); i++)
                    distance[i][0] = i;
            for (int j = 0; j <= str2.length(); j++)
                    distance[0][j] = j;
            
           for (int i = 0; i<distance.length; i++) {
        	   for(int j=0; j<distance[0].length; j++){
        		   System.out.print(distance[i][j]+" ");
        	   }
        	   System.out.println();
           }

            for (int i = 1; i <= str1.length(); i++)
                    for (int j = 1; j <= str2.length(); j++)
                            distance[i][j] = minimum(
                                            distance[i - 1][j] + 1,
                                            distance[i][j - 1] + 1,
                                            distance[i - 1][j - 1]
                                                            + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
                                                                            : 1));

            System.out.println();
            for (int i = 0; i<distance.length; i++) {
         	   for(int j=0; j<distance[0].length; j++){
         		   System.out.print(distance[i][j]+" ");
         	   }
         	   System.out.println();
            }
            
            return distance[str1.length()][str2.length()];
    }
    
    public static void main(String[] args) {
		
    	System.out.println(computeLevenshteinDistance("kitten", "sitting"));
    	//System.out.println(computeLevenshteinDistance("rosettacode", "raisethysword"));
    	//System.out.println(computeLevenshteinDistance(new StringBuilder("rosettacode").reverse().toString(), new StringBuilder("raisethysword").reverse().toString()));
	}
}
