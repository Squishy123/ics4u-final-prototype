import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Equippable items
 * 
 * @author Christian Wang 
 * @version 1.0
 */
public abstract class Equip extends Items
{
    public EquipState currentState;
    public Actor currentActor;
    
    public boolean crosshairUsable;
    
    
    public Equip(Actor currentActor, EquipState currentState) {
        super(currentState);
        this.currentActor = currentActor;
        this.currentState = currentState;
    }
    
    
}
