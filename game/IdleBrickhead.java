import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IdleBrickhead extends IdleZombie
{
    /**
     * Act - do whatever the Basic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle;
    public IdleBrickhead() {
        idle = importSprites("brickheadidle", 4);
    }
    public void act()
    {
        animate(idle, 300, true);
        // Add your action code here.
    }
}