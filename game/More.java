import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class More extends Buttons
{
     public boolean clicked = false;
    GreenfootImage[] start;
    public int counter = 0;
    public More() {
        super("more1.png", "more2.png");
        start = importSprites("more", 2);
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        MainMenu world = (MainMenu)getWorld();
        
        if (mouse != null) {
            world.moveHitbox();
            if (this.intersects(world.hitbox)) {
                setImage(hover);
            } else {
                setImage(idle);
            }
            if (Greenfoot.mouseClicked(this)) {
                clicked = true;
                
                AudioPlayer.play(100, "gravebutton.mp3");
                
            }
        }
        
      
    }
    public void update() {
        
    }
}
