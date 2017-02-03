package com.shaglama.shaggyrpg.location.vectors;

public class Vector3d {
	protected double x;
	protected double y;
	protected double z;
	public Vector3d() {
		setX(0);
		setY(0);
		setZ(0);
	}

	public Vector3d(double x, double y,double z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getZ(){
		return z;
	}
	public boolean setX(double x){
		this.x = x;
		return true;
	}
	public boolean setY(double y){
		this.y = y;
		return true;
	}
	public boolean setZ(double z){
		this.z = z;
		return true;
	}
	public boolean equals(Vector3d target){
		if(getX() == target.getX() && getY() == target.getY() && getZ() == target.getZ()){
			return true;
		} else {
			return false;
		}
	}
	public void add(Vector3d addend){
		setX(getX() + addend.getX());
		setY(getY() + addend.getY());
		setZ(getZ() + addend.getZ());
	}
	public void add(double scalar){
		add(new Vector3d(scalar,scalar,scalar));
	}
	public void subtract(Vector3d subtrahend){
		setX(getX() - subtrahend.getX());
		setY(getY() - subtrahend.getY());
		setZ(getZ() - subtrahend.getZ());
	}
	public void subtract(double scalar){
		subtract(new Vector3d(scalar,scalar,scalar));
	}
	public void multiply(double scalar){
		setX(getX() * scalar);
		setY(getY() * scalar);
		setZ(getZ() * scalar);
	}
	public void divide(double scalar){
		setX(getX() / scalar);
		setY(getY() / scalar);
		setZ(getZ() / scalar);
	}
	public double getMagnitude(){
		return Vector3d.getMagnitude(getX(), getY(), getZ());
	}
	public double[] getAngles(){
		return Vector3d.getAnglesFromVector(this);
	}
	public Vector3d getNormalizedVector(){
		return Vector3d.getNormalizedVector(this);
	}
	public void normalize(){
		Vector3d normalized = getNormalizedVector();
		setX(normalized.getX());
		setY(normalized.getY());
		setZ(normalized.getZ());
	}
	
	public static Vector3d getSum(Vector3d augend, Vector3d addend){
		return new Vector3d(augend.getX() + addend.getX(),augend.getY() + addend.getY(),augend.getZ() + addend.getZ());
	}
	public static Vector3d getSum(Vector3d augend, double scalar){
		return Vector3d.getSum(augend, new Vector3d(scalar,scalar,scalar));
	}
	public static Vector3d getSum(Vector3d augend, double xScalar,double yScalar, double zScalar){
		return Vector3d.getSum(augend, new Vector3d(xScalar,yScalar,zScalar));
	}
	public static Vector3d getDifference(Vector3d minuend, Vector3d subtrahend){
		return new Vector3d(minuend.getX() - subtrahend.getX(),minuend.getY() - subtrahend.getY(), minuend.getZ() - subtrahend.getZ());
	}
	public static Vector3d getDifference(Vector3d minuend, double scalar){
		return Vector3d.getDifference(minuend, new Vector3d(scalar,scalar,scalar));
	}
	public static Vector3d getDifference(Vector3d minuend, double xScalar,double yScalar,double zScalar){
		return Vector3d.getDifference(minuend, new Vector3d(xScalar,yScalar,zScalar));
	}
	public static double getMagnitude(double x, double y, double z){
		return Math.sqrt((x*x) + (y*y) + (z*z));
	}
	public static double getMagnitude(Vector3d vector){
		return Vector3d.getMagnitude(vector.getX(),vector.getY(),vector.getZ());
	}
	public static Vector3d getNormalizedVector(double x, double y, double z){
		double magnitude = Vector3d.getMagnitude(x, y, z);
		return new Vector3d(x/magnitude,y/magnitude,z/magnitude);
	}
	public static Vector3d getNormalizedVector(Vector3d target){
		return Vector3d.getNormalizedVector(target.getX(),target.getY(),target.getZ());
	}

	public static double[] getAnglesFromVector(double x, double y, double z){
		double radius;
		double xyAngle;
		double zAngle;
		radius = Vector3d.getMagnitude(x, y, z);
		xyAngle = Math.atan(y/x);
		zAngle = Math.acos(z/radius);
		return new double[] {xyAngle,zAngle};
		
	}
	public static double[] getAnglesFromVector(Vector3d vector){
		return Vector3d.getAnglesFromVector(vector.getX(), vector.getY(), vector.getZ());
	}
	public static Vector3d getVectorFromAngles(double xyAngle,double zAngle){
		double x, y, z;
		
		x = Math.sin(zAngle) * Math.cos(xyAngle);
		y= Math.sin(xyAngle) * Math.sin(zAngle);
		z = Math.cos(zAngle);
		
		return new Vector3d(x,y,z);
	}
}
