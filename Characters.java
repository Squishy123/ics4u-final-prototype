import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Characters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Characters extends DynamicEntity
{
    public double healthPoints = 100; 
    
    public State stateX = State.IDLE;;
    public State lastStateX = State.RIGHT;
    public State stateY  = State.IDLE;
    public State lastStateY = State.IDLE;
    
    public ArrayList<Items> inventory = new ArrayList<Items>();
}
