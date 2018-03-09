import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Entity object
 * 
 * @author Christian Wang 
 * @version 1.0
 */
public abstract class Entity extends Actor
{   
    Timer animationFrames = new Timer();

    Timer updateFrames = new Timer();
    
    Timer controlFrames = new Timer();

    int initC = 0;

    //Default locks at 60 fps
    public int ANIMATION_FRAMELOCK = 60;

    public int UPDATE_FRAMELOCK = 10;
    
    public int CONTROL_FRAMELOCK = 100;

    public Entity() {
        create();
    }

    /**
     * What the object does when it is created
     */
    public void create() {

    }

    /**
     * What the object does when it is destroyed
     */
    public void dispose() {

    }

    /**
     * Render loop called once every loop 
     * Used for graphical changes
     */
    public void render() {

    }

    /**
     * Update called once every loop
     * Use for general purpose
     */
    public void update() {

    }

    /**
     * Intialization method called once when the object enters the world
     */
    public void init() {
        animationFrames.mark();
    }
    
    public void fixedUpdate() {
        
    }
    
    public void control() {
        
    }
    
    public final Actor getOneVisualizingObject(Class clss){
        ArrayList<Actor>cactor = new ArrayList<Actor>(super.getIntersectingObjects(clss));
        for(Actor c : cactor){
            for(int y = getY()-getImage().getHeight()/2; y < getY()+getImage().getHeight()/2; y++){
                for(int x = getX()-getImage().getWidth()/2; x < getX()+getImage().getWidth()/2; x++){
                    for(int cy = c.getY()-c.getImage().getHeight()/2; cy < c.getY()+c.getImage().getHeight()/2; cy++){
                        for(int cx = c.getX()-c.getImage().getWidth()/2; cx < c.getX()+c.getImage().getWidth()/2; cx++){
                            if(x==cx && y==cy){
                                GreenfootImage a = new GreenfootImage(getImage()), 
                                b = new GreenfootImage(c.getImage());
                                a.rotate(getRotation());
                                b.rotate(c.getRotation());
                                int
                                ix = x-(getX()-getImage().getWidth()/2),
                                iy = y-(getY()-getImage().getHeight()/2),
                                icx = cx-(c.getX()-c.getImage().getWidth()/2),
                                icy = cy-(c.getY()-c.getImage().getHeight()/2);
                                if(a.getColorAt(ix,iy).getAlpha()>50 &&
                                b.getColorAt(icx, icy).getAlpha()>50)
                                    return c;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Act - do whatever the Entity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        fixedUpdate();
        if(initC == 0) {
            init();
        }
        initC++;
        if(updateFrames.millisElapsed() > UPDATE_FRAMELOCK) {
            update();
            updateFrames.mark();
        } 
        if(animationFrames.millisElapsed() > ANIMATION_FRAMELOCK) {
            render(); 
            animationFrames.mark();
        }
        if(controlFrames.millisElapsed() > CONTROL_FRAMELOCK) {
            control();
            controlFrames.mark();
        }
    }    
}
