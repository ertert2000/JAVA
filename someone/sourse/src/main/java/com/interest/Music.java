package com.interest;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Music {
    
    public static void playMusic()
    {
        try {
	File soundFile = new File(""); //Звуковой файл
	
	//Получаем AudioInputStream
	//Вот тут могут полететь IOException и UnsupportedAudioFileException
	AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
	
	//Получаем реализацию интерфейса Clip
	//Может выкинуть LineUnavailableException
	Clip clip = AudioSystem.getClip();
	

	clip.open(ais);
	
	clip.setFramePosition(0); //устанавливаем указатель на старт

    FloatControl vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    vc.setValue(-10); 
	
    clip.start();

	Thread.sleep(clip.getMicrosecondLength()/1000);
	clip.stop();
	clip.close();
    

} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
	exc.printStackTrace();
} catch (InterruptedException exc) {}

    }
}
