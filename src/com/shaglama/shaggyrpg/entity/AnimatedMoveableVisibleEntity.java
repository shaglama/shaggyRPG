package com.shaglama.shaggyrpg.entity;

import java.awt.image.BufferedImage;

import com.shaglama.shaggyrpg.assets.gfx.AnimationList;
import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.location.position.Position;

public class AnimatedMoveableVisibleEntity extends MoveableVisibleEntity {
	
	protected AnimationList animation = null;
	public AnimatedMoveableVisibleEntity(BufferedImage sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public AnimatedMoveableVisibleEntity(String id, BufferedImage sprite) {
		super(id, sprite);
		// TODO Auto-generated constructor stub
	}

	public AnimatedMoveableVisibleEntity(String id, Position position, Dimensions dimensions, BufferedImage sprite) {
		super(id, position, dimensions, sprite);
		// TODO Auto-generated constructor stub
	}

	public AnimatedMoveableVisibleEntity(String id, Position position, Dimensions dimensions, BufferedImage sprite,
			int speed) {
		super(id, position, dimensions, sprite, speed);
		// TODO Auto-generated constructor stub
	}
	public boolean setAnimation(AnimationList animation){
		this.animation = animation;
		return true;
	}
	public AnimationList getAnimation(){
		return animation;
	}
	
	public BufferedImage getAnimationSprite(){
		if(animation != null){
			return animation.getElement();
		} else {
			return getSprite();
		}
	}
	public BufferedImage nextAnimationSprite(){
		if(animation != null){
			return animation.next();
		} else {
			return getSprite();
		}
	}
	public BufferedImage prevAnimationSprite(){
		if(animation != null){
			return animation.prev();
		} else {
			return getSprite();
		}
	}

}
