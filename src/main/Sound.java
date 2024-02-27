package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

	Clip clip;
	URL soundURL[] = new URL[50];
	FloatControl fc;
	int volumeScale = 3;
	float volume;
	
	
	public Sound() {
		soundURL[0] = getClass().getResource("/Sound/mushadventure.wav");
		soundURL[1] = getClass().getResource("/Sound/coin.wav");
		soundURL[2] = getClass().getResource("/Sound/powerup.wav");
		soundURL[3] = getClass().getResource("/Sound/unlock.wav");
		soundURL[4] = getClass().getResource("/sound/fanfare.wav");
		soundURL[5] = getClass().getResource("/sound/MUSHSoundtrack1.wav");
		soundURL[6] = getClass().getResource("/sound/OpenWorld.wav");
		soundURL[7] = getClass().getResource("/sound/swingweapon.wav");
		soundURL[8] = getClass().getResource("/sound/1+AM+_bens_house.wav");
		soundURL[9] = getClass().getResource("/sound/takedamage.wav");
		soundURL[10] = getClass().getResource("/sound/hitmonster.wav");
		soundURL[11] = getClass().getResource("/sound/oldmannoise_1.wav");
		soundURL[12] = getClass().getResource("/sound/oldmannoise_2.wav");
		soundURL[13] = getClass().getResource("/sound/levelup_00.wav");
		soundURL[14] = getClass().getResource("/sound/oldmannoise_3.wav");
		soundURL[15] = getClass().getResource("/sound/cursor.wav");
		soundURL[16] = getClass().getResource("/sound/arhuh.wav");
		soundURL[17] = getClass().getResource("/sound/burning.wav");
		soundURL[18] = getClass().getResource("/sound/woodchop.wav");
		soundURL[19] = getClass().getResource("/sound/gameover.wav");
		soundURL[20] = getClass().getResource("/sound/stairs.wav");
		soundURL[21] = getClass().getResource("/sound/Houseng.wav");
		soundURL[22] = getClass().getResource("/sound/sellsound.wav");
		soundURL[23] = getClass().getResource("/sound/creepylaugh.wav");
		soundURL[24] = getClass().getResource("/sound/ghostsigh.wav");
		soundURL[25] = getClass().getResource("/sound/slimejump.wav");
		soundURL[26] = getClass().getResource("/sound/DungeonLevel (1).wav");
		soundURL[27] = getClass().getResource("/sound/InteriorSong.wav");
		soundURL[28] = getClass().getResource("/sound/ouw.wav");
		soundURL[29] = getClass().getResource("/sound/SpookyForrest.wav");
	}
	public void setFile(int i) {
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			checkVolume();
			
			
		}catch(Exception e) {
			
		}
	}
	public void play() {
		
		clip.start();
		
	}
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	public void stop() {
		
		clip.stop();
		
	}
	public void checkVolume() {
		
		switch(volumeScale) {
		case 0: volume = -80f; break;
		case 1: volume = -20f; break;
		case 2: volume = -12f; break;
		case 3: volume = -5f; break;
		case 4: volume = 1f; break;
		case 5: volume = 6f; break;
		
		}
		fc.setValue(volume);
		
	}
	
}
