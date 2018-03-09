import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Player object
 * 
 * @author Christian Wang 
 * @version 1.0
 */
public class Player extends Characters
{
    private HashMap<String, SpriteSheet> sprites;

    private int walkCount = 0;
    private int idleCount = 0;
    private int hurtCount = 0;
    private int deadCount = 0;
    private final double MAX_VELOCITY = 10;

    ItemBar itemBar; 
    HealthBar hpBar;

    Weapon currentWeapon;

    /**
     * Override the entity class
     * Loads all the sprites for the player
     */
    public void create() {
        sprites = new HashMap<String, SpriteSheet>();
        sprites.put("walkSprites", new SpriteSheet("images/player/player_walk.png", 24, 24, 6, 5));
        sprites.put("hurtSprites", new SpriteSheet("images/player/player_hurt.png", 24, 24, 2, 5));
        sprites.put("deadSprites", new SpriteSheet("images/player/player_dead.png", 24, 24, 4, 5));
        sprites.put("idleSprites", new SpriteSheet("images/player/player_idle.png", 24, 24, 4, 5));

        setImage(sprites.get("idleSprites").spriteSheet.get(0));

    }

    public void init() {
        inventory.add(new Weapon(4, null, EquipState.RIGHT));
        inventory.add(new Weapon(14, null, EquipState.RIGHT));
        inventory.add(new Weapon(6, null, EquipState.RIGHT));
        itemBar = new ItemBar(this);
        getWorld().addObject(itemBar, -75, 300);

        hpBar = new HealthBar(this);
        getWorld().addObject(hpBar, 150, 50);

        getWorld().setPaintOrder(Crosshair.class, ItemBar.class, HealthBar.class, AmmoBar.class, Weapon.class, Player.class, Enemy.class, Bullet.class);
    }

    /**
     * Test method for dev features
     */
    private void test() {
        if(Greenfoot.isKeyDown("h")) {
            stateX = State.HURT;
        }

        if(Greenfoot.isKeyDown("o")) {
            stateX = State.DEAD;
        }

    }

    /**
     * Method called every refresh cycle
     */
    public void update() {
        if(Greenfoot.isKeyDown("a")) {
            stateX = State.LEFT;
            lastStateX = stateX;
            if(velocityX > -MAX_VELOCITY) velocityX-=2;
        }else if(Greenfoot.isKeyDown("d")) {
            stateX = State.RIGHT;
            lastStateX = stateX;
            if(velocityX < MAX_VELOCITY)velocityX+=2;
        }else stateX = State.IDLE;

        if(Greenfoot.isKeyDown("w")) {
            stateY = State.UP;
            lastStateY = stateY;
            if(velocityY > -MAX_VELOCITY) velocityY-=2;
        }else if(Greenfoot.isKeyDown("s")){
            stateY = State.DOWN;
            lastStateY = stateY;
            if(velocityY < MAX_VELOCITY) velocityY+=2;
        } else {
            stateY = State.IDLE;
        }
        
        test();
        friction();
        setLocation(getX()+velocityX, getY() + velocityY);
    }
    
    public void bulletCollision() {
        //Super laggy   
        //Bullet obj = (Bullet) getOneVisualizingObject(Bullet.class);
        Bullet obj = (Bullet) getOneIntersectingObject(Bullet.class);
        if(obj != null && obj.ID != "friendly"){
            stateX = State.HURT;
            this.healthPoints-= obj.damage;
            hpBar.updateHP();
            getWorld().removeObject(obj);
        }
    }

    /**
     * Slows down the player automatically if there is
     * no forward motion
     */
    public void friction() {
        switch (stateX) {
            case IDLE:
            switch(lastStateX) {
                case LEFT:
                if(velocityX > 0)velocityX-=1;
                if(velocityX < 0)velocityX+=1;
                break;
                case RIGHT:
                if(velocityX > 0)velocityX-=1;
                if(velocityX < 0)velocityX+=1;
                break;
            }
        }
        switch (stateY) {
            case IDLE:
            switch(lastStateY) {
                case UP:
                if(velocityY < 0)velocityY+=1;
                break;
                case DOWN: 
                if(velocityY > 0)velocityY-=1;
                break;
            }
        }
    }

