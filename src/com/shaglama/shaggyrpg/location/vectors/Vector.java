package com.shaglama.shaggyrpg.location.vectors;

public class Vector {
	protected double x;
	protected double y;
	
	
	
	public Vector() {
		this(0,0);
	}
	public Vector(double x,double y){
		setX(x);
		setY(y);
	}	
	
	
	
	public double getX() {
		return x;
	}
	public boolean setX(double x) {
		this.x = x;
		return true;
	}
	public double getY() {
		return y;
	}
	public boolean setY(double y) {
		this.y = y;
		return true;
	}
	public double getMagnitude(){
		return Vector.getMagnitude(x, y);
	}
	public void normalize(){
		Vector normalized = getNormalizedVector();
		if(!equals(normalized)){
			x = normalized.getX();
			y = normalized.getY();
		}
	}
	public Vector getNormalizedVector(){
		return Vector.getNormalizedVector(x, y);
	}
	public boolean equals(Vector vector){
		if(x == vector.getX() && y == vector.getY()){
			return true;
		} else {
			return false;
		}
	}
	public void add(Vector addend){
		x += addend.getX();
		y += addend.getY();		
	}
	public void add(double scalar){
		x += scalar;
		y += scalar;
	}
	public void subtract(Vector subtrahend){
		x -= subtrahend.getX();
		y -= subtrahend.getY();
	}
	public void subtract(double scalar){
		 x -= scalar;
		 y -= scalar;
	}
	public void multiply(double scalar){
		x *= scalar;
		y *= scalar;
	}		
	public void divide(double scalar){
		x /= scalar;
		y /= scalar;
	}
	public double getAngle(){
		return Vector.getAngleFromVector(this);
	}
	
	public static Vector getSum(Vector augend,Vector addend){
		return new Vector(augend.getX() + addend.getX(),
				augend.getY() + addend.getY());
	}
	public static Vector getSum(Vector augend, double scalar){
		return new Vector(augend.getX() + scalar,
				augend.getY() + scalar);
	}
	public static Vector getSum(Vector augend, double xScalar, double yScalar){
		return new Vector(augend.getX() + xScalar,augend.getY() + yScalar);
	}
	public static Vector getDifference(Vector minuend,Vector subtrahend){
		return new Vector(minuend.getX() - subtrahend.getX(),
				minuend.getY() - subtrahend.getY());
	}
	public static Vector getDifference(Vector minuend, double scalar){
		return new Vector(minuend.getX() - scalar,
				minuend.getY() - scalar);
	}
	public static Vector getDifference(Vector minuend, double xScalar, double yScalar){
		return new Vector(minuend.getX() - xScalar, minuend.getY() - yScalar);
	}
	public static Vector getNormalizedVector(double x, double y){
		double magnitude = Math.sqrt((x * x) + (y * y));
		if(magnitude != 1){
			return new Vector(x / magnitude, y / magnitude);
		} else {
			return new Vector(x,y);
		}
	}
	public static double getMagnitude(double x, double y){
		return Math.sqrt((x * x) + (y*y));
	}
	public static Vector  getVectorFromAngle(double angle){
		double radians = angle * (Math.PI / 180);
		return new Vector(Math.cos(radians), Math.sin(radians));
	}
	public static double getAngleFromVector(Vector v){
		return Math.atan2(v.getY(), v.getX()) * 180 / Math.PI;
	}
	
}
