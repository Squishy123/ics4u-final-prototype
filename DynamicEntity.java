import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Moving entities
 * 
 * @author Christian Wang
 * @version 1.0
 */
public class DynamicEntity extends Entity
{   
    double velocityY = 0;
    double velocityX = 0;
    double accelerationY = 0;
    double accelerationX = 0;
    double mass;

    private double exactX;
    private double exactY;

    /**
     * Create a new Dynamic Entity with a mass
     */
    public DynamicEntity(double mass) {
        this.mass = mass;
    }

     /**
     * Create a new Dynamic Entity
     */
    public DynamicEntity() {
    }

    /**
     * Apply a force along the y-axis
     */
    public void applyForceY(double force) {
        accelerationY = force/mass;
        fixedUpdate();
    }

    /**
     * Apply a force along the x-axis
     */
    public void applyForceX(double force) {
        accelerationX = force/mass;
        fixedUpdate();
    }

    /**
     * Physics stuff goes here 
     */
    public void fixedUpdate() {

    }

    /**
     * Move forward by the specified distance.
     * (Overrides the method in Actor).
     */
    @Override
    public void move(int distance)
    {
        move((double)distance);
    }

    /**
     * Move forward by the specified exact distance.
     */
    public void move(double distance)
    {
        double radians = Math.toRadians(getRotation());
        double dx = Math.cos(radians) * distance;
        double dy = Math.sin(radians) * distance;
        setLocation(exactX + dx, exactY + dy);
    }

    /**
     * Set the location using exact coordinates.
     */
    public void setLocation(double x, double y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation((int) (x + 0.5), (int) (y + 0.5));
    }

    /**
     * Set the location using integer coordinates.
     * (Overrides the method in Actor.)
     */
    @Override
    public void setLocation(int x, int y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    /**
     * Return the exact x-coordinate (as a double).
     */
    public double getExactX() 
    {
        return exactX;
    }

    /**
     * Return the exact y-coordinate (as a double).
     */
    public double getExactY() 
    {
        return exactY;
    }
}
