import greenfoot.GreenfootSound;
import greenfoot.Greenfoot;

public class Audio{
    public Audio(){
    }

    public static void play(String... audio){
        if (audio == null || audio.length == 0) return;
        
        int index = Greenfoot.getRandomNumber(audio.length);
        GreenfootSound sound = new GreenfootSound(audio[index]);
        sound.play();
    }

    public static void play(int volume, String... audio){
        if (audio == null || audio.length == 0) return; 
        
        int index = Greenfoot.getRandomNumber(audio.length);
        GreenfootSound sound = new GreenfootSound(audio[index]);
        sound.setVolume(volume);
        sound.play();
    }

    public static void play(boolean loop, String... audio){
        if (audio == null || audio.length == 0) return;
        int index = Greenfoot.getRandomNumber(audio.length);
        GreenfootSound sound = new GreenfootSound(audio[index]);
        if (loop){
            sound.playLoop();
        }else{
            sound.play();
        }
    }

    public static void stop(GreenfootSound... sounds){
        for (GreenfootSound sound : sounds){
            if (sound != null){
                sound.stop();
            }
        }
    }
}

