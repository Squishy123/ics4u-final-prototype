import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Healthbar
 * 
 * @author Christian Wang 
 * @version 1.0
 */
public class HealthBar extends Entity
{   
    int height = 100;
    int width = 300;
    Characters c;

    public HealthBar(Characters c) {
        this.c = c;
        GreenfootImage menu = new GreenfootImage(width, height);
        menu.setColor(new Color(112,123,153));
        menu.fillRect(0,0,width,height);
        menu.setTransparency(220);

        menu.setColor(new Color(255,255,255));
        menu.setFont(new Font("TimesRoman", 30));
        menu.drawString("Health : " + String.valueOf(c.healthPoints), 50, 60);
        setImage(menu);
    }

    public void updateHP() {
         GreenfootImage menu = new GreenfootImage(width, height);
        menu.setColor(new Color(112,123,153));
        menu.fillRect(0,0,width,height);
        menu.setTransparency(220);

        menu.setColor(new Color(255,255,255));
        menu.setFont(new Font("TimesRoman", 30));
        menu.drawString("Health : " + String.valueOf(c.healthPoints), 50, 60);
        setImage(menu);
    }
}