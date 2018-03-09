import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends DynamicEntity
{   
    SpriteSheet idleSprites;
    private int idleCount = 0;
    Timer t = new Timer();

    public Enemy() {
        super(100);
    }

    public void create() {
        idleSprites = new SpriteSheet("images/enemy/enemy_idle.png", 67, 62, 26, 1);

    }

    public void see() {
        ArrayList<Actor> range = new ArrayList<Actor>(getObjectsInRange(500, Player.class));

        if(range.size() > 0 && t.millisElapsed() > 250) {
            Bullet temp = new Bullet(range.get(0).getX(),(range.get(0).getY()));
            temp.ID = "enemy";
            //getWorld().addObject(new Bullet((range.get(0)).getX(), (range.get(0)).getY()),(int) (getX() + 0.5), (int) (getY() + 0.5));
            getWorld().addObject(temp, (int) (getX() + 0.5), (int) (getY() + 0.5));
            t.mark();
        }
    }

    public void update() {
        see();
    }

    public void render() {
        if(idleCount >= idleSprites.spriteSheet.size()) {
            idleCount = 0;
        }
        setImage(idleSprites.spriteSheet.get(idleCount));
        idleCount++;

    }
}