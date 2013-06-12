package oracle;

/*
 * You have 8 coins. 3 of them weigh x units, 3 y units, 1 a units and 1 b units. 
 * They are all mixed and look identical. 
 * You have to find the lightest coin in minimum number of weighing .
 */
public class FindTheLightestCoin {

/*
* Assume weights 
* x x x y y y a b 
* possible pairs 
* xx xy yy ab -> xx yy reject as equal, now compare result of ab & xy ->steps=5 
* xa xb xy yy -> reject pair yy, compare result of pair xa & xb then compare it with reult of xy ->step=6 
* xy xy xy ab 6-> reult of xy&xy wil be same so reject pair ->steps=6 
* xa yb yy xx -> same as first-> steps=5 
* xa yb xy xy -> steps=6 
*/
}
