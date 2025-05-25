import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PotatoPacket extends SeedPacket
{

    public PotatoPacket() {
        super(40000L, false, 25, "potatopacket");
    }
 
    public TransparentObject addImage() {
        TransparentObject temp = new TransparentPotato(false);
        ((MyWorld)getWorld()).addObject(temp, Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        return temp;
    }
    public Plant getPlant() {
        return new PotatoMine();
    }
}

