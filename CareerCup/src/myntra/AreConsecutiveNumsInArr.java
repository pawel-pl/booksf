package myntra;

/*
 * (1) find max, min in array. 
 (2) if (max - min + 1 != n) return false; 
 (3) else do the following: 
 (a) subtract whole of the array with min value. 
 (b) for (i = 0; i < n; i++) 
 { 
 if(a[a[i]] < 0) 
 { 
 print false; 
 break; 
 } 
 else 
 a[a[i]] *= -1; 
 } 
 if ( i == n ) 
 print true; 
 (c) restore the array i.e make all the elements positive by applying abs operator and then add min to each and every element.
 */
public class AreConsecutiveNumsInArr {

}
