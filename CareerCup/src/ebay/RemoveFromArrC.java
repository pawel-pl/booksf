package ebay;

/*
 * http://www.careercup.com/question?id=15036941
 * 
 * For each index k in C :
        Find index alim in A such that A[alim] <= C[k]
        Find index blim in B such that B[blim] <= C[k]
     
        left = 0
        right = blim

-------while left <= alim and right >= 0 :
            if A[left] + B[right] == C[k] :
                Remove C[k] and break
            else if A[left] + B[right] < C[k] :
                left++
            else :
                right--
 */
public class RemoveFromArrC {

}
