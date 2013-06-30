package bloomberg;

/*
 * For sorting numbers between 1 and 50,000, the interviewer might have expected you to produce an O(50k)-time solution. 
 * Initialize an array from 1 to 50,000 with zeros. 
 * Iterate through your numbers and update the appropriate buckets. 
 * Then go through the 50k-sized array and emit the numbers in order, using the bucket counts to determine how many values you emit. 
 * I think the interviewer is kind of clever, because the 5:1 ratio of max-value to N
 *  is in the range where a traditional O(NlogN) might actually be faster. 

 * The second question was about finding the best sort for arrays and linked lists. 
 * For arrays, quicksort and heapsort are pretty comparable, because they can both be done in place in O(NlogN) time.
 * For linked lists, you can cheat by copying the linked list into an array in linear time, but linked lists also play really nice with quicksort.
 * Pop the head off the list, and use that as a pivot. 
 * Partition the lows and highs into two new linked lists. 
 * Recursively sort the other linked lists, then chain them back together. 
 */
public class SortArrAndLL {

}
