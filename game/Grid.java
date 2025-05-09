import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Grid extends Actor{
    private Plant[][] Grid = new Plant[5][9];
    
    public static final int xOffset = 221;
    public static final int yOffset = 99;
    public static final int xSpacing = 60;
    public static final int ySpacing = 75;

    public void placePlant(int x, int y, Plant plant){
        if (Grid[y][x] == null){
            Grid[y][x] = plant;
            World myWorld = getWorld();
            myWorld.addObject(plant, x * xSpacing + xOffset, y * ySpacing + yOffset);
            Audio.play(80, "plant.mp3", "plant2.mp3");
        }
    }

    public Plant getPlant(int x, int y){
        return Grid[y][x];
    }

    public void removePlant(int x, int y){
        if (Grid[y][x] != null){
            getWorld().removeObject(Grid[y][x]);
            Grid[y][x] = null;
        }
        Audio.play(80, "plant2.mp3");
    }

    public void updateGrid(){
        for (int i = 0; i < Grid.length; i++){
            for (int k = 0; k < Grid[0].length; k++){
                if (Grid[i][k] != null) {
                    World myWorld = getWorld();
                    Plant temp = Grid[i][k];
                    myWorld.addObject(temp, k * xSpacing + xOffset, i * ySpacing + yOffset);
                }
            }
        }
    }

    @Override
    public void act(){

    }
}
