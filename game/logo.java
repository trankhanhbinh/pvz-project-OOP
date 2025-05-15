import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class logo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class logo extends World {
    private int counter = 0;
    private GreenfootSound menuTheme;
    
    public logo(){
        super(600, 448, 1, false);
        setPaintOrder(EndTransition.class, Transition.class);

        menuTheme = new GreenfootSound("menu.mp3");
    }

    public void act() {
        if (!menuTheme.isPlaying()) {
            menuTheme.setVolume(70);
            menuTheme.playLoop();
        }
        counter++;
        if (counter > 100) {
            addObject(new Transition(true, new MainMenu(menuTheme), 6), getWidth()/2, getHeight()/2);
        }
    }
}
