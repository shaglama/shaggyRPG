package com.shaglama.shaggyrpg.location.position.positioner;

import com.shaglama.shaggyrpg.location.position.Position;
import com.shaglama.shaggyrpg.location.vectors.Vector;
import com.shaglama.shaggyrpg.location.vectors.Vector3d;
import com.shaglama.shaggyrpg.location.vectors.heading.HeadingVector;
import com.shaglama.shaggyrpg.location.vectors.heading.InverseYHeadingVector;


public class Positioner {
//Members----------------------------------------------------------------------
	//Constants----------------------------------------------------------------
	
	//Private------------------------------------------------------------------ 
	private Position position;
	
	//Protected----------------------------------------------------------------
	
	//public-------------------------------------------------------------------
	
//Methods----------------------------------------------------------------------
	//Constructors-------------------------------------------------------------
	public Positioner() {
		this(new Position());
	}
	public Positioner(Position position){
		if(!setPosition(position)){
			throw new IllegalArgumentException("invalid value for 'position'");
		}
	}
	
	//Private------------------------------------------------------------------
	
	//Protected----------------------------------------------------------------
	
	
	//Public-------------------------------------------------------------------
	public Position getPosition(){
		return position;
	}
	public boolean setPosition(Position position){
		this.position = position;
		return true;
	}
	public void setArea(String area){
		Positioner.setArea(position, area);
	}
	public void setX(double x){
		Positioner.setX(position, x);
	}
	public void setY(double y){
		Positioner.setY(position, y);
	}
	public void setZ(double z){
		Positioner.setZ(position, z);
	}
	public void setYaw(double yaw){
		Positioner.setYaw(position, yaw);
	}
	public void setRoll(double roll){
		Positioner.setRoll(position, roll);
	}
	public void setPitch(double pitch){
		Positioner.setPitch(position, pitch);
	}
	public void walk(double steps){
		Positioner.walk(position, steps);
	}
	public void walk(double steps, double degreesFromNorth){
		Positioner.walk(position, steps, degreesFromNorth);
	}
	public void walkRelativeToForward(double steps, double degreesFromForward){
		Positioner.walkRelativeToForaward(position, steps, degreesFromForward);
	}
	public void fly(double forwardSteps,double upSteps){
		Positioner.fly(position, forwardSteps, upSteps);
	}
	public void fly(double forwardSteps,double upSteps, double degreesFromNorth){
		Positioner.fly(position, forwardSteps, upSteps, degreesFromNorth);
	}
	public void flyRelativeToForward(double forwardSteps,double upSteps, double degreesFromForward){
		Positioner.flyRelativeToForward(position, forwardSteps, upSteps, degreesFromForward);
	}
	public void strafe(double steps){
		Positioner.strafe(position, steps);
	}
	public void strafe(double steps,double degreesFromNorth){
		Positioner.strafe(position, steps, degreesFromNorth);
	}
	public void strafeRelativeToForward(double steps, double degreesFromForward){
		Positioner.strafeRelativeToForward(null, steps, degreesFromForward);
	}
	public void hover(double steps, double upSteps){
		Positioner.hover(position, steps, upSteps);
	}
	public void hover(double steps, double upSteps, double degreesFromNorth){
		Positioner.hover(position, steps, upSteps, degreesFromNorth);
	}
	public void hoverRelativeToForward(double steps, double upSteps, double degreesFromForward){
		Positioner.hoverRelativeToForward(position, steps, upSteps, degreesFromForward);
	}
	public void teleport(double x, double y, double z){
		Positioner.teleport(position, x, y, z);
	}
	public void move(double steps,double degreesFromNorth){
		Positioner.move(position, steps, degreesFromNorth);
	}
	public void moveX(double steps){
		Positioner.moveX(position, steps);
	}
	public void moveY(double steps){
		Positioner.moveY(position, steps);
	}
	public void moveZ(double steps){
		Positioner.moveZ(position, steps);
	}
	public void move(double xSteps,double ySteps,double zSteps){
		Positioner.move(position,xSteps,ySteps,zSteps);
	}
	public void moveRelativeToForward(double degreesFromForward,double steps){
		Positioner.moveRelativeToForward(position, degreesFromForward, steps);
	}
	public void moveForward(double steps){
		Positioner.moveForward(position, steps);
	}
	public void moveBackward(double steps){
		Positioner.moveBackward(position,steps);
	}
	public void moveLeft(double steps){
		Positioner.moveLeft(position, steps);
	}
	public void moveRight(double steps){
		Positioner.moveRight(position, steps);
	}
	public void moveNorth(double steps){
		Positioner.moveNorth(position, steps);
	}
	
