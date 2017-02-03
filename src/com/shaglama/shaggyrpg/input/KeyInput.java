package com.shaglama.shaggyrpg.input;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
	private boolean[] keys = new boolean[256];

	public KeyInput(Component generator) {
		generator.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public boolean[] getInput(){
		return keys.clone();
	}

}
