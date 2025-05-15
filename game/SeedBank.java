import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class SeedSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeedBank extends Actor{
    private MyWorld myWorld;
    private SunCounter sunCounter = new SunCounter();
    private SeedPacket[] bank;
    private SeedPacket selectedPacket = null;
    private TransparentObject image = null;
    private TransparentObject transparent = null;

    public static final int x1 = 189;
    public static final int x2 = 730;
    public static final int xSpacing = Board.xSpacing;
    
    public static final int y1 = 65;
    public static final int y2 = 434;
    public static final int ySpacing = Board.ySpacing;

    public SeedBank(SeedPacket[] bank){
        this.bank = bank;
    }

    //mouse and plant placement.
    public void act(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null){
            handleMouseMovement(mouse);
            handleMouseClick(mouse);
        }
    }

    //mouse movement and placement preview.
    private void handleMouseMovement(MouseInfo mouse) {
        if (image != null){
            if ((mouse.getX() < x1 || mouse.getX() > x2 || mouse.getY() < y1 || mouse.getY() > y2) 
                || (myWorld.board.Board[(mouse.getY() - y1) / ySpacing][(mouse.getX() - x1) / xSpacing] != null)) {
                image.setTransparent(false);
                image.setLocation(mouse.getX(), mouse.getY());
            } else {
                int x = (mouse.getX() - x1) / xSpacing;
                int y = (mouse.getY() - y1) / ySpacing;
                image.setTransparent(true);
                image.setLocation(x * Board.xSpacing + Board.xOffset, y * Board.ySpacing + Board.yOffset);
            }
        }
    }

    //Handles mouse clicks for plant selection and placement.
    private void handleMouseClick(MouseInfo mouse) {
        if (Greenfoot.mouseClicked(null)){
            myWorld.moveHitbox();

            if (image != null) {
                if (mouse.getX() < x1 || mouse.getX() > x2 || mouse.getY() < y1 || mouse.getY() > y2) {
                    myWorld.removeObject(image);
                    image = null;
                    deselectPacket();
                }else{
                    placePlant(mouse);
                }
            }

            selectSeedPacket();
        }
    }

    //place the plants
    private void placePlant(MouseInfo mouse) {
        int x = (mouse.getX() - x1) / xSpacing;
        int y = (mouse.getY() - y1) / ySpacing;

        if (myWorld.board.Board[y][x] == null){
            myWorld.board.placePlant(x, y, selectedPacket.getPlant());
            sunCounter.removeSun(selectedPacket.sunCost);
            getWorld().removeObject(image);
            image = null;
            selectedPacket.startRecharge();
            selectedPacket.setRecharged(false);
            selectedPacket.setSelected(false);
            selectedPacket = null;
        }
    }

    //Deselect + sound
    private void deselectPacket(){
        boolean selected = false;
        Audio.play(80, "tap.mp3", "tap2.mp3");

        if (myWorld.hitbox.getTouching().contains(selectedPacket)) {
            selected = true;
        }

        if (!selected){
            selectedPacket.setSelected(false);
            selectedPacket = null;
        }
    }

    //determines if it was selected or deselected
    private void selectSeedPacket(){
        for (Object i : myWorld.hitbox.getTouching()){
            if (i instanceof SeedPacket){
                SeedPacket clicked = (SeedPacket) i;

                if (selectedPacket != clicked) {
                    if (clicked.recharged) {
                        if (selectedPacket != null){
                            selectedPacket.setSelected(false);
                            selectedPacket = null;
                        }
                        selectedPacket = clicked;
                        clicked.setSelected(true);
                        Audio.play(80, "seedlift.mp3");
                        image = clicked.addImage();
                    } else {
                        Audio.play(80, "buzzer.mp3");
                    }
                } else {
                    if (clicked.recharged) {
                        selectedPacket = null;
                        clicked.setSelected(false);
                        Audio.play(80, "seedlift.mp3");
                    }
                }
            }
        }
    }

    @Override
    public void addedToWorld(World world) {
        myWorld = (MyWorld) getWorld();
        myWorld.addObject(sunCounter, 125, 52);

        for (int i = 0; i < bank.length; i++) {
            myWorld.addObject(bank[i], 125, 125+i*52);
        }
    }
}