	public void moveSouth(double steps){
		Positioner.moveSouth(position, steps);
	}
	
	public void moveEast(double steps){
		Positioner.moveEast(position, steps);
	}
	
	public void moveWest(double steps){
		Positioner.moveWest(position, steps);
	}
	
	public void raise(double steps){
		Positioner.raise(position, steps);
	}
	
	public void lower(double steps){
		Positioner.lower(position, steps);
	}
	
	public void face(double yaw){
		Positioner.face(position, yaw);
	}
	public void face(double yaw, double roll, double pitch){
		Positioner.face(position, yaw, roll, pitch);
	}
	
	public void spin(double degrees){
		Positioner.spin(position, degrees);
	}
	
	public void spinLeft(double degrees){
		Positioner.spinLeft(position, degrees);
	}
	
	public void spinRight(double degrees){
		Positioner.spin(position, degrees);
	}
	
	public void spinAround(){
		Positioner.spinAround(position);
	}
	
	public void rotate(double degrees){
		Positioner.rotate(position, degrees);
	}
	
	public void rotateClockWise(double degrees){
		Positioner.rotateClockWise(position, degrees);
	}
	
	public void rotateCounterClockWise(double degrees){
		Positioner.rotateCounterClockWise(position, degrees);
	}
	
	public void rotateAround(){
		Positioner.rotateAround(position);
	}
	
	public void turn(double degrees){
		Positioner.turn(position, degrees);
	}
	
	public void turnUp(double degrees){
		Positioner.turnUp(position, degrees);
	}
	
	public void turnDown(double degrees){
		Positioner.turnDown(position, degrees);
	}
	
	public void turnAround(){
		Positioner.turnAround(position);
	}
	
	//Static-------------------------------------------------------------------
	public static void setArea(Position position, String area){
			position.setArea(area);
	}
	public static void setX(Position position,double x){
		position.setX(x);
	}
	public static void setY(Position position,double y){
		position.setY(y);
	}
	public static void setZ(Position position, double z){
		position.setZ(z);
	}
	public static void setYaw(Position position,double yaw){
		position.setYaw(yaw);
	}
	public static void setRoll(Position position, double roll){
		position.setRoll(roll);
	}
	public static void setPitch(Position position, double pitch){
		position.setPitch(pitch);
	}
	public static String getArea(Position position){
		return position.getArea();
	}
	public static double getX(Position position){
		return position.getX();
	}
	public static double getY(Position position){
		return position.getY();
	}
	public static double getZ(Position position){
		return position.getZ();
	}
	public static double getYaw(Position position){
		return position.getYaw();
	}
	public static double getRoll(Position position){
		return position.getRoll();
	}
	public static double getPitch(Position position){
		return position.getPitch();
	}
	
	public static void walk(Position position, double steps){
		Positioner.moveForward(position, steps);
	}
	public static void walk(Position position,double steps,double degreesFromNorth){
		Positioner.face(position, degreesFromNorth);
		Positioner.walk(position, steps);
	}
	public static void walkRelativeToForaward(Position position, double steps,double degreesFromForward){
		Positioner.walk(position, steps, position.getYaw() + degreesFromForward);
	}
	public static void fly(Position position,double forwardSteps, double upSteps){
		Positioner.walk(position,forwardSteps);
		Positioner.raise(position, upSteps);
	}
	public static void fly(Position position,double forwardSteps,double upSteps,double degreesFromNorth){
		Positioner.face(position, degreesFromNorth);
		Positioner.fly(position, forwardSteps, upSteps);
	}
	public static void flyRelativeToForward(Position position, double forwardSteps,double upSteps,double degreesFromForward){
		Positioner.fly(position, forwardSteps, upSteps, position.getYaw() +degreesFromForward);
	}
	public static void strafe(Position position,double steps){
		Positioner.strafe(position, steps,position.getYaw());
	}
	public static void strafe(Position position,double steps,double degreesFromNorth){
		Positioner.move(position, steps, degreesFromNorth);
	}
	public static void strafeRelativeToForward(Position position, double steps,  double degreesFromForward){
		Positioner.strafe(position, steps, position.getYaw() +degreesFromForward);
	}
	public static void hover(Position position, double steps, double upSteps){
		Positioner.strafe(position,steps);
		Positioner.raise(position, upSteps);
	}
	public static void hover(Position position, double steps, double upSteps, double degreesFromNorth ){
		Positioner.strafe(position, steps,degreesFromNorth);
		Positioner.raise(position, upSteps);
	}
	public static void hoverRelativeToForward(Position position, double steps, double upSteps, double degreesFromForward){
		Positioner.hover(position, steps, upSteps, position.getYaw() + degreesFromForward);
	}
	public static void teleport(Position position,double x, double y, double z){
		position.setX(x);
		position.setY(y);
		position.setZ(z);
	}
	public static void move(Position position,double steps, double degreesFromNorth){
		InverseYHeadingVector movement = InverseYHeadingVector.getVectorFromAngle(degreesFromNorth);
		movement.multiply(steps);
		movement.add(new Vector(position.getX(),position.getY()));
		
		position.setX(movement.getX());
		position.setY(movement.getY());
	}
	//!!!!!!Need to Fix this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	/*public static void move3d(Position position,double steps,double degreesFromNorth,double degreesFromHorizontal){
		InverseYHeadingVector xyMovement = InverseYHeadingVector.getVectorFromAngle(degreesFromNorth);
		HeadingVector zMovement = HeadingVector.getVectorFromAngle(degreesFromHorizontal);
		//double xyAngle = InverseYHeadingVector.getAngleFromVector(xyMovement);
		double xyAngle = xyMovement.getAngle();
		double zAngle = zMovement.getAngle();
		
