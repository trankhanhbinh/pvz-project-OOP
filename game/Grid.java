import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Grid extends Actor{
    
    // instance variables - replace the example below with your own
    public Plant[][] Grid = new Plant[5][9]; 
    public static final int xOffset = 221;
    public static final int yOffset = 99;
    public static final int xSpacing = 60;
    public static final int ySpacing = 75;
    
    
    
    /**
     * Constructor for objects of class Grid
     */
    public Grid()
    {
        
    }
    public void placePlant(int x, int y, Plant plant) {
        if (Grid[y][x] == null) {
            Grid[y][x] = plant;    
            World MyWorld = getWorld();
            
            MyWorld.addObject(plant, x*xSpacing+xOffset, y*ySpacing+yOffset);
            Audio.play(80, "plant.mp3", "plant2.mp3");
        }
        
    }
    public Plant getPlant(int x, int y) {
        return Grid[y][x];
    }
    public void removePlant(int x, int y) {
        if (Grid[y][x] != null) {
            getWorld().removeObject(Grid[y][x]);
            Grid[y][x] = null;    
        }
        Audio.play(80,"plant2.mp3");
    }
    
    public void updateGrid() {
        for (int i = 0; i < Grid.length; i++) {
            for (int k = 0; k < Grid[0].length; k++) {
                if (Grid[i][k] != null) {
                    World MyWorld = getWorld();
                    Plant temp = Grid[i][k];
                    MyWorld.addObject(temp, k*xSpacing+xOffset, i*ySpacing+yOffset);
                }
            }
        }
        
    }
    
    /**
     * Act - do whatever the Grid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
