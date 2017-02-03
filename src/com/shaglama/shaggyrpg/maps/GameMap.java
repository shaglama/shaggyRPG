package com.shaglama.shaggyrpg.maps;

import com.shaglama.shaggyrpg.assets.gfx.SpriteSheet;
import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.entity.Entity;

public class GameMap extends Map {
	private SpriteSheet spriteSheet;
	public GameMap(SpriteSheet spriteSheet) {
		super();
		setSpriteSheet(spriteSheet);
	}

	public GameMap(SpriteSheet spriteSheet, Dimensions dimensions) {
		super(dimensions);
		setSpriteSheet(spriteSheet);
	}

	public GameMap(SpriteSheet spriteSheet, Dimensions dimensions, Entity[] entities) {
		super(dimensions, entities);
		setSpriteSheet(spriteSheet);
	}
	
	public SpriteSheet getSpriteSheet(){
		return spriteSheet;
	}
	public boolean setSpriteSheet(SpriteSheet spriteSheet){
		this.spriteSheet = spriteSheet;
		return true;
	}

}
