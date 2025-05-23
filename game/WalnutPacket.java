import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WalnutPacket extends SeedPacket
{
    /**
     * Act - do whatever the WalnutPacket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public WalnutPacket() {
        super(40000L, false, 50, "walnutpacket");
    }
 
    public TransparentObject addImage() {
        TransparentObject temp = new TransparentWalnut(false);
        ((MyWorld)getWorld()).addObject(temp, Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        return temp;
    }
    public Plant getPlant() {
        return new Walnut();
    }
}