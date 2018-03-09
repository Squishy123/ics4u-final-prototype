import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Item class
 * 
 * @author Christian Wang 
 * @version 1.0
 */
public class Items extends Entity
{
    GreenfootImage image;
    String name;
    int ID;

    public EquipState cState;
    
    public Items(EquipState cs) {
        this.cState = cs;
    }
}
