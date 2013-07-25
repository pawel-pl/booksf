package flipkart;

/*
 * Consider the board as directed graph. 
 1. k is linked to k + 1 k + 2, k + 3, k + 4, k + 5, k +6 because from k you can reach these nodes in one throw of dice. 
 2. If any of these neighbors of k has a ladder which takes you to j, then j becomes the neighbor instead of the base of the ladder. 
 Lets say k + 3 node takes you to j node, then instead of k + 3, j is the neighbor of k. 
 3. Similarly if any of the neighbors of k has a snake which takes you to l, then l is a neighbor of k. 

 Using these conditions, build the graph. Now this is transformed into a Shortest path between two nodes in a directed graph problem.
 */
public class LaddersGameMinNumOfRolls {

}
