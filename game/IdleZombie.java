import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IdleZombie extends animatedObjects
{
    /**
     * Act - do whatever the IdleZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
    }
    public void addedToWorld(World world) {
        frame = RNG.Int(1,4);
    }
}