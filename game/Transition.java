import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends Actor
{
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private World targetWorld;
    private boolean fadeOut;
    private int fadeSpeed;
    private int a = 0;
    private int counter = 0;
    private int waitDuration = 0;

    public Transition(boolean fadeOut, World targetWorld, int fadeSpeed) {
        this.fadeOut = fadeOut;
        this.targetWorld = targetWorld;
        this.fadeSpeed = fadeSpeed;
        getImage().setTransparency(0);
    }

    public Transition(boolean fadeOut, World targetWorld, int fadeSpeed, int waitDuration) {
        this(fadeOut, targetWorld, fadeSpeed);
        this.waitDuration = waitDuration;
    }

    public Transition(boolean fadeOut, World targetWorld, String imageFile, int fadeSpeed) {
        this.fadeOut = fadeOut;
        this.targetWorld = targetWorld;
        this.fadeSpeed = fadeSpeed;
        setImage(new GreenfootImage(imageFile));
        getImage().setTransparency(0);
    }

    public void act() {
        a += fadeSpeed;
        if (a <= 255) {
            getImage().setTransparency(a);
        } else {
            getImage().setTransparency(255);
            counter++;
            if (counter > waitDuration) {
                if (fadeOut) {
                    getWorld().addObject(new EndTransition(), 300, 224);
                }
                changeWorld();
                return;
            }
        }
    }

    private void changeWorld() { 
        getWorld().removeObject(this);
        Greenfoot.setWorld(targetWorld);
    }

    public void addedToWorld(World world) {
        
    }
}


