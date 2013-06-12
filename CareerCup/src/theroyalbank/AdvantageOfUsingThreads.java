package theroyalbank;

/*
 * Just take the example of msword . it uses two threads: one for handling rendering and another for managing the UI. 
 * The rendering thread effectively runs hidden in the background for spell check etc while the UI thread receives input, 
 * handles events, and runs application code. 
 * considering the advantages of using threads like they are light weight , 
 * inter thread communication is easy and a thread context switch is cheap , 
 * its better to use multithreaded solution.
 * 
 * One thread can wait for input while the other does background work. Without threads, you would not be fully utilizing the system
 * because no background work would be getting done while you're waiting for input, blocked on disk I/O, etc.
 */
public class AdvantageOfUsingThreads {

}