		Vector3d movement3d = Vector3d.getVectorFromAngles(xyAngle, zAngle);
		movement3d.multiply(steps);
		movement3d.add(new Vector3d(position.getX(),position.getY(),position.getZ()));
		position.setX(movement3d.getX());
		position.setY(movement3d.getY());
		position.setZ(movement3d.getZ());
		
	}*/
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public static void move(Position position, double xSteps,double ySteps,double zSteps){
		Positioner.moveX(position, xSteps);
		Positioner.moveY(position, ySteps);
		Positioner.moveZ(position, zSteps);
	}
	public static void moveX(Position position, double steps){
		position.moveX(steps);
	}
	public static void moveY(Position position, double steps){
		position.moveY(steps);
	}
	public static void moveZ(Position position, double steps){
		position.moveY(steps);
	}
	public static void moveLeft(Position position, double steps){
		Positioner.moveRelativeToForward(position,270,steps);
	}
	public static void moveRight(Position position,double steps){
		Positioner.moveRelativeToForward(position,90,steps);
	}
	public static void moveRelativeToForward(Position position,double degreesFromForward, double steps){
		Positioner.move(position, steps, position.getYaw() + degreesFromForward);
	}
	public static void moveForward(Position position,double steps){
		Positioner.moveRelativeToForward(position,0,steps);
	}
	
	public static void moveBackward(Position position, double steps){
		Positioner.moveRelativeToForward(position,180,steps);
	}
	public static void moveNorth(Position position, double steps){
		Positioner.move(position, steps, 0);
	}
	public static void moveSouth(Position position, double steps){
		Positioner.move(position,steps,180);
	}
	public static void moveEast(Position position, double steps){
		Positioner.move(position, steps, 90);
	}
	public static void moveWest(Position position,double steps){
		Positioner.move(position, steps, 270);
	}
	public static void raise(Position position, double steps){
		position.moveZ(steps);
	}
	public static void lower(Position position,double steps){
		position.moveZ(-steps);
	}
	public static void face(Position position, double yaw){
		Positioner.face(position,yaw,position.getRoll(),position.getPitch());
	}
	public static void face(Position position,double yaw, double roll, double pitch){
		position.setYaw(yaw);
		position.setRoll(roll);
		position.setPitch(pitch);
	}
	
	public static void spin(Position position,double degrees){//change yaw
		position.rotateYaw(degrees);
	}
	public static void spinLeft(Position position, double degrees){
		Positioner.spin(position,-degrees);
	}
	public static void spinRight(Position position, double degrees){
		Positioner.spin(position,degrees);
	}
	public static void spinAround(Position position){
		Positioner.spin(position,180);
	}
	public static void rotate(Position position, double degrees){//change roll
		position.rotateRoll(degrees);
	}
	public static void rotateClockWise(Position position, double degrees){
		Positioner.rotate(position,degrees);
	}
	public static void rotateCounterClockWise(Position position,double degrees){
		Positioner.rotate(position,-degrees);
	}
	public static void rotateAround(Position position){
		Positioner.rotate(position,180);
	}
	public static void turn(Position position, double degrees){//change pitch
		position.rotatePitch(degrees);
	}
	public static void turnUp(Position position,double degrees){
		Positioner.turn(position, degrees);
	}
	public static void turnDown(Position position ,double degrees){
		Positioner.turn(position,-degrees);
	}
	public static void turnAround(Position position){
		Positioner.turn(position,180);
	}
	
	
	
	
	
}