    /**
     * Updates the animation based on the current player's state
     */
    public void render() {
        bulletCollision();
        if(stateX == State.HURT) {
            if(hurtCount >= sprites.get("hurtSprites").spriteSheet.size()) {
                hurtCount=0;
            }
            switch(lastStateX) {
                case LEFT: 
                GreenfootImage tempHurt = new GreenfootImage(sprites.get("hurtSprites").spriteSheet.get(hurtCount));
                tempHurt.mirrorHorizontally();
                setImage(tempHurt);
                break;
                case RIGHT:
                setImage(sprites.get("hurtSprites").spriteSheet.get(hurtCount));

                break;
            }
            hurtCount++;
        } else if(stateX == State.DEAD) {
            if(deadCount >= sprites.get("deadSprites").spriteSheet.size()) {
                deadCount=0;
            }
            switch(lastStateX) {
                case LEFT: 
                GreenfootImage tempDead = new GreenfootImage(sprites.get("deadSprites").spriteSheet.get(deadCount));
                tempDead.mirrorHorizontally();
                setImage(tempDead);
                break;
                case RIGHT:
                setImage(sprites.get("deadSprites").spriteSheet.get(deadCount));
                break;
            }
            deadCount++;
        }else {
            if(idleCount >= sprites.get("idleSprites").spriteSheet.size()) {
                idleCount=0;
            }
            if(walkCount >= sprites.get("walkSprites").spriteSheet.size()) {
                walkCount=0;
            }

            switch(stateX) {
                case LEFT:
                GreenfootImage tempWalk = new GreenfootImage(sprites.get("walkSprites").spriteSheet.get(walkCount));
                tempWalk.mirrorHorizontally();
                setImage(tempWalk);
                //getWorld().setPaintOrder(Crosshair.class, Weapon.class, Player.class, Enemy.class, Bullet.class);
                //temp.flipLeft();
                break;
                case RIGHT:
                setImage(sprites.get("walkSprites").spriteSheet.get(walkCount));
                //getWorld().setPaintOrder(Crosshair.class, Player.class, Enemy.class, Weapon.class,  Bullet.class);

                break;
                case IDLE: 
                switch(stateY) {
                    case UP: 
                    switch(lastStateX) {
                        case LEFT: 
                        GreenfootImage tempWal = new GreenfootImage(sprites.get("walkSprites").spriteSheet.get(walkCount));
                        tempWal.mirrorHorizontally();
                        setImage(tempWal);
                        //getWorld().setPaintOrder(Crosshair.class, Weapon.class, Player.class, Enemy.class, Bullet.class);
                        break;
                        case RIGHT: 
                        setImage(sprites.get("walkSprites").spriteSheet.get(walkCount));
                        //getWorld().setPaintOrder(Crosshair.class, Player.class, Enemy.class, Weapon.class, Bullet.class);
                        break;
                    }
                    break;
                    case DOWN: 
                    switch(lastStateX) {
                        case LEFT: 
                        GreenfootImage tempWa = new GreenfootImage(sprites.get("walkSprites").spriteSheet.get(walkCount));
                        tempWa.mirrorHorizontally();
                        setImage(tempWa);
                        //getWorld().setPaintOrder(Crosshair.class, Weapon.class, Player.class, Enemy.class, Bullet.class);
                        break;
                        case RIGHT: 
                        setImage(sprites.get("walkSprites").spriteSheet.get(walkCount));
                        //getWorld().setPaintOrder(Crosshair.class, Player.class, Enemy.class, Weapon.class, Bullet.class);
                        break;
                    }
                    break;
                    case IDLE:
                    switch(lastStateX) {
                        case LEFT: 
                        GreenfootImage tempIdle = new GreenfootImage(sprites.get("idleSprites").spriteSheet.get(idleCount));
                        tempIdle.mirrorHorizontally();
                        setImage(tempIdle);
                        //getWorld().setPaintOrder(Crosshair.class, Weapon.class, Player.class, Enemy.class, Bullet.class);
                        break;
                        case RIGHT: 
                        setImage(sprites.get("idleSprites").spriteSheet.get(idleCount));
                        //getWorld().setPaintOrder(Crosshair.class, Player.class, Enemy.class, Weapon.class, Bullet.class);
                        break;
                    }
                    break;
                }

                break;
            }

            walkCount++;
            idleCount++;
        }
    }
}