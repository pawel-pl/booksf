package facebook;

/*
 * Does the following solve the problem in O(n log n)? 

 Sort the rectangles by the x-coordinate of the lower-left corner and remove those with this corner to the right of the point. 

 Sort the (remaining) rectangles by the x-coordinate of the upper-right corner and remove those with this corner to the left of the point. 

 Sort the (remaining) rectangles by the y-coordinate of the lower-left corner and remove those with this corner above the point. 

 Finally, sort the remaining rectangles by the y-coordinate of the upper-right corner and remove those with this corner below the point. 

 If there is nothing left, then no rectangle contains the point. Otherwise, the one left is as desired.
 */
public class FindRectContainingAPoint {

}
