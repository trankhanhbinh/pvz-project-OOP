import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class IdleCone extends IdleZombie
{
    /**
     * Act - do whatever the Basic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idle;
    public IdleCone() {
        idle = importSprites("coneheadidle", 4);
    }
    public void act()
    {
        animate(idle, 200, true);
        // Add your action code here.
    }
}
