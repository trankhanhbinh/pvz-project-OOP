import greenfoot.*;
import java.util.*;


public class Hitbox extends Actor{

    public void act(){
    }
    public List getTouching(){
        return getIntersectingObjects(null);
    }
}