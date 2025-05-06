import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndTransition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class EndTransition extends Actor {
    private int a = 255;

    /**
     * Constructor: Initializes the EndTransition actor by setting its image transparency to fully opaque.
     */
    public EndTransition() {
        getImage().setTransparency(a);
    }

    /**
     * Act method: Called each act cycle.
     * Reduces the image transparency by 10 units at a time. When fully faded out,
     * it removes the actor from the world.
     */
    public void act() {
        a -= 10; 

        if (a >= 0) {
            getImage().setTransparency(a);
        } else {
            getImage().setTransparency(0);
            getWorld().removeObject(this);
        }
    }
}
