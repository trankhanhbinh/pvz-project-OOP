import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


class FixOrder extends Actor {
    private long startTime;
    private long delayTime;
    private WaveManager level;

    public FixOrder(WaveManager level, long delayTime) {
        this.level = level;
        this.delayTime = delayTime;
        startTime = System.currentTimeMillis(); // Store initial time
    }

    public void act() {
        long elapsedTime = System.currentTimeMillis() - startTime;

        if (elapsedTime > delayTime) {
            level.fixOrder(); // Execute fixOrder after delay
            getWorld().removeObject(this); // Remove once done
        }
    }
}
