import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class LawnMower extends Actor {
    private boolean activated;
    private int speed = 8;  // Adjust speed as needed
    private GreenfootImage idleImage;

    public LawnMower() {
        activated = false;
        // Use the animated GIF asset for the lawnmower.
        idleImage = new GreenfootImage("lawn_mover.gif");
        setImage(idleImage);
    }

    public void act() {
        if (!activated) {
            List<Zombie> zombies = getWorld().getObjects(Zombie.class);
            // Check if any zombie in the same row is close enough to trigger activation.
            for (Zombie z : zombies) {
                if (Math.abs(z.getY() - getY()) < getImage().getHeight() / 2 && z.getX() < getX() + 100) {
                    activate();
                    break;
                }
            }
        }

        if (activated) {
            setLocation(getX() + speed, getY());

            // Remove all zombies the lawnmower touches.
            Actor zombie = getOneIntersectingObject(Zombie.class);
            while (zombie != null) {
                getWorld().removeObject(zombie);
                zombie = getOneIntersectingObject(Zombie.class);
            }

            // Remove itself if it has exited the stage.
            if (getX() >= getWorld().getWidth()) {
                getWorld().removeObject(this);
            }
        }
    }


    private void activate() {
        activated = true;
    }
}