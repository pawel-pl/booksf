package nvidia;

/*
 * y bytes and you can transfer only x bytes at once
 * 
 * (y + (x-1)) / x  ex 32 bits in 4 and 5 rounds
 * 
 * Basically you need: ceiling(y / x) iterations, that is: 
 * - you need int(y / x) iterations which copy exactly x bytes 
 * - if remaining bytes != 0 (i.e.: y % x) != 0) then you need another iteration to transfer remaining bytes 

 * The formula rewritten to use only x - / * (drumroll...): 
 * (y + (x-1)) / x 

 * In order to prove correctness you need to check two case sets: 
 * 1. y % x == 0 => addition of x-1 doesn't affect the result, so it is y/x (which is ok) 
 * 2. y % x > 0 => addition of x-1 increments result with 1 (which is ok because we need another copy for the remaining y % x bytes)
 */
public class TransfexYbitsInXPortion {

}
