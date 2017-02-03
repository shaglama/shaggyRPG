package com.shaglama.shaggyrpg.location.coordinates;

public class Coordinates {
	Coordinate x;
	Coordinate y;
	Coordinate z;
	
	public Coordinates() {
		this.x = new Coordinate(0);
		this.y = new Coordinate(0);
		this.z = new Coordinate(0);
	}
	
	public Coordinates(double x,double y,double z){
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}

	public double getX() {
		return x.get();
	}

	public boolean setX(double x) {
		return this.x.set(x);
	}

	public double getY() {
		return y.get();
	}

	public boolean setY(double y) {
		return this.y.set(y);
	}

	public double getZ() {
		return z.get();
	}

	public boolean setZ(double z) {
		return this.z.set(z);
	}
	
	public double[] getCoordinates() {
		return new double[] { getX(), getY(), getZ() };
	}
	
	public boolean[] setCoordinates(double x, double y, double z) {
		return new boolean[]{ setX(x), setY(y), setZ(z) };
	}

}
