package com.shaglama.shaggyrpg.location.vectors.heading;

import com.shaglama.shaggyrpg.location.vectors.Vector;

public class InverseYHeadingVector extends HeadingVector {

	public InverseYHeadingVector() {
		super();
	}

	public InverseYHeadingVector(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getAngle(){
		return InverseYHeadingVector.getAngleFromVector(this);
	}
	
	public static InverseYHeadingVector getVectorFromAngle(double angle){
		double radians = angle * (Math.PI / 180);
		return new InverseYHeadingVector(Math.sin(radians), -Math.cos(radians));
	}
	public static double getAngleFromVector(Vector v){
		return (Math.atan2(v.getX(), -v.getY()) * 180 / Math.PI);
	}
}
