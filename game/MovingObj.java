import greenfoot.*;

public abstract class MovingObj extends Actor {
    private double exactX;
    private double exactY;

    @Override
    public void move(int distance){
        move((double) distance);
    }
    
    public void move(double distance){
        double radians = Math.toRadians(getRotation());
        double dx = Math.cos(radians) * distance;
        double dy = Math.sin(radians) * distance;
        setLocation(exactX + dx, exactY + dy);
    }
    
    public void setLocation(double x, double y){
        exactX = x;
        exactY = y;
        super.setLocation((int) Math.round(x), (int) Math.round(y));
    }
    
    @Override
    public void setLocation(int x, int y){
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    public double getExactX(){
        return exactX;
    }

    public double getExactY(){
        return exactY;
    }
}