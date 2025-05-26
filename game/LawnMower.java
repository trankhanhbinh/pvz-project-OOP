import greenfoot.*;  
import java.util.*;

public class LawnMower extends Actor {
    private boolean activated;
    private int speed = 7;
    private GreenfootImage lawnmowerImage;
    
    public LawnMower() {
        activated = false;
        lawnmowerImage = new GreenfootImage("lawn_mower.gif");
        setImage(lawnmowerImage);
    }
    
    public void act() {
        if (getWorld() == null) {
            return;
        }
        
        if (!activated) {
            List<Zombie> zombies = new ArrayList<>(getWorld().getObjects(Zombie.class));
            for (Zombie z : zombies) {
                if (Math.abs(z.getY() - getY()) < getImage().getHeight() / 4 && z.getX() < getX() + 100) {
                    activate();
                    break;
                }
            }
        } else {
            setLocation(getX() + speed, getY());
            
            int removalTolerance = 20;
            List<Zombie> intersectingZombies = new ArrayList<>(getIntersectingObjects(Zombie.class));
            for (Zombie z : intersectingZombies) {
                try {
                    if (z != null && z.getWorld() != null && Math.abs(z.getY() - getY()) <= removalTolerance) {
                        getWorld().removeObject(z);
                    }
                } catch (IllegalStateException ise) {
                }
            }
            
            if (getX() >= getWorld().getWidth() - 4) {
                getWorld().removeObject(this);
            }
        }
    }
    
    private void activate() {
        activated = true;
    }
}
