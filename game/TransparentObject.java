import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransparentObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransparentObject extends Actor{
    public TransparentObject(){    
    }
    public void act(){
    }
    public void setTransparent(boolean bool){
        if (bool) {
            getImage().setTransparency(125);
        } else {
            getImage().setTransparency(255);
        }
    }
}
