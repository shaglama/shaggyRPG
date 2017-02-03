package com.shaglama.shaggyrpg.entity;

import java.awt.image.BufferedImage;

import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.location.position.Position;
import com.shaglama.shaggyrpg.location.position.positioner.Positioner;

//!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	! !
//!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!
//!@#########################################################################@!
//!@###!!!!!Should change this to use a position and positioner##############@!
//!@#########################################################################@!
//!@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!
//!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	!	! !
public class MoveableVisibleEntity extends VisibleEntity {
//private members -------------------------------------------------------------
	private static final int DEFAULT_SPEED = 1;
	private int speed;
	
//public members --------------------------------------------------------------
	public Positioner positioner;
//Constructors ----------------------------------------------------------------
	public MoveableVisibleEntity(BufferedImage sprite) {
		super(sprite);
		init();
	}
	public MoveableVisibleEntity(String id, BufferedImage sprite) {
		super(id, sprite);
		init();
	}
	public MoveableVisibleEntity(String id, Position position, Dimensions dimensions, BufferedImage sprite) {
		super(id, position, dimensions, sprite);
		init();
	}
	public MoveableVisibleEntity(String id, Position position, Dimensions dimensions, BufferedImage sprite, int speed) {
		super(id, position, dimensions, sprite);
		init();
	}
	
//Public Methods --------------------------------------------------------------

	
	public boolean setSpeed(int speed) {
		if(speed >= 0){
			this.speed = speed;
			return true;
		} else {			
			return false;
		}
	}
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}
	public Position getPosition(){
		return positioner.getPosition();
	}

	
//private methods -------------------------------------------------------------
	private void init(){
		positioner = new Positioner(position);
		setSpeed(DEFAULT_SPEED);
	}	
}
