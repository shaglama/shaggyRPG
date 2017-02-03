package com.shaglama.shaggyrpg.entity.trigger;

import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.location.Location;
import com.shaglama.shaggyrpg.location.position.Position;

public class EncounterTrigger extends Trigger {

//Constructors ----------------------------------------------------------------
	public EncounterTrigger() {
		super();
	}
	public EncounterTrigger(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public EncounterTrigger(Position position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	public EncounterTrigger(Dimensions dimensions){
		super(dimensions);
	}
	public EncounterTrigger(String id, Position position) {
		super(id, position);
		// TODO Auto-generated constructor stub
	}
	public EncounterTrigger(String id, Dimensions dimensions){
		super(id,dimensions);
	}
	public EncounterTrigger(Position position, Dimensions dimensions) {
		super(position, dimensions);
		// TODO Auto-generated constructor stub
	}
	public EncounterTrigger(String id, Position position, Dimensions dimensions) {
		super(id, position, dimensions);
		// TODO Auto-generated constructor stub
	}

//Methods ---------------------------------------------------------------------	

	@Override
	public void trip() {
		
		//test code
		System.out.println("encounter trigger tripped!!");

	}
	
}
