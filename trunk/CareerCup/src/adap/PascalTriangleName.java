package adap;

public class PascalTriangleName {

    /**
     * @param args
     */
    public static void main(String[] args) {

	String name = "WhatALongName";
	int start = 0, count = 0, end = 0;

	System.out.println(name.charAt(0));

	while (end < name.length()) {
	    count++;
	    start += count;
	    end += (count + 1);

	    for (int i = start; i <= end; i++) {
		if (i < name.length()) {
		    System.out.print(name.charAt(i));
		} else {
		    System.out.print("-");
		}
	    }

	    System.out.println();
	}

    }

}
