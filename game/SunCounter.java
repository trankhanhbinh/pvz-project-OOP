import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SunCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SunCounter extends Actor{
    public static final int x = 125;  
    public static final int y = 52; 
    public int sun = 50;
    public static final int textY = 47;
    private long currentFrame = System.nanoTime();
    private long lastFrame = System.nanoTime();
    private long deltaTime;

    private MyWorld myWorld;
    
    //sun from sky manager
    public void act() {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame)/1000000;

        if (deltaTime >= 10000L) {
            myWorld.addObject(new FallingSun(), RNG.Int(SeedBank.x1, SeedBank.x2), 0);
            lastFrame = System.nanoTime();
        }
    }

    //start
    @Override
    public void addedToWorld(World world) {
        myWorld = (MyWorld) getWorld();
        currentFrame = System.nanoTime();
        lastFrame = System.nanoTime();
        updateText();
    }

    //update number
    public void updateText() {
        String number = "" + sun;
        char[] text = number.toCharArray();
        getImage().clear();
        setImage("suncounter.png");

        int baseX = 44;
        int spacing = 12;

        if (text.length > 5) {
            sun = 99999;
            System.out.println("It seems like you don't have the patience to play our game, ok then");
        } else {
            for (int i = 0; i < text.length; i++) {
                int offsetX = switch (text.length) {
                    case 5 -> 20 + i * spacing;
                    case 4 -> 26 + i * spacing;
                    case 3 -> 33 + i * spacing;
                    case 2 -> 38 + i * spacing;
                    default -> baseX;
                };
                getImage().drawImage(new GreenfootImage("text" + text[i] + ".png"), offsetX, textY);
            }
        }
    }

    //add
    public void addSun(int amount) {
        sun += amount;
        updateText();
    }

    //remove
    public void removeSun(int amount) {
        sun -= amount;
        updateText();
    }
}
