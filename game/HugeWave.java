import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import greenfoot.*;

public class HugeWave extends Actor {
    private long startTime; // Track the starting time
    private boolean finalWave;
    private boolean sirenPlayed = false;

    public HugeWave(boolean finalWave) {
        this.finalWave = finalWave;
        startTime = System.currentTimeMillis(); // Store the time when object is created
    }

    public void act() {
        long elapsedTime = System.currentTimeMillis() - startTime; // Calculate elapsed time

        if (!finalWave) {
            if (elapsedTime > 5000) { // Play siren after 5 seconds instead of relying on frame rate
                AudioPlayer.play(70, "siren.mp3");
                getWorld().removeObject(this); // Remove after sound plays
            }
        } else {
            if (elapsedTime > 5000 && !sirenPlayed) {
                AudioPlayer.play(70, "siren.mp3");
                sirenPlayed = true;
            }

            if (elapsedTime > 7000) { // 2 seconds after siren, show final wave image
                setImage("finalwave.png");
                AudioPlayer.play(70, "finalwave.mp3");
            }

            if (elapsedTime > 10000) { // 3 seconds after final wave message, remove object
                getWorld().removeObject(this);
            }
        }
    }
}
