/**
 * Write a description of class RNG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RNG{
    private int x;
    public RNG(){
    }
    public static int Int(int min, int max) {
        return (int)((Math.random() * (max-min)) + min);
    }
    public static double Double(int min, int max) {
        return ((Math.random() * (max-min)) + min)/100;
    }
}