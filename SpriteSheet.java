import java.awt.image.*;
import java.util.*;
import greenfoot.*;
/**
 * Spritesheet loader
 * 
 * @author Christian 
 * @version 1.0
 */
public class SpriteSheet  
{
    int spriteWidth;
    int spriteHeight;
    int numberOfSprites;
    int scaleFactor;
    
    GreenfootImage spriteSheetImage;
    
    ArrayList<GreenfootImage> spriteSheet = new ArrayList<GreenfootImage>();
    
    /**
     * Constructor for objects of class SpriteSheet
     */
    public SpriteSheet(String fileName, int spriteWidth, int spriteHeight, int numberOfSprites, int scaleFactor)
    {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.numberOfSprites = numberOfSprites;
        this.scaleFactor = scaleFactor;
        
        spriteSheetImage = new GreenfootImage(fileName);
        create();
    }

    private GreenfootImage crop(int startX, int startY) {
        GreenfootImage cropped = new GreenfootImage(spriteWidth, spriteHeight);
        cropped.drawImage(spriteSheetImage, startX, startY);
        
        cropped.scale(spriteWidth * scaleFactor, spriteWidth * scaleFactor);
        return cropped;
    }
    
    private void create() {
        for(int i = 0; i < numberOfSprites; i++) {
            spriteSheet.add(crop(i*spriteWidth*-1, 0));
        }
    }
    
}