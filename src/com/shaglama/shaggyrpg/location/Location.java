package com.shaglama.shaggyrpg.location;

import com.shaglama.shaggyrpg.location.coordinates.Coordinates;

public class Location extends Coordinates {
	private static final String DEFAULT_AREA = "DEFAULT";
	private String area ="";	
	
	public Location() {
		this(DEFAULT_AREA);
	}	
	
	public Location(String area){
		super();
		setArea(area);
	}
	
	public Location(double x, double y, double z){
		this(DEFAULT_AREA,x,y,z);
	}
	public Location(String area, double x, double y, double z){
		super(x,y,z);
		setArea(area);		
	}
	
	public String getArea(){
		return area;
	}
	public boolean setArea(String area){
		this.area = area;
		return true;
	}
	
}
