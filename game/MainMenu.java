import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MainMenu extends World
{
    Hitbox hitbox = new Hitbox();
    GreenfootSound menutheme = new GreenfootSound("menutheme.mp3");
    public MainMenu(GreenfootSound menutheme)
    {    
        super(576, 430, 1, false); 
        addObject(hitbox,0,0);
        addObject(new Start(), 428, 138);
        addObject(new More(), 414, 233);
        this.menutheme = menutheme;
        Greenfoot.setSpeed(50);
    }
    public void act() {
        if (Greenfoot.isKeyDown("1")) {
            menutheme.stop();
            Greenfoot.setWorld(new Intro());
                    
                
        } else if (Greenfoot.isKeyDown("2")) {
           menutheme.stop();
                
            Greenfoot.setWorld(new IntroLevel1());
                    
        } else if (Greenfoot.isKeyDown("3")) {
            menutheme.stop();
                
            Greenfoot.setWorld(new IntroLevel2());
                    
        } else if (Greenfoot.isKeyDown("4")) {
            menutheme.stop();
                
            Greenfoot.setWorld(new IntroLevel3());
                    
        }
    }
    public void started() {
        if (!menutheme.isPlaying()) {
            menutheme.setVolume(70);
            menutheme.playLoop();
        }
    
    }
    public void stopped() {
        menutheme.pause();
    }

    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }
    
}