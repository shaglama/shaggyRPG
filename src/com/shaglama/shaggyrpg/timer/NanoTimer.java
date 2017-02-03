package com.shaglama.shaggyrpg.timer;

import java.util.ArrayList;
import java.util.List;

public class NanoTimer implements Runnable {
	private Thread thread;
	private List<TimerListener> listeners = new ArrayList<TimerListener>();
	private double timePerTick;
	double delta;
	private long now;
	private long lastTick;
	private boolean running = false;
	
	
	public NanoTimer(double timePerTick) {
		this.timePerTick = timePerTick;
	}

	public void init(){
		lastTick = System.nanoTime();
		delta = 0;
		
	}
	@Override
	public void run() {
		init();
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTick) / timePerTick;
			lastTick = now;
			if(delta >= 1){
				for(TimerListener tl : listeners){
					tl.tick();
				}
				delta --;
			}
		}
		
	}
	
	public synchronized void start() {
		if(!running){
			running = true;
			thread = new Thread(this);
			thread.start();
		}	
	}
	
	public synchronized void stop() {
		if(running){
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void addListener(TimerListener listener){
		listeners.add(listener);
	}
	public boolean removeListener(TimerListener listener){
		return listeners.remove(listener);
	}
}
