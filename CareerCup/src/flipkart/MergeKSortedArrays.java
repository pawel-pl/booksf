package flipkart;

/*
 * Given k sorted lists, with the total of n elements. 
 keep a pointer to each of the list 
 construct a minheap (data and arraynumber) by taking the first element from all the arrays. 
 increment all the pointers by 1 

 extract the minelement and print 
 take the element from the array in which the min element in present, and insert to min heap. 
 increment that pointer. 
 Continue till all the pointers reach end and min heap becomes empty
 
 It is O(NlogK) because there are logK merge operation of the external merge sort. At each you scan N elements.
 */
public class MergeKSortedArrays {

}
