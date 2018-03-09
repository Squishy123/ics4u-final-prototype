import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Weapon objects
 * 
 * @author Christian Wang
 * @version 1.0
 */
public class Weapon extends Equip
{   
    SpriteSheet lib; //= new SpriteSheet("images/player/player_weapon.png", 23, 23, 19, 5);
    ArrayList<WeaponInfo> weaponData; //= new ArrayList<WeaponInfo>();

    AmmoBar a;

    WeaponInfo currentWeapon;
    GreenfootImage weaponImage;

    GreenfootImage leftImage;

    Timer coolDown = new Timer();

    public int ammoCount;

    GreenfootImage base;
    /**
     * Creates a weapon with all the preloaded settings
     * based on the given ID
     */
    public Weapon(int ID, Actor currentActor, EquipState state) {
        super(currentActor, state);
        this.ID = ID;
        create();
    }

    public void create() {
        lib = new SpriteSheet("images/player/player_weapons.png", 22, 23, 19, 3);
        HashMap<String, WeaponInfo> weaponsInfo = new HashMap<String, WeaponInfo>();
        weaponData = new ArrayList<WeaponInfo>();
        //weaponData.add(new WeaponInfo(0, "Assault Rifle", 3, 100, 30, 100));
        //weaponData.add(new WeaponInfo(1, "Golden Assault\n Rifle", 3, 100, 30, 100));
        //weaponData.add(new WeaponInfo(2, "Pistol", 3, 100, 10, 150));
        //weaponData.add(new WeaponInfo(3, "Golden Pistol", 3, 100, 10, 150));
        //weaponData.add(new WeaponInfo(4, "Revolver", 3, 100, 6, 175));
        //weaponData.add(new WeaponInfo(5, "Assault Slugger", 3, 100, 24, 150));
        //weaponData.add(new WeaponInfo(6, "Machine Gun", 3, 100, 100, 50));
        //weaponData.add(new WeaponInfo(7, "Toxin Releaser", 3, 100, 10, 200));
        //weaponData.add(new WeaponInfo(8, "Tommy Submachine \nGun", 3, 100, 24, 150));
        //weaponData.add(new WeaponInfo(9, "Hunting Rifle", 3, 100, 2, 500));
        //weaponData.add(new WeaponInfo(10, "Plasma Cannon", 3, 100, 100, 1000));
        //weaponData.add(new WeaponInfo(11, "Submachine Gun", 3, 100, 15, 50));
        //weaponData.add(new WeaponInfo(12, "Golden \nSubmachine Gun", 3, 100, 15, 50));
        //weaponData.add(new WeaponInfo(13, "Laser Gun", 3, 100, 20, 1000));
        //weaponData.add(new WeaponInfo(14, "Uzi", 3, 100, 25, 10));
        //weaponData.add(new WeaponInfo(15, "Potato Gun", 3, 100, 20, 100));
        //weaponData.add(new WeaponInfo(16, "Ancient \nPotato Gun", 3, 100, 20, 1000));
        //weaponData.add(new WeaponInfo(17, "Rusted Pistol", 3, 100, 10, 200));
        //weaponData.add(new WeaponInfo(18, "Flare Gun", 3, 100, 10, 400));

        weaponData.add(new WeaponInfo(0, "Assault Rifle", 30, 100, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(1, "Golden Assault\n Rifle", 30, 100, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(2, "Pistol", 10, 15, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(3, "Golden Pistol", 10, 150, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(4, "Revolver", 6, 175, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(5, "Assault Slugger", 24, 150, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(6, "Machine Gun", 100, 50, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(7, "Toxin Releaser", 10, 200, new Bullet(20, 100, "dart.png")));
        weaponData.add(new WeaponInfo(8, "Tommy Submachine \nGun", 24, 150, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(9, "Hunting Rifle", 2, 500, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(10, "Plasma Cannon", 100, 1000, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(11, "Submachine Gun", 15, 50, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(12, "Golden \nSubmachine Gun", 15, 50, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(13, "Laser Gun", 20, 1000, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(14, "Uzi", 25, 10, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(15, "Potato Gun", 20, 100, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(16, "Ancient \nPotato Gun", 20, 1000, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(17, "Rusted Pistol", 10, 200, new Bullet(20, 100, new Color(152,244,66))));
        weaponData.add(new WeaponInfo(18, "Flare Gun", 10, 400, new Bullet(20, 100, new Color(152,244,66))));

        currentWeapon = weaponData.get(ID);
        if(currentState == EquipState.LEFT) {
            leftImage = new GreenfootImage(lib.spriteSheet.get(currentWeapon.ID));
            leftImage.mirrorVertically();
        }
        image = lib.spriteSheet.get(currentWeapon.ID);
        setImage(lib.spriteSheet.get(currentWeapon.ID));
        name = currentWeapon.name;
        ammoCount = currentWeapon.MAX_AMMO;
    }

    public void init() {
        //Remove all initial ammo bars
        getWorld().removeObjects(getWorld().getObjects(AmmoBar.class));
        a = new AmmoBar(this);
        getWorld().addObject(a, 75, 550);
    }

    public void update() {
        if(currentActor != null) {
            //if(ammoCount == 0) getWorld().removeObject(this);
            if(Greenfoot.isKeyDown("r")) {
                ammoCount = currentWeapon.MAX_AMMO;
                a.updateAmmo();
            }
            direction();
            shoot();
            if(currentState == EquipState.RIGHT)setLocation(currentActor.getX()+30, currentActor.getY()+20);
            else if(currentState == EquipState.LEFT) setLocation(currentActor.getX()-30, currentActor.getY()+20);
        }

        if(Greenfoot.getMouseInfo() != null) {
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        }else {
            turn(1);
        }
    }

    public void fixedUpdate() {
        if(currentActor != null) {
            shoot();
        }
    }

    public void direction() {
        switch(currentState) {
            case RIGHT:
            if(Greenfoot.getMouseInfo() != null) {
                if(Greenfoot.getMouseInfo().getX() > currentActor.getX() + 50) {
                    setImage(lib.spriteSheet.get(currentWeapon.ID));
                    //setLocation(currentActor.getX()+40, currentActor.getY()+20);
                } else if(Greenfoot.getMouseInfo().getX() < currentActor.getX() - 50) {
                    GreenfootImage temp = new GreenfootImage(lib.spriteSheet.get(currentWeapon.ID));
                    temp.mirrorVertically();
                    setImage(temp);
                    //setLocation(currentActor.getX()+20, currentActor.getY()+20);
                } 
            }
            break;
            case LEFT:
            if(Greenfoot.getMouseInfo() != null) {
                if(Greenfoot.getMouseInfo().getX() > currentActor.getX() + 50) {
                    GreenfootImage temp = new GreenfootImage(leftImage);
                    temp.mirrorVertically();
                    setImage(temp);
                    //setLocation(currentActor.getX()-20, currentActor.getY()+20);
                } else if(Greenfoot.getMouseInfo().getX() < currentActor.getX() - 50) {
                    setImage(leftImage);
                    //setLocation(currentActor.getX()-40, currentActor.getY()+20);
                } 
            }
        }
    }

    public void shoot() {
        if(Greenfoot.getMouseInfo() != null) {
            if(currentState == EquipState.LEFT) {
                if(Greenfoot.getMouseInfo().getButton() == 1 && coolDown.millisElapsed() > currentWeapon.COOLDOWN  && ammoCount > 0) {
                    ammoCount--;
                    a.updateAmmo();
                    Bullet temp = new Bullet(currentWeapon.typeOfAmmo,Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
                    if(temp.x < getX()) {
                        GreenfootImage flipped = temp.getImage();
                        flipped.mirrorHorizontally();
                        temp.image = new GreenfootImage(flipped);
                        temp.setImage(flipped);
                    }
                    getWorld().addObject(temp,(int) (getX() + 0.5), (int) (getY() + 0.5));
                    coolDown.mark();
                }

            } else {

                //Revised to use left button as trigger
                if(Greenfoot.getMouseInfo().getButton() == 1 && coolDown.millisElapsed() > currentWeapon.COOLDOWN && ammoCount > 0) {
                    ammoCount--;
                    a.updateAmmo();
                    Bullet temp = new Bullet(currentWeapon.typeOfAmmo,Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
                    if(temp.x < getX()) {
                        GreenfootImage flipped = temp.getImage();
                        flipped.mirrorHorizontally();
                        temp.image = new GreenfootImage(flipped);
                        temp.setImage(flipped);
                    }
                    getWorld().addObject(temp,(int) (getX() + 0.5), (int) (getY() + 0.5));
                    coolDown.mark();
                }

            }
        }
    }
}
