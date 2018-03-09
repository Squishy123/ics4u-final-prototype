import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * A usable item bar based off of inventory
 * 
 * @author Christian 
 * @version 1.0
 */
public class ItemBar extends Entity
{
    int height = 300; 
    int width = 150;

    Characters c;
    boolean showGUI = true;

    Timer idleTimer = new Timer();

    Crosshair aim;

    Weapon currentItem;

    int scrollNum = 0;
    int oldScroll = 0;
    int size = 0;

    public ItemBar(Characters c) {
        this.c = c;
        reDraw(0);

        ANIMATION_FRAMELOCK = 30;
    }

    public void init() {
        aim = new Crosshair();
        getWorld().addObject(aim, getX(), getY());

        currentItem = new Weapon(c.inventory.get(0).ID, c, c.inventory.get(0).cState);
        if(c.inventory.get(0).cState == EquipState.RIGHT) getWorld().addObject(currentItem, c.getX() + 40, c.getY() + 20);
        else if(c.inventory.get(0).cState == EquipState.LEFT) getWorld().addObject(currentItem, c.getX() - 40, c.getY() + 20);
    }

    public void hideSlide() {
        if(getX() > -75) {
            setLocation(getX() - 5 , getY());
        }
    }

    public void showSlide() {
        if(getX() < 75) {
            setLocation(getX() + 5, getY());
        }
    }

    public void hideFade() {
        if(getImage().getTransparency() > 0) {
            GreenfootImage temp = new GreenfootImage(getImage());
            temp.setTransparency((temp.getTransparency())-5);
            setImage(temp);
        }
    }

    public void showFade() {
        if(getImage().getTransparency() < 255) {
            GreenfootImage temp = new GreenfootImage(getImage());
            temp.setTransparency((temp.getTransparency())+5);
            setImage(temp);
        }
    }

    public void reDraw(int current) {
        GreenfootImage menu = new GreenfootImage(width, height);
        menu.setColor(new Color(193,193,193));
        menu.fillRect(0,0,width,height);
        menu.setTransparency(220);
        for(int i = 0; i < c.inventory.size(); i++) {
            if(i <= 3) {
                if(i == current) {
                    menu.setColor(new Color(90,90,90));
                    menu.fillRect(0,i*100,150,100);
                    GreenfootImage itemTemp = new GreenfootImage(c.inventory.get(i).image);
                    itemTemp.scale(55, 55);
                    menu.drawImage(itemTemp, 25, i * (300/3));
                    menu.setColor(new Color(255,255,255));
                    menu.setFont(new Font("TimesRoman",  30));
                    menu.drawString(String.valueOf(i+1), 5, (i * 100) + 40);
                    menu.setFont(new Font("TimesRoman", 15));
                    menu.drawString(String.valueOf(c.inventory.get(i).name), 5, (i * 100) + 60);
                }else {
                    GreenfootImage itemTemp = new GreenfootImage(c.inventory.get(i).image);
                    itemTemp.scale(55, 55);
                    menu.drawImage(itemTemp, 25, i * (300/3));
                    menu.setColor(new Color(255,255,255));
                    menu.setFont(new Font("TimesRoman", 30));
                    menu.drawString(String.valueOf(i+1), 5, (i * 100) + 40);
                    menu.setFont(new Font("TimesRoman", 15));
                    menu.drawString(String.valueOf(c.inventory.get(i).name), 5, (i * 100) + 60);
                }
            }
        }
        setImage(menu);

    }

    public void control() {
        if(Greenfoot.isKeyDown("1")) {
            getWorld().removeObject(currentItem);
            this.reDraw(0);
            currentItem = new Weapon(c.inventory.get(0).ID, c, c.inventory.get(0).cState);
            if(c.inventory.get(0).cState == EquipState.RIGHT) getWorld().addObject(currentItem, c.getX() + 40, c.getY() + 20);
            else if(c.inventory.get(0).cState == EquipState.LEFT) getWorld().addObject(currentItem, c.getX() - 40, c.getY() + 20);
        }else if(Greenfoot.isKeyDown("2")) {
            getWorld().removeObject(currentItem);
            this.reDraw(1);

            currentItem = new Weapon(c.inventory.get(1).ID, c, c.inventory.get(1).cState);
            if(c.inventory.get(1).cState == EquipState.RIGHT) getWorld().addObject(currentItem, c.getX() + 40, c.getY() + 20);
            else if(c.inventory.get(1).cState == EquipState.LEFT) getWorld().addObject(currentItem, c.getX() - 40, c.getY() + 20);
        }else if(Greenfoot.isKeyDown("3")) {
            getWorld().removeObject(currentItem);
            this.reDraw(2);

            currentItem = new Weapon(c.inventory.get(2).ID, c, c.inventory.get(2).cState);
            if(c.inventory.get(2).cState == EquipState.RIGHT) getWorld().addObject(currentItem, c.getX() + 40, c.getY() + 20);
            else if(c.inventory.get(2).cState == EquipState.LEFT) getWorld().addObject(currentItem, c.getX() - 40, c.getY() + 20);
        }
        if(Greenfoot.isKeyDown("e")) {
            if(this.showGUI){
                showGUI = false;
            }else if (!this.showGUI) 
                showGUI = true;
        }
    }

    public void render() {
        if(this.showGUI) {
            hideSlide();
        }else {
            showSlide();
        }
    }
}
