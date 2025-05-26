import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Plant extends animatedObjects {
    public int maxHp;
    public boolean isAlive = true;
    public int hp;
    public int damage;
    public boolean opaque = false;
    public MyWorld MyWorld;

    public Plant() {
        // Your initialization (if needed)
    }

    /**
     * Act - called each frame.
     * Before updating itself, the plant cleans up its row’s zombie list.
     */
    public void act() {
        if (getWorld() != null) {
            // Clean up any zombie references in this plant's row
            cleanZombieRow();
            
            if (isLiving()) {
                update();    
                // Set transparency based on whether the plant is meant to be opaque
                if (!opaque) {
                    getImage().setTransparency(255);
                } else {
                    getImage().setTransparency(125);
                }
            } else {
                MyWorld = (MyWorld)getWorld();
                Audio.play(80, "gulp.mp3");
                MyWorld.grid.removePlant(getXPos(), getYPos());
                MyWorld.removeObject(this);
                return;
            }
        }
    }
    
    /**
     * Clean up zombie references this plant's row in MyWorld.level.zombieRow
     * by removing any zombies that no longer exist in the world.
     * This helps ensure that when subclasses (e.g., Peashooter) iterate over their row,
     * they only process zombies that are actually present.
     */
    protected void cleanZombieRow() {
        // Ensure we have a proper reference to MyWorld.
        if(MyWorld == null) {
            MyWorld = (MyWorld)getWorld();
            if(MyWorld == null) {
                return; // Still no world? Nothing to clean.
            }
        }
        // Make sure that we have access to the zombieRow list.
        if(MyWorld.level != null && MyWorld.level.zombieRow != null) {
            // Retrieve the row that corresponds to this plant's grid position.
            java.util.List<Zombie> row = MyWorld.level.zombieRow.get(getYPos());
            // Iterate backward over the row list (so removals don't affect the loop)
            for (int i = row.size() - 1; i >= 0; i--) {
                Zombie z = row.get(i);
                // If the zombie reference is null or no longer in the world, remove it.
                if (z == null || z.getWorld() == null) {
                    row.remove(i);
                }
            }
        }
    }
    
    // Default update() method to be overridden by subclasses.
    public void update() {
        // Plant-specific behavior lives in subclasses (e.g., Peashooter)
    }
    
    public int getXPos() {
        return ((getX() - Grid.xOffset) / Grid.xSpacing);
    }   
    
    public int getYPos() {
        return ((getY() - Grid.yOffset) / Grid.ySpacing);
    }
    
    @Override
    public void addedToWorld(World world) {
        MyWorld = (MyWorld)getWorld();
        MyWorld.addObject(new Dirt(), getX(), getY() + 30);
    }
    
    public boolean isLiving() {
        if (hp <= 0) {
            isAlive = false;
        } else {
            isAlive = true;
        }
        return isAlive;
    }
    
    public void hit(int dmg) {
        // Default hit behavior (may be overridden)
    }
}
