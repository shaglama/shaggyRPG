package com.shaglama.shaggyrpg.location.vectors.heading;

import com.shaglama.shaggyrpg.location.vectors.Vector;

public class HeadingVector extends Vector {

	public HeadingVector() {
		super();
	}

	public HeadingVector(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getAngle(){
		return HeadingVector.getAngleFromVector(this);
	}
	
	public static HeadingVector getVectorFromAngle(double angle){
		double radians = angle * (Math.PI / 180);
		return new HeadingVector(Math.sin(radians), Math.cos(radians));
	}
	public static double getAngleFromVector(Vector v){
		return Math.atan2(v.getX(), v.getY()) * 180 / Math.PI;
	}

}
