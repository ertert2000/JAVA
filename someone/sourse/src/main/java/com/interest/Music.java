package com.interest;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Music {

	private static String filePath;
	private static FloatControl vc;
	private static int volume;
    
    public static void playMusic()
    {
        try {
	File soundFile = new File(filePath); //Звуковой файл
	
	//Получаем AudioInputStream
	//Вот тут могут полететь IOException и UnsupportedAudioFileException
	AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
	
	//Получаем реализацию интерфейса Clip
	//Может выкинуть LineUnavailableException
	Clip clip = AudioSystem.getClip();
	

	clip.open(ais);
	
	clip.setFramePosition(0); //устанавливаем указатель на старт

    vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	
    clip.start();

	Thread.sleep(clip.getMicrosecondLength()/1000);
	clip.stop();
	clip.close();
    

} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
	exc.printStackTrace();
} catch (InterruptedException exc) {}

    }

	public static void setFilePath(String path)
	{
		filePath = path;
	}

	public static float getMaxVolume()
	{
		return vc.getMaximum();
	}

	public static float getMinVolume()
	{
		return vc.getMinimum();
	}

	public static void setVolume(int v)
	{
		vc.setValue(v);
	}
}
