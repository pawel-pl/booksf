package pocketgems;


public class ConvexSearch {

/*
* minima( x1, x2)
* mid = (x1+x2)/2;M = convex(mid);
* lmid = (x1+mid)/2;L = convex(lmid);
* rmid = (mid+x2)/2; R = convex(rmid);
* If M < R && L
*   then x1 = lmid;x2 = rmid;
* else if M < L && M > R
*   then x1 = lmid;
* else if M < R && M > L
*   then x2 = rmid;
* go to line number 2;
* if (x2-x1) < 1E-10
*   output (x1+x2)/2;
*   break;
*/

}
