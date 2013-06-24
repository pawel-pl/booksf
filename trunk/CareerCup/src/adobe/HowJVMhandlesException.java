package adobe;

/*
 * From "Inside the Java 2 VM" Chapter 17 by Bill Venners: 
 * If this situation (i.e., exception) occurs, the JVM knows to jump to the bytecode sequence that implements
 * the catch clause by looking up and finding the exception in a table. Each method that catches exceptions is
 * associated with an exception table that is delivered in the class file along with the bytecode sequence of the method.
 * The exception table has one entry for each exception that is caught by each try block.
 */
public class HowJVMhandlesException {

}
