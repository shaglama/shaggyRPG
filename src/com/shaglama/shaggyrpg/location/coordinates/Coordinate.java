package com.shaglama.shaggyrpg.location.coordinates;

public class Coordinate {
	double position;
	public Coordinate() {
		set(0);
	}
	public Coordinate(double position){
		set(position);		
	}
	public double get(){
		
		return this.position;
	}
	public boolean set(double position){
		this.position = position;
		return true;
	}

}
