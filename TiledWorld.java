import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Tiled world class
 * 
 * @author Christian Wang
 * @version 1.0
 */
public class TiledWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public TiledWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1, false); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,306,297);
        setPaintOrder(Crosshair.class, Player.class, Weapon.class, Bullet.class);
        
        for(int i = 0; i < 100; i++) {
            //addObject(new Particle(new Random().nextInt(600),new Random().nextInt(600)), 300, 300);
        }
    
    }
}
