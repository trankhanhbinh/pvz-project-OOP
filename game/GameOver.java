import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World {
    // Private instance variable to track the mouse hitbox.
    private Hitbox hitbox;
    
    /**
     * Constructor for GameOver screen.
     * @param restart The world to restart when the player chooses to retry.
     */
    public GameOver(World restart) {
        super(763, 448, 1, false);
        hitbox = new Hitbox();
        addObject(hitbox, 0, 0);
        Greenfoot.setSpeed(50);
        addObject(new Retry(restart), 380, 405);
    }
    public void act() {
        moveHitbox(); 
    }
    private void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }
}
