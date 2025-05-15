import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProgressionBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProgressionBar extends Actor
{
    private WaveManager level;
    private GreenfootImage bar;
    private int barWidth = 428;
    private int barHeight = 14;

    public ProgressionBar(WaveManager level) {
        this.level = level;
        bar = new GreenfootImage(barWidth, barHeight);
        setImage(bar);
    }

    public void act() {
        if (level.wave != -1) {
            int fillWidth = (int)(barWidth * ((double)(level.wave + 1) / level.level.length));
            bar.clear();
            bar.setColor(new Color(80, 160, 32));
            bar.fillRect(barWidth - fillWidth, 0, fillWidth, barHeight); // Filling from right to left
            setImage(bar);
        }
    }

}
