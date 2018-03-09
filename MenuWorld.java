import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(new Color(66, 143, 244));
        background.fillRect(0,0,600,600);
        
        setBackground(background);
 
    }
}
