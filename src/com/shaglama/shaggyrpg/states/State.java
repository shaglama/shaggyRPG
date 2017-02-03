package com.shaglama.shaggyrpg.states;

import java.awt.Graphics;

import com.shaglama.shaggyrpg.assets.Assets;

public abstract class State {
	protected Assets assetts;
	public State(Assets assetts) {
		this.assetts = assetts;
	}
	
	public abstract void update(boolean[] input);
	public abstract void render(Graphics g);

}
