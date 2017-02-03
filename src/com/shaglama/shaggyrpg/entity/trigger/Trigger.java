package com.shaglama.shaggyrpg.entity.trigger;

import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.entity.Entity;
import com.shaglama.shaggyrpg.location.Location;
import com.shaglama.shaggyrpg.location.position.Position;

public abstract class Trigger extends Entity {

	public Trigger() {
		super();
	}

	public Trigger(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Trigger(Position position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	public Trigger(Dimensions dimensions) {
		super(dimensions);
		// TODO Auto-generated constructor stub
	}

	public Trigger(Position position, Dimensions dimensions) {
		super(position, dimensions);
		// TODO Auto-generated constructor stub
	}
	public Trigger(String id, Position position) {
		super(id, position);
		// TODO Auto-generated constructor stub
	}
	public Trigger(String id, Dimensions dimensions) {
		super(id, dimensions);
		// TODO Auto-generated constructor stub
	}

	public Trigger(String id, Position position, Dimensions dimensions) {
		super(id, position, dimensions);
		// TODO Auto-generated constructor stub
	}

	
	public abstract void trip();

}
