package com.shaglama.shaggyrpg.states;

import java.awt.Graphics;

public class StateManager {
	private State currentState;
	
	public StateManager() {
		this(null);
	}
	public StateManager(State state){
		this.currentState = state;
	}
	public State getState() {
		return currentState;
	}
	public void setState(State state){
		currentState = state;
	}
	public void update(boolean[] input){
		if(currentState != null){
			currentState.update(input);
		}
	}
	public void render(Graphics g){
		if(currentState != null){
			currentState.render(g);
		}
	}
	

}
