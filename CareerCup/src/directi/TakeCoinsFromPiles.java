package directi;

/*
 * So, we know that the winner of the game is the one who starts the last pile, 
 * therefore optimal plays says they will both want to start a pile. 
 * 
 * How do you start a pile? Ensure there is just one coin left on the previous pile.
 * 
 * Except:
 * 1) there is 1 coin on the last pile
 * 	  N=5 , A[0]=5 , A[1]=4 , A[2]=3 , A[3]=1, A[4]=2 (take k-1 coins if the next coin contains x >=2 coins, otherwise take all)
 * 
 * 2)If there are odd number of continuous piles which contain only 1 coin A[0]=1 , A[1]=1 , A[2]=1 - Bob win
 */
public class TakeCoinsFromPiles {

}
