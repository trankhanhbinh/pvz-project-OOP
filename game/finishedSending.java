import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class finishedSending here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class finishedSending extends Actor
{
    private long startTime;
    private long delayTime;
    private WaveManager level;

    public finishedSending(WaveManager level, long delayTime) {
        this.level = level;
        this.delayTime = delayTime;
        startTime = System.currentTimeMillis(); // Capture the start time
    }

    public void act() {
        long elapsedTime = System.currentTimeMillis() - startTime; // Measure elapsed time

        if (elapsedTime >= delayTime) {
            level.FinishedSending = true; // Mark completion
            getWorld().removeObject(this); // Remove itself
        }
    }

}
