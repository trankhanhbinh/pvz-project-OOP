import java.util.TimerTask;
import greenfoot.*;

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class Timer extends TimerTask {
    private GreenfootImage[] imageArray;
    private String spriteSheet;
    private int frameIndex1;
    private int frameIndex2;

    public Timer(GreenfootImage[] imageArray, String filename, int frameIndex1, int frameIndex2){
        if (imageArray == null || filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Invalid");
        }

        this.imageArray = imageArray;
        this.spriteSheet = filename;
        this.frameIndex1 = frameIndex1;
        this.frameIndex2 = frameIndex2;
    }

    @Override
    public void run(){
        if (frameIndex1 >= 0 && frameIndex1 < imageArray.length) {
            imageArray[frameIndex1] = new GreenfootImage(spriteSheet + (frameIndex1 + 1) + ".png");
        }

        if (frameIndex2 >= 0 && frameIndex2 < imageArray.length) {
            imageArray[frameIndex2] = new GreenfootImage(spriteSheet + (frameIndex2 + 1) + ".png");
        }
    }
}
