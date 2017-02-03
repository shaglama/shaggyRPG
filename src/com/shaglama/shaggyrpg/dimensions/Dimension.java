package com.shaglama.shaggyrpg.dimensions;

public class Dimension {
	private int size;
	
	//Constructors ------------------------------------------------------------
	public Dimension() {
		this(1);
	}
	public Dimension(int size) throws IllegalArgumentException {
		if(setSize(size)){
			
		} else {
			throw new IllegalArgumentException("Invalid value for size. Size must be greater than 0");
		}
	}
	
	//Methods -----------------------------------------------------------------
	public int getSize(){
		return size;
	}
	public boolean setSize(int size){
		if(size >= 1){
			this.size = size;
			return true;
		} else {
			return false;
		}
	}

}
