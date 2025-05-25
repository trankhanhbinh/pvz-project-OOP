import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World {
    // Private instance variable to track the mouse hitbox.
    public Hitbox hitbox;
    
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
    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }
}
