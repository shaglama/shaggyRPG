package com.shaglama.shaggyrpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.shaglama.shaggyrpg.display.Display;
import com.shaglama.shaggyrpg.input.KeyInput;
import com.shaglama.shaggyrpg.states.GameState;
import com.shaglama.shaggyrpg.states.MenuState;
import com.shaglama.shaggyrpg.states.State;
import com.shaglama.shaggyrpg.states.StateManager;
import com.shaglama.shaggyrpg.timer.NanoTimer;
import com.shaglama.shaggyrpg.timer.TimerListener;
import com.shaglama.shaggyrpg.assets.Assets;
import com.shaglama.shaggyrpg.assets.gfx.ImageLoader;
import com.shaglama.shaggyrpg.assets.gfx.SpriteSheet;

public class Game implements TimerListener {
	//members
	private static final int DEFAULT_FPS = 60;
	private NanoTimer timer;
	private int fps;
	private int nanosInSecond = 1000000000;
	private double timePerTick;
	private Display display;
	private Thread thread;
	private boolean running = false;
	private String title;
	private int width;
	private int height;
	private BufferStrategy bs;
	private Graphics g;
	private Assets assets;
	private StateManager stateManager = new StateManager();
	private State gameState;
	private State menuState;
	private KeyInput keyManager;
	private int x = 0; //testCode;
	//private BufferedImage testImage; //test Code!!!!!!!!
	//private SpriteSheet sheet; //test Code!!!!!!!!!
	
	//Constructor
	public Game(String title, int width, int height){
		this(title,width,height,DEFAULT_FPS);
	}
	public Game(String title, int width, int height,int fps) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.fps = fps;	
	}
	
	//methods
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public int getFramesPerSecond(){
		return fps;
	}
	public boolean setFramesPerSecond(int fps){
		if(fps > 0){
			this.fps = fps;
			return true;
		} else {
			return false;
		}
	}
	
	private void init(){
		timePerTick = nanosInSecond/fps;
		timer = new NanoTimer(timePerTick);
		timer.addListener(this);
		display = new Display(title,width,height);
		assets = new Assets();
		menuState = new MenuState(assets);
		gameState = new GameState(assets);	
		stateManager.setState(gameState);//test code, should probably bring up menu first
		keyManager = new KeyInput(display.getFrame()); 
		//testImage = ImageLoader.loadImage("/textures/sara16x18.png");//!!!!!!!!!!!
		//sheet = new SpriteSheet(testImage);
	}
	public void tick(){
		update();
		render();
	}
	private void update(){
		stateManager.update(keyManager.getInput());
	}
	private void render(){
		//set up drawing survace
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//clear drawing surface
		g.clearRect(0, 0, width, height);
		
		//fill with white background//test code
		g.setColor(Color.white);
		g.fillRect(0,0,width,height);
		
		//draw
		stateManager.render(g);			
		//end draw
		
		//show surface
		bs.show();
		
		//dispose of graphics object
		g.dispose();
	}
	
	public void run() {
		init();
		timer.start();
	}
	public void start(){
		if(!running){
			running = true;
			run();
		}		
	}
	public void stop(){
		if(running){
			running = false;
		}
		timer.stop();
	}

}
