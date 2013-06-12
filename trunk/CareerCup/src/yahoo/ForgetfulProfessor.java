package yahoo;

/*
 * http://www.careercup.com/question?id=11533722
 * 
 * assuming names are distinct..
 * Say first group is {1,2,3,4,5} now replace one of the students with a new one, new group is {1,2,3,4,6} .. so now he can identify 5 and 6 both, 
 * next replace 4 with say 7 .. 
 * then 3 with 8 .. 
 * then 2 with 9 
 * then 1 with 10
 * next change the group to include 2 unknowns e.g. {1,2,3,11,12} swap 12 with 13 in next 
 * move and he identifies both. And since he knows everyone except 11 .. he now knows 11 too
 * i.e. 
 * k identified
 * 1 0
 * 2 2
 * 3 4
 * 4 6
 * 5 8
 * 6 10
 * 7 12 + 1
 * hence k = 7.
 */
public class ForgetfulProfessor {

}
