import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends animatedObjects
{
    /**
     * Act - do whatever the Buttons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage idle;
    public GreenfootImage hover;
    public Buttons(String idle, String hover) {
        this.idle = new GreenfootImage(idle);
        this.hover = new GreenfootImage(hover);
        setImage(idle);
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        GameOver world = (GameOver)getWorld();
        if (mouse != null) {
            world.moveHitbox();
            if (this.intersects(world.hitbox)) {
                setImage(hover);
            } else {
                setImage(idle);
            }
            if (Greenfoot.mouseClicked(this)) {
                Audio.play(100, "gravebutton.mp3");
                update(); 
            }
        }
        
      
    }
    public void update() {
        
    }
}
