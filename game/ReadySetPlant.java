import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ReadySetPlant extends animatedObjects
{
    /**
     * Act - do whatever the ReadySetPlant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage[] ready;
    public GreenfootImage[] set;
    public GreenfootImage plant;
    public boolean r = true;
    public boolean s = true;
    public boolean p = true;
    public int counter;
    public ReadySetPlant() {
        ready = importSprites("Ready__",11);
        set = importSprites("Set__",12);
        plant = new GreenfootImage("PLANT!.png");
    }
    public void act()
    {
        if (frame <= 11 && counter < 60) {
            if (r) {
                animate(ready, 40, false);
            } else if (s) {
                animate(set, 40, false);
            } else if (p) {
                setImage(plant);
                counter++;
            }
        } else {
            if (r) {
                r = false;
                frame = 0;
            } else if (s) {
                s = false;
                frame = 0;
            } else if (p) {
                p = false;
                getWorld().removeObject(this);
                return;
            }
        }
    }
}
