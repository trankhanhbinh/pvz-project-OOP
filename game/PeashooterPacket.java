import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PeashooterPacket extends SeedPacket{

    public PeashooterPacket() {
        super(10000L, true, 100, "peashooterpacket");
        
    }
    
    public TransparentObject addImage() {
        TransparentObject temp = new TransparentPeashooter(false);
        ((MyWorld)getWorld()).addObject(temp, Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        return temp;
    }
    public Plant getPlant() {
        return new Peashooter();
    }
}

