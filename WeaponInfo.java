/**
 * Weapon INFO  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponInfo  
{
    public double MAX_DAMAGE;
    public double MAX_RANGE;
    public int MAX_AMMO;
    public double COOLDOWN;
    int ID;

    public Bullet typeOfAmmo;

    String name;

    public WeaponInfo(int ID, String name, double MAX_DAMAGE, double MAX_RANGE, int MAX_AMMO, double COOLDOWN) {
        this.ID = ID;
        this.name = name;
        this.MAX_DAMAGE = MAX_DAMAGE;
        this.MAX_RANGE = MAX_RANGE;
        this.MAX_AMMO = MAX_AMMO;
        this.COOLDOWN = COOLDOWN;
    }

    public WeaponInfo(int ID, String name, int MAX_AMMO, double COOLDOWN, Bullet typeOfAmmo) {
        this.ID = ID;
        this.name = name;
        this.MAX_DAMAGE = MAX_DAMAGE;
        this.MAX_RANGE = MAX_RANGE;
        this.MAX_AMMO = MAX_AMMO;
        this.COOLDOWN = COOLDOWN;
        this.typeOfAmmo = typeOfAmmo;
    }

}
