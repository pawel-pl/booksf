package nationalinstruments;

/*
 * there are five persons and each one of them hit a stump with a ball twice.
 * Probability of each one hitting it is P then how many people hit the stump in both the chances?
 * 
 * The probability one person hit the stump twice is E(X) = P^2 

 Assume that n people (n= 5) are n independent variables (the result from one does not influence result of the others)
 then the expected number of people who hit both time is 
 E(X1) + E(X2) + .. E(Xn) = n E(X) = n * P^2 

 Quick validation if P = 1, always hit, and all the people hit twice then there are 5 people hit 
 P = 0, always failed, non-of-them hit, then we expect 0 as the result
 */
public class ProbHitStumpTwice {

}
