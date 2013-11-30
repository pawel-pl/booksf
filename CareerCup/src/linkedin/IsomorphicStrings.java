package linkedin;

/*
 * Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic 
if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all 
occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters 
may map to the same letter, but a letter may map to itself. 

Example: 
given "foo", "app"; returns true 
we can map 'f' -> 'a' and 'o' -> 'p' 
given "bar", "foo"; returns false 
we can't map both 'a' and 'r' to 'o' 

given "turtle", "tletur"; returns true 
we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r' 

given "ab", "ca"; returns true 
we can map 'a' -> 'c', 'b'

Hash <char, char> for each string. with first mapping if the mapping exists and the new one is different then false

E.g. Foo and app both encode to 011 
Abcd and hole both encode to 0123 

Hate and hell do not match 
As encodings are 0123 and 0122
 */
public class IsomorphicStrings {

}
