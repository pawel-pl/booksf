package adobe;

public class JavaQuest {

	/*
	 * how can we measure size of a object in java?
	 * 
	 * 
	 * static Runtime runtime = Runtime.getRuntime(); ... long start, end;
	 * Object obj; runtime.gc(); start = runtime.freememory(); obj = new
	 * Object(); // Or whatever you want to look at end = runtime.freememory();
	 * System.out.println("That took " + (start-end) + " bytes.");
	 * 
	 * 
	 * By default, Hashtable is unordered. Then, how can you retrieve Hashtable elements in the same order as they are put inside???
	 * 
	 * This is Analogous to Java's LinkedHashMap. 
	 * Just create a LinkedList structure and attach new nodes (elements) 
	 * as they are added, it's going to be in added order.
	 */
}
