import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TransparentPeashooter extends TransparentObject
{
    public TransparentPeashooter(boolean bool) {
        if (bool) {
            getImage().setTransparency(125);
        } else {
            getImage().setTransparency(255);
        }
    }
    public void act()
    {
        // Add your action code here.
    }
}
