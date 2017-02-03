package com.shaglama.shaggyrpg.assets.snd;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.Mixer.Info;

public class Sound {
	private File soundFile;
	private Thread thread;
	HashMap<String,Thread> threads = new HashMap<String,Thread>();
	HashMap<String,Clip> clips = new HashMap<String,Clip>();
	HashMap<String,LineListener> listeners = new HashMap<String,LineListener>();
	
	public Sound(String pathToFile) {
			soundFile = new File(pathToFile);
	}
	public Clip getClip(){
		try{
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
			DataLine.Info info = new DataLine.Info(Clip.class,audioStream.getFormat());
			Clip clip = (Clip)AudioSystem.getLine(info);
			clip.open(audioStream);
			return clip;
		} catch(Exception e){
			return null;
		}
	}
	public void play(){
		getClip().start();
	}
}
	