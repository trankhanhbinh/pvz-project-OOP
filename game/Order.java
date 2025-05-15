import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Order here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class Order extends Actor {
    private long lastFrame;
    private long delayTime;
    private WaveManager level;

    public Order(WaveManager level, long delayTime) {
        this.level = level;
        this.delayTime = delayTime;
        this.lastFrame = System.nanoTime();
    }

    @Override
    public void act() {
        long currentFrame = System.nanoTime();
        long deltaTime = (currentFrame - lastFrame) / 1_000_000; //to miliseconds

        if (deltaTime > delayTime) {
            level.Order(); //check
            getWorld().removeObject(this);
        }
    }
}