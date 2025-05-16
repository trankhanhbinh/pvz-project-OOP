import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class WaveManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveManager extends Actor
{
    public void act() {
    if (wave != -1) {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000; // Convert nanoseconds to milliseconds
    } else {
        lastFrame = System.nanoTime();
    }

    if (wave > level.length - 1) {
        MyWorld.addObject(new finishedSending(this, 15000L), 0, 0);
        wave = -1;
    }

    // Introduce the delay before spawning the first wave
    if (deltaTime >= firstWave && wave != -1 && first) {
        if (deltaTime < firstWave + 20000) {  // Wait an additional 20 seconds
            return; // Do nothing until the delay is over
        }

        AudioPlayer.play(80, "awooga.mp3");
        checkSendWave();

        wave++;
        lastFrame = System.nanoTime();
        first = false;
    }

    if (!first && wave != -1) {
        if ((deltaTime >= waveTime) || MyWorld.getObjects(Zombie.class).size() == 0) {
            checkSendWave();

            wave++;
            lastFrame = System.nanoTime();
        }
    }
}
}
