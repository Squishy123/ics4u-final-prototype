import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends DynamicEntity
{
    double x;
    double y;

    double xForce;
    double yForce;
    
    Timer life = new Timer();

    public Particle(double x, double y) {
        super(1000);
        this.x = x;
        this.y = y;

        GreenfootImage image = new GreenfootImage(5,5);
        image.setColor(new Color(66,244,104));
        image.fillRect(0,0,5,5);
        setImage(image);
    }

    public void init() {

        setRotation((int)(Math.toDegrees(Math.atan((y-getY())/(x-getX())))+0.5));

    }

    public void update() {
        xForce = getX() - x;
        yForce = 
        getY() - y;

        if(Math.abs(xForce) != xForce) {
            ///velocityX=15;
        } else {
            //elocityX=-15;
        }

        applyForceX(xForce*2);

        applyForceY(yForce*2);

        velocityX-=accelerationX;
        velocityY-=accelerationY;
        //velocityX+=xForce;
        //velocityY+=yForce;
        setLocation(getX() + velocityX, getY() + velocityY);
        //move(velocityX);
    }

}
