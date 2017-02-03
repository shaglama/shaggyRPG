package com.shaglama.shaggyrpg.entity;

import java.awt.image.BufferedImage;

import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.location.Location;
import com.shaglama.shaggyrpg.location.position.Position;

public class VisibleEntity extends Entity {
	private BufferedImage sprite;
	public VisibleEntity(BufferedImage sprite) {
		super();
		setSprite(sprite);
		// TODO Auto-generated constructor stub
	}

	public VisibleEntity(String id, BufferedImage sprite){
		super(id);
		setSprite(sprite);
	}

	public VisibleEntity(String id, Position position, Dimensions dimensions,BufferedImage sprite){
		super(id,position,dimensions);
		setSprite(sprite);
	}

	public BufferedImage getSprite(){
		return sprite;
	}
	public boolean setSprite(BufferedImage sprite){
		this.sprite = sprite;
		return true;
	}

}
