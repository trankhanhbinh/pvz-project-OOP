import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MyWorld extends World
{   
    
    private boolean isPlaying = false;
    public boolean lose = false;
    public boolean loseOnce = false;
    public boolean winOnce = false;
    public Grid grid = new Grid();
    public GreenfootSound Grasswalk = new GreenfootSound("Grasswalk.mp3");
    public GreenfootSound CYS;
    public Zombie n = null;
    public World restartWorld;
    public FallingObject winPlant;
    public LawnMower lawnmower1 = new LawnMower();
    public LawnMower lawnmower2 = new LawnMower();
    public LawnMower lawnmower3 = new LawnMower(); 
    public LawnMower lawnmower4 = new LawnMower();
    public LawnMower lawnmower5 = new LawnMower();
    
    public Zombie[][] level1 = {
                {null, new BasicZombie(), null, null},
                {n},
                {new BasicZombie(), null, null, null, null}, 
                {n},
                {null, new BasicZombie(), null, new BasicZombie()},
                {new BasicZombie()},
                {null, null, new Conehead(), null, null},
                {n},
                {new BasicZombie(), new Conehead(), new BasicZombie(), new BasicZombie(), new BasicZombie(), n,new BasicZombie()}, 
                {n},
                {new Conehead(), n, null, new BasicZombie(), null, null, new BasicZombie()},
                {new BasicZombie(),n,n, new BasicZombie(), null, new BasicZombie(), new BasicZombie()},
                {new Buckethead(), null, null, null, null},
                {n,new BasicZombie(),n,n,new Conehead(), n, n, new BasicZombie()},
                {null, new BasicZombie(), null, null, new Conehead(),n,n,new BasicZombie()},
                {new BasicZombie(), new BasicZombie(), new BasicZombie(),  null, new Conehead()}, 
                {null, null, new BasicZombie(), null, null},
                {n},
                {new Conehead(), new Conehead(), new Conehead(), new BasicZombie(), new BasicZombie(), new Buckethead(), null, new BasicZombie(), new Conehead(), new Buckethead()}
    };
 
    
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket(), new WalnutPacket(), new CactusPacket()};
    public SeedBank seedbank = new SeedBank(bank);   
    public Hitbox hitbox = new Hitbox();
    public Shovel shovel = new Shovel();
    
    
    public WaveManager level = new WaveManager(23500L, level1, 20000L, true, 8, 18);
    
    
    
    
    
    public void stopped() {
        if (Grasswalk.isPlaying()) {
            Grasswalk.pause();
        }
        
    }
    public void started() {
        if (!Grasswalk.isPlaying()) {
            Grasswalk.playLoop();
        }
        Greenfoot.setSpeed(50);        
        
    }
    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }
    public void finishLevel() {
        Grasswalk.stop();
        Audio.play(70, "winmusic.mp3");
        
        
    }

    public boolean hasLost() {
        for (Zombie i : getObjects(Zombie.class)) {
        
            
            if (i.getWorld() != null && i.getX() < 125) {
                lose = true;
                return lose;
            } else {
                lose = false;
            }
            
        }
        return lose;
    }
    public boolean hasWon() {
        return level.hasWon();
    }

    public MyWorld(GreenfootSound CYS, WaveManager level,  SeedBank seedbank, World restartWorld, FallingObject winPlant)
    {    
        super(763, 448, 1, false); 
        this.CYS = CYS;
        this.seedbank = seedbank;
        this.restartWorld = restartWorld;
        this.level = level;
        this.winPlant = winPlant;
        Greenfoot.setSpeed(50);
        setBackground("lawn (1).png");
        addObject(seedbank,0,0);
        addObject(grid,0,0);
        addObject(hitbox, 0,0);
        addObject(shovel, 690,420);
        addObject(new ProgressionBar(level), 490, 25);
        addObject (lawnmower1, 132, 357);
        addObject (lawnmower2, 132, 284);
        addObject (lawnmower3, 132, 211);
        addObject (lawnmower4, 132, 138);
        addObject (lawnmower5, 132, 65);
        
        setPaintOrder(ProgressionBar.class, Transition.class,AHugeWave.class, ReadySetPlant.class, SunCounter.class, useShovel.class, Shovel.class, TransparentObject.class, SeedPacket.class, FallingSun.class, Sun.class, Dirt.class, Projectile.class, FallingObject.class, Zombie.class, fallingZombie.class, Explosion.class, Plant.class);
    }
    
    public void act() {
        if (!isPlaying) {
            addObject(level,0,0);
            addObject(new DelayAudio(Grasswalk,CYS, 70, true, 2000L), 0,0);
            
            level.startLevel();
            isPlaying = true;           
            
        }
        if (!loseOnce && hasLost()) {
            Grasswalk.stop();
            Audio.play(80, "losemusic.mp3");
            
            GreenfootSound scream = new GreenfootSound("scream.mp3");
            
            addObject(new DelayAudio(scream, 70, false, 4000L), 0,0);
            loseOnce = true;
            Greenfoot.delay(250);
            addObject(new Transition(false, new GameOver(restartWorld), "GameOver.png", 5), 365, 215);
        } else if (!winOnce && hasWon()) {
            winOnce = true;
            addObject(winPlant, RNG.Int(SeedBank.x1, SeedBank.x2), 215);
        } else {
            if (Greenfoot.isKeyDown("1")) {
                CYS.stop();
                Grasswalk.stop();
                Greenfoot.setWorld(new Level0());
                    
                
            } else if (Greenfoot.isKeyDown("2")) {
                CYS.stop();
                Grasswalk.stop();
                Greenfoot.setWorld(new Level1());
                    
            } else if (Greenfoot.isKeyDown("3")) {
                CYS.stop();
                Grasswalk.stop();
                Greenfoot.setWorld(new Level2());
                    
            } else if (Greenfoot.isKeyDown("4")) {
                CYS.stop();
                Grasswalk.stop();
                Greenfoot.setWorld(new Level3());
            
            }
        }
        
    }
}   
    
