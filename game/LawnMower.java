import greenfoot.*;  
import java.util.*;

public class LawnMower extends Actor {
    private boolean activated;
    private int speed = 8;  // Adjust speed as desired
    private GreenfootImage lawnmowerImage;
    
    /**
     * Constructor for LawnMower.
     * Loads the animated lawnmower GIF.
     */
    public LawnMower() {
        activated = false;
        lawnmowerImage = new GreenfootImage("lawn_mower.gif");
        setImage(lawnmowerImage);
    }
    
    public void act() {
        if (getWorld() == null) // If you’ve been removed, exit immediately.
            return;
        
        if (!activated) {
            // Defensive copy prevents concurrent modification issues.
            List<Zombie> zombies = new ArrayList<>(getWorld().getObjects(Zombie.class));
            for (Zombie z : zombies) {
                // Check if the zombie is on the same row and close enough horizontally.
                if (Math.abs(z.getY() - getY()) < getImage().getHeight() / 2 &&
                    z.getX() < getX() + 100) {
                    activate();
                    break;
                }
            }
        } else {
            // Move the lawnmower to the right.
            setLocation(getX() + speed, getY());
            
            // Get a temporary list of all zombies currently intersecting.
            List<Zombie> intersectingZombies = new ArrayList<>(getIntersectingObjects(Zombie.class));
            for (Zombie z : intersectingZombies) {
                try {
                    // Only remove if the zombie still has a world (i.e. it's still active).
                    if (z != null && z.getWorld() != null) {
                        getWorld().removeObject(z);
                    }
                } catch (IllegalStateException ise) {
                    // Another actor may have already removed z.
                    // You can log this event or simply ignore it.
                }
            }
            
            // Remove the lawnmower if it reaches the right edge.
            if (getX() >= getWorld().getWidth() - 4) {
                getWorld().removeObject(this);
            }
        }
    }
    
    private void activate() {
        activated = true;
        // Optionally change the image or play an activation sound here.
    }
}