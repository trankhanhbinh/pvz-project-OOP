import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Buttons extends animatedObjects{
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
