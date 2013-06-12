package yahoo;

/*
 * http://www.careercup.com/question?id=14218842
 * 
 * Are we allowed to move balls between the jars?
 * Let P(1) is probability of choosing jar 1,
 * P(2) is probability of choosing jar 2,
 * X is the probability of choosing a red ball in jar1.
 * Y is the probability of choosing a red ball in jar2.
 * Total probability= P(1)*X + P(2)*Y
 * Where P(1)=P(2)=1/2
 * What is the maximum number of balls a jar can have??
 * If its 100, move 49 red balls from jar1 to jar2.
 * Now, jar 1 contains 1 red ball & jar 2 contains 50 blue balls & 49 red balls.
 * Total probability of drawing a red ball is 1/2 + 0.5*49/99= 74/99=74.74%
 * 
 * 
 * Nope, dc360. They want to know your approach. Its a test of how simply you can understand a given problem with only that much info. 
 * The approach is - pick up 1 ball from each jars. If you do this, the chances that you have a red ball is 100%. 100% is greater than 50%. 
 */
public class BlindfoldedJars {

}
