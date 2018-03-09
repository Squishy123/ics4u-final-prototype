import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.System.*;
/**
 * Counts the amount of seconds between a starting event
 * and an ending event
 * 
 * @author Christian Wang 
 * @version Sept 2016
 */
public class Timer
{
    public long startTime;
    
    /**
     * Default constructor for timer object
     * Starts the timer 
     */
    public Timer() {
        mark();
    }
    
    /**
     * Starts the timer and sets the starttime value to current time
     */
    public void mark() {
        startTime = System.currentTimeMillis();
    }
    
    /**
     * Returns the amount of seconds that passed
     * Since the starting event
     */
    public int secondsElapsed() {
        return (int) (System.currentTimeMillis()-startTime)/1000;
    }
    
    /**
     * Returns the amount of millisecondss that passed
     * Since the starting event
     */
    public int millisElapsed() {
        return (int) (System.currentTimeMillis()-startTime);
    }
   
}
