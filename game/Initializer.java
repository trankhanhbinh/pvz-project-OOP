import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Initializer extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Initializer()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 448, 1, false);
        //(width, height, each pixel is 1x1, object can appear outside the boudary)
        setBackground(new GreenfootImage("startup"));
        addObject(new Transition(true, new logo(), 30), 300, 224);
        setPaintOrder(EndTransition.class, Transition.class);
    }
    public void act(){
    }
}
