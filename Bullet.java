import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Projectiles
 * 
 * @author Christian Wang 
 * @version 1.0
 */
public class Bullet extends DynamicEntity implements Cloneable
{   
    double x;
    double y;

    double xForce;
    double yForce;

    double damage = 5;

    double size;
    Color color;

    int i = 0;

    double speed = 100;
    double acc = 10;

    GreenfootImage image;
    
    String ID = "friendly";
    
    Timer life;
    /**
     * Creates a bullet with a mass of 10 and a target coordinate
     */
    public Bullet(double x, double y) {
        super(250);
        this.x = x;
        this.y = y;
        image = new GreenfootImage(30,25);
        image.setColor(new Color(255,216,0));
        image.fillRect(0,0,30,25);
        image.setColor(new Color(255,195,0));
        image.fillRect(5,5,20,15);
        image.scale(15,10);
        setImage(image);
        
        life = new Timer();
    }

    /**
     * Creates a bullet with a mass of 10 and a target coordinate
     */
    public Bullet(int size, int damage, Color color) {
        super(250);
        this.damage = damage;
        GreenfootImage image = new GreenfootImage(size,size);
        image.setColor(color);
        image.fillRect(0,0,size,size);
        setImage(image);
        
    }

    /**
     * Creates a bullet with a mass of 10 and a target coordinate
     */
    public Bullet(int size, int damage, String path) {
        super(250);
        this.damage = damage;
        GreenfootImage image = new GreenfootImage(path);
        setImage(image);

    }

    public Bullet(Bullet b, double x, double y) {
        this.x = x;
        this.y = y;
        this.size = b.size;
        this.damage = b.damage;

        image = new GreenfootImage(b.getImage());
        image.setTransparency(0);
        //setImage(b.getImage());
        setImage(image);

    }

    protected Actor clone(){
        try {
            return (Actor) super.clone();
        } catch (Exception e) {
        }
        return null;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void init() {
        //velocityX = 0.1;
        //velocityY = 0.1;
        xForce = getX() - x;
        yForce = getY() - y;

        if(Math.abs(xForce) != xForce) {
            velocityX= 20;
        } else {
            velocityX=-20;
        }

        //applyForceX(xForce*2);
        //applyForceY(yForce*2);

        //Math.tan(yForce/xForce);
        setRotation((int)(Math.toDegrees(Math.atan((y-getY())/(x-getX())))+0.5));
        //turnTowards((int) (x + 0.5), (int) (y + 0.5));
        image.setTransparency(255);
        setImage(image);
        
        life = new Timer();
    }

    public void update() {
        if(life.millisElapsed() > 1000) getWorld().removeObject(this);
        speed += acc;
        //velocityX+=xForce;
        //velocityY+=yForce;
        //setLocation(getX() + velocityX, getY() + velocityY);
        move(velocityX);
    }

    public void fixedUpdate() {

    }

}
