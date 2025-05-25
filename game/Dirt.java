import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Dirt extends animatedObjects
{
    public GreenfootImage[] dirt;

    public Dirt() {
        dirt = importSprites("dirt",4);
    }
    public void act()
    {
        if (frame <= 3) {
            animate(dirt, 50L, false);
        } else {
            getWorld().removeObject(this);
            return;    
        }

    }
}
