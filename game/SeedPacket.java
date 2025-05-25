import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeedPacket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SeedPacket extends Actor {
    public long deltaTime;
    public long deltaTime2;
    public long lastFrame = System.nanoTime();
    public long lastFrame2 = System.nanoTime();
    public long rechargeTime;
    public long currentFrame = System.nanoTime();
    public int sunCost;
    public boolean recharged = false;
    public boolean selected = false;
    public boolean doneRechargeTime = false;
    public GreenfootImage recharge;
    public GreenfootImage image1;
    public GreenfootImage image2;
    public String name;
    public MyWorld myWorld;

    public SeedPacket(long rechargeTime, boolean recharged, int sunCost, String name){
        this.rechargeTime = rechargeTime;
        this.recharged = recharged;
        this.sunCost = sunCost;
        this.name = name;
        this.image1 = new GreenfootImage(name + "1.png");     
        this.image2 = new GreenfootImage(name + "2.png");
    }
    
    //create or start, I forgot what I called this similar method in the previous class I made
    @Override
    public void addedToWorld(World world){
        setRecharged(recharged);
        doneRechargeTime = recharged;
        setImage(recharged ? image1 : image2);
        
        myWorld = (MyWorld) getWorld();
        recharge = new GreenfootImage(getImage().getWidth(), getImage().getHeight());
    }

    // check if the valid condition (Sun and Time cooldown) is met
    @Override
    public void act() {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame)/1000000;
        deltaTime2 = (currentFrame - lastFrame2)/1000000;

        handleRechargeProgress();

        if (myWorld.seedbank.SunCounter.sun >= sunCost){
            setRecharged(deltaTime > rechargeTime);
        } else {
            setRecharged(false);
        }
    }

    //animation+timing
    public void handleRechargeProgress() {
        if (deltaTime < rechargeTime && !doneRechargeTime) {
            if (!recharged && deltaTime2 > 500L) {
                setImage(name + "2.png");

                recharge.clear();
                recharge.setColor(Color.BLACK);
                
                int height = getImage().getHeight() - (int)Math.round(getImage().getHeight() * ((double) deltaTime/rechargeTime));
                recharge.setTransparency(110);
                recharge.fillRect(0, 0, getImage().getWidth(), height);

                getImage().drawImage(recharge, 0, 0);
                lastFrame2 = System.nanoTime();
            }
        } else if (!recharged && !doneRechargeTime) {
            doneRechargeTime = true;
            setImage(image2);
        }
    }

    //start recharge
    public void startRecharge(){
        lastFrame = currentFrame;
        doneRechargeTime = false;
    }

    public void setRecharged(boolean charge){
        if (recharged != charge){
            recharged = charge;
            setImage(recharged ? image1 : image2);
        }
    }
    //It's 11pm rn I need to sleep
    public void setSelected(boolean selected){
        this.selected = selected;
        setImage(selected ? image2 : image1);
    }

    public boolean getCharge(){
        return recharged;
    }

    public boolean getSelected(){
        return selected;
    }

    public TransparentObject addImage(){
        return null;
    }

    public Plant getPlant(){
        return null;
    }
}
