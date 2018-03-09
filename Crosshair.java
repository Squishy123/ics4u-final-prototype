import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
import java.awt.*;
import greenfoot.core.WorldHandler;
/**
 * Mouse control 
 * 
 * @author Christian Wang 
 * @version 1.0
 */
public class Crosshair extends Entity
{   
    GreenfootImage curssor;
    GreenfootImage crosshair;

    State stateX = State.RIGHT;

    Timer t;
    double x;
    double y;
    
    //Dangerous stuff watch out
    //ScrollingListener scroll = new ScrollingListener();
    /**
     * Default Constructor for Cursors
     */
    public Crosshair() {
        //this.x = x;
        //this.y = y;
    }

    /**
     * Initializing images
     */
    public void create() {
        curssor = new GreenfootImage("images/cursor/mouse.png");
        curssor.scale(20,29);
        crosshair = new GreenfootImage("images/cursor/crosshair.png");
        crosshair.scale(60,60);
        setImage(crosshair);
        t = new Timer();

        UPDATE_FRAMELOCK = 0;
    }

    public void setState() {
        if(getX() >= getWorld().getWidth()/2) {
            stateX = State.RIGHT;
        } else if(getX() < getWorld().getWidth()/2) {
            stateX = State.LEFT;
        }
    }

    /**
     * Updates the mouse location and hides the system mouse
     */
    public void update() {
        if(Greenfoot.getMouseInfo() != null) {
            setLocation(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
            
        }

        setState();
        JPanel panel = WorldHandler.getInstance().getWorldCanvas();
        //panel.addMouseWheelListener(scroll);
        GreenfootImage image = new GreenfootImage(1, 1);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image.getAwtImage(), new Point(0, 0), "");
        panel.setCursor(cursor);

    }
}
