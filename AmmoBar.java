import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class AmmoBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmmoBar extends Entity
{   

    int width = 150;
    int height = 50;
    Weapon w;

    public AmmoBar(Weapon w) {
        this.w = w;
        GreenfootImage menu = new GreenfootImage(width, height);
        menu.setColor(new Color(112,123,153));
        menu.fillRect(0,0,width,height);
        menu.setTransparency(220);

        menu.setColor(new Color(255,255,255));
        menu.setFont(new Font("TimesRoman", 20));
        menu.drawString("Ammo : " + String.valueOf(w.ammoCount), 25, 30);
        setImage(menu);
    }

    public void updateAmmo() {
        GreenfootImage menu = new GreenfootImage(width, height);
        menu.setColor(new Color(112,123,153));
        menu.fillRect(0,0,width,height);
        menu.setTransparency(220);

        menu.setColor(new Color(255,255,255));
        menu.setFont(new Font("TimesRoman", 20));
        menu.drawString("Ammo : " + String.valueOf(w.ammoCount), 25, 30);
        setImage(menu);
    }
}
