import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class useShovel extends SmoothMover
{
    MyWorld MyWorld;
    Plant lastPlant = null;
    
    public void addedToWorld(World world) {
        MyWorld = (MyWorld)getWorld();
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
            
    
            if (mouse.getX() < SeedBank.x1 || mouse.getX() > SeedBank.x2 || mouse.getY() < SeedBank.y1 || mouse.getY() > SeedBank.y2)  {
                if (lastPlant != null) {
                    lastPlant.opaque = false;
                }
                if (Greenfoot.mouseClicked(null)) {
                    
                    
                    MyWorld.shovel.setSelected(false);
                    MyWorld.removeObject(this);
                    return;
                }
            } else {
                  int x = (int)((mouse.getX()-SeedBank.x1)/SeedBank.xSpacing);
                int y = (int)((mouse.getY()-SeedBank.y1)/SeedBank.ySpacing);
                Plant current = MyWorld.grid.getPlant(x, y);
                if (current != null) {

                    if (lastPlant != null && lastPlant != current) {
                        lastPlant.opaque = false;
                        lastPlant = current;
                    } else {
                        lastPlant = current;
                        lastPlant.opaque = true;
                    }
                    
                } else {
                    if (lastPlant != null) {
                        lastPlant.opaque = false;
                    }
                }
                
                
                
                if (Greenfoot.mouseClicked(null)) {
                    
                    if (current != null) {
                        
                        MyWorld.grid.removePlant(current.getXPos(), current.getYPos());
                        
                    } else {
                        Audio.play(80, "tap.mp3", "tap2.mp3");
                        
                    }
                    MyWorld.shovel.setSelected(false);
                    MyWorld.removeObject(this);
                    return;
                }
            }
        }
    }
}
