package com.shaglama.shaggyrpg.location.position;

import com.shaglama.shaggyrpg.location.Location;
import com.shaglama.shaggyrpg.location.bearings.Axes;
import com.shaglama.shaggyrpg.location.bearings.CompassBearing;
import com.shaglama.shaggyrpg.location.bearings.HorizonBearing;

public class Position {
	private static final String	DEFAULT_AREA = "World";
	private static final double DEFAULT_X = 0;
	private static final double DEFAULT_Y = 0;
	private static final double DEFAULT_Z = 0;
	private static final double DEFAULT_YAW = 0;
	private static final double DEFAULT_ROLL = 0;
	private static final double DEFAULT_PITCH = 0;
	protected CompassBearing yaw;
	protected HorizonBearing pitch;
	protected HorizonBearing roll;
	protected Location location = new Location();
	
	public Position() {
		this(DEFAULT_AREA, DEFAULT_X, DEFAULT_Y, DEFAULT_Z, DEFAULT_YAW, DEFAULT_ROLL, DEFAULT_PITCH);
	}

	public Position(String area, double x, double y, double z,double yaw, double roll, double pitch) {
		this.yaw = new CompassBearing();
		this.pitch = new HorizonBearing(Axes.LATERAL);
		this.roll = new HorizonBearing(Axes.LONGITUDINAL);
		this.location = new Location(area,x,y,z);
	}
	public boolean setYaw(double yaw){
		if(isValidDegree(yaw)){
			this.yaw.setBearing(yaw);
			return true;
		} else {
			return false;
		}
	}
	public boolean setRoll(double roll){
		if(isValidDegree(roll)){
			this.roll.setDegreesFromHorizontal(roll);
			return true;
		} else {
			return false;
		}
	}
	public boolean setPitch(double pitch){
		if(isValidDegree(pitch)){
			this.pitch.setDegreesFromHorizontal(pitch);
			return true;
		} else {
			return false;
		}
	}
	public boolean setX(double x){
		return location.setX(x);
	}
	public boolean setY(double y){
		return location.setY(y);
	}
	public boolean setZ(double z){
		return location.setZ(z);
	}
	public boolean setArea(String area){
		return location.setArea(area);
	}
	public double getX(){
		return location.getX();
	}
	public double getY(){
		return location.getY();
	}
	public double getZ(){
		return location.getZ();
	}
	public String getArea(){
		return location.getArea();
	}
	public double getYaw(){
		return yaw.getDegreeesFromNorth();
	}
	public double getRoll(){
		return roll.getDegreesFromHorizontal();
	}
	public double getPitch(){
		return pitch.getDegreesFromHorizontal();
	}
	
	public double moveX(double amount){
		location.setX(location.getX() + amount);
		return location.getX();	
	}
	public double moveY(double amount){
		location.setY(location.getY() + amount);
		return location.getY();
	}
	public double moveZ(double amount){
		location.setZ(location.getZ() + amount);
		return location.getZ();
	}
	public double rotateYaw(double amount){
		yaw.rotate(amount);
		return yaw.getDegreeesFromNorth();
	}
	public double rotateRoll(double amount){
		roll.rotate(amount);
		return roll.getDegreesFromHorizontal();
	}
	public double rotatePitch(double amount){
		pitch.rotate(amount);
		return pitch.getDegreesFromHorizontal();
	}
	
	public CompassBearing getYawBearing(){
		return yaw;
	}
	public CompassBearing getOppositeYawBearing(){
		return yaw.getOppositeBearing();
	}
	public CompassBearing getLeftYawBearing(){
		return yaw.getLeftBearing();
	}
	
	public CompassBearing getRightYawBearing(){
		return yaw.getRightBearing();
	}
	public CompassBearing getYawBearingAt(double degreesFromBearing){
		return yaw.getBearingAt(degreesFromBearing);
	}
	
	@Override
	public String toString(){
		return "Area: " + location.getArea() + " -- " +
				"X: " + location.getX() + " -- " +
				"Y: " + location.getY() + " -- " +
				"Z: " + location.getZ() + " -- " +
				"Yaw " + yaw + " -- " +
				"Roll " + roll + " -- " +
				"Pitch " + pitch;
	}
	private boolean isValidDegree(double degree){
		if(degree >=0 && degree < 360){
			return true;
		} else {
			return false;
		}
	}
	
	

}
