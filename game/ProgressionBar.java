import greenfoot.*;
import greenfoot.Color;

public class ProgressionBar extends Actor {
    private WaveManager level;
    
    private int frameWidth = 458; 
    private int frameHeight = 34; 
    
    private int fillAreaWidth = 438; 
    private int fillAreaHeight = 14; 
    
    private int fillOffsetX = (frameWidth - fillAreaWidth) / 2; 
    private int fillOffsetY = (frameHeight - fillAreaHeight) / 2; 

    private GreenfootImage frame;
    private GreenfootImage bar;

    public ProgressionBar(WaveManager level) {
        this.level = level;
        
        frame = new GreenfootImage("progress.png");
        if(frame == null) {
            System.err.println("Error: progress.png could not be loaded. Check your images folder.");
            frame = new GreenfootImage(frameWidth, frameHeight);
            frame.setColor(Color.BLACK);
            frame.fill();
        }
        frame.scale(frameWidth, frameHeight);
        
        bar = new GreenfootImage(frame);
        setImage(bar);
    }
    
    public void act() {
        if (level.wave != -1) {
            int currentFillWidth = (int)(fillAreaWidth * ((double)(level.wave + 1) / level.level.length));
            
            bar.drawImage(frame, 0, 0);
            
            bar.setColor(new Color(80, 160, 32));

            bar.fillRect(fillOffsetX + fillAreaWidth - currentFillWidth, fillOffsetY, currentFillWidth, fillAreaHeight);
            
            setImage(bar);
        }
    }
}