package globalscholar;

/*
 * step-1 create a max heap out of the array 
 step-2 create a min heap out of the array(only if the array contains -ve nos) 

 step-3 delete three elements(say maxa, maxb, maxc) from the max heap these elements would the 3 largest elements in the array 

 step-4 if the array contains -ve elements then delete TWO elements(say mina, minb) from the min heap. 

 step-5 If the array contains -ve elements then check 
 if((mina *minb) > (maxa*maxb)) 
 then MaxProduct = mina *minb * maxc 

 else 
 MaxProduct = maxa*maxb*maxc 

 Total time would be = O(nlogn) which could be reduce to O(n) if you create using fast heap
 */
public class ProductOf3NoThatIsMax {

}
