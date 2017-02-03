package com.shaglama.shaggyrpg.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;//test code
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import com.shaglama.shaggyrpg.assets.Assets;
import com.shaglama.shaggyrpg.assets.gfx.AnimationList;
import com.shaglama.shaggyrpg.assets.snd.Sound;
import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.entity.AnimatedMoveableVisibleEntity;
import com.shaglama.shaggyrpg.entity.MoveableVisibleEntity;
import com.shaglama.shaggyrpg.location.position.Position;
import com.shaglama.shaggyrpg.location.position.positioner.Positioner;

public class GameState extends State {
	BufferedImage img = super.assetts.getImage("walk_down_8");//test code
	AnimatedMoveableVisibleEntity player = new AnimatedMoveableVisibleEntity(img);
	Position position = new Position();
	Positioner positioner = new Positioner(position);
	
	int delta = 0;
	int minX = 0;
	int maxX = 800 - img.getWidth();
	int minY = 0;
	int maxY = 600 - img.getHeight();
	
	//test code
	Sound fartSound = assetts.getSound("fart");
	Sound iFartedSound = assetts.getSound("i_farted");
	Clip fartClip;// = fartSound.getClip();
	Clip iFartedClip;// = iFartedSound.getClip();
	boolean farting;
	int fartFrames;
	int maxFartFrames = 70;
	public boolean talking = false;
	boolean movingNorth = false;
	boolean movingWest = false;
	int[] keys = new int[256];
	long lastAnimUpdate = System.currentTimeMillis();
	
	
	public GameState(Assets assets) {
		super(assets);
		player.setCoordinates(300, 300, 0);
		player.setSpeed(1);
		player.getDimensions().setHeight(48);
		player.getDimensions().setWidth(32);
		
	}

	@Override
	public void update(boolean[] input) {
		int animSpeed = (int) Math.min(60, Math.ceil(player.getSpeed() * 3));
		long animInterval; //= (1000 / 60) * (60 / animSpeed);
		long now = System.currentTimeMillis();
		if(animSpeed > 0){
			animInterval = ((1000 / 60) * (60 / animSpeed));
		} else {
			animInterval = 0;
		}
		
		if(input[KeyEvent.VK_P]){
			if(!farting){
				farting = true;
				//fartFrames = 0;
				player.setAnimation(assetts.getAnimation("cast_down"));
					
				fartClip = fartSound.getClip();
				fartClip.setFramePosition(0);
				fartClip.start();
				fartClip.addLineListener(new LineListener(){

					@Override
					public void update(LineEvent event) {
						if(event.getType() == LineEvent.Type.STOP){
							farting = false;
						}
						
					}
					
				});
				
			}
		}
		if(input[KeyEvent.VK_O]){
			if(!talking){
				talking = true;
				iFartedClip = iFartedSound.getClip();
				iFartedClip.setFramePosition(0);
				iFartedClip.start();
				iFartedClip.addLineListener(new LineListener(){

					@Override
					public void update(LineEvent event) {
						if(event.getType() == LineEvent.Type.STOP){
							talking = false;
						}
						
					}
					
				});
				
			}

		}
		AnimationList anim = null;
		if(input[KeyEvent.VK_UP]){// up arrow
			farting = false;
			if(input[KeyEvent.VK_RIGHT]){// right arrow
				player.positioner.walk(player.getSpeed(),45);
			} else if(input[KeyEvent.VK_LEFT]){//left arow
				player.positioner.walk(player.getSpeed(),315);
			} else {
				player.positioner.walk(player.getSpeed(),0);
			}
			anim = assetts.getAnimation("walk_up");
			if(player.getAnimation() != anim){
				player.setAnimation(anim);
				anim.first();
			} else {
				if(now - lastAnimUpdate >= animInterval){
					lastAnimUpdate = now;
					if(animInterval > 0){
						anim.next();
					}
				}
				//anim.next();
			}
		} else if(input[KeyEvent.VK_DOWN]) {//down arrow
			farting = false;
			if(input[KeyEvent.VK_RIGHT]){//right arrow
				player.positioner.walk(player.getSpeed(),135);
			} else if(input[KeyEvent.VK_LEFT]){//left arow
				player.positioner.walk(player.getSpeed(),225);
			} else {
				player.positioner.walk(player.getSpeed(),180);
			}
			anim = assetts.getAnimation("walk_down");
			if(player.getAnimation() != anim){
				player.setAnimation(anim);
				anim.first();
			} else	{
				if(now - lastAnimUpdate >= animInterval){
					lastAnimUpdate = now;
					if(animInterval > 0){
						anim.next();
					}
				}
				//anim.next();
			}
		} else {
			if(input[KeyEvent.VK_RIGHT]){//right arrow
				farting = false;
				player.positioner.walk(player.getSpeed(),90);
				anim = assetts.getAnimation("walk_right");
				if(player.getAnimation() != anim){
					player.setAnimation(anim);
					anim.first();
				} else {
					if(now - lastAnimUpdate >= animInterval){
						lastAnimUpdate = now;
						if(animInterval > 0){
							anim.next();
						}
					}
					//anim.next();
				}
				
			} else if(input[KeyEvent.VK_LEFT]){//left arow
				farting = false;
				player.positioner.walk(player.getSpeed(),270);
				anim = assetts.getAnimation("walk_left");
				if(player.getAnimation() != anim){
					player.setAnimation(anim);
					anim.first();
				} else {
					if(now - lastAnimUpdate >= animInterval){
						lastAnimUpdate = now;
						if(animInterval > 0){
							anim.next();
						}
					}
					
					//anim.next();
				}
			} else {
				if(player.getAnimation() != null){
					if(farting){
						/*if(fartFrames < maxFartFrames){
							fartFrames++;
							player.getAnimation().next();
						} else {
							farting = false;
							fartClip = null;
						}*/
						player.getAnimation().next();
					} else {
					
						player.getAnimation().first();
					}
				}
			}
		}
		
		if(input[KeyEvent.VK_S]){
			player.setSpeed(player.getSpeed() - 1);
		} else if (input[KeyEvent.VK_F]){
			player.setSpeed(player.getSpeed() + 1);
		}
		Position currentPosition = player.getPosition();
		if(currentPosition.getX() < minX){
			currentPosition.setX(minX);
		}
		if(currentPosition.getX() > maxX){
			currentPosition.setX(maxX);
		}
		if(currentPosition.getY() < minY){
			currentPosition.setY(minY);
		}
		if(currentPosition.getY() > maxY){
			currentPosition.setY(maxY);
		}
		
		/*System.out.println("Position: " + position.getX() + "," + position.getY() + "," + position.getZ());
		System.out.println("Moving Right-->");
		Positioner.moveRight(position, 5);
		System.out.println("Position: " + position.getX() + "," + position.getY() + "," + position.getZ());
		System.out.println(" ");
		double[] coords = player.getCoordinates();
		player.positioner.walk(player.getSpeed());
		if(coords[0] < minX){
			if(movingNorth){
				player.positioner.face(45);
			} else {
				player.positioner.face(135);
				
			}
			movingWest = false;
			
		}
		if(coords[0] > maxX){
			if(movingNorth){
				player.positioner.face(315);
			} else {
				player.positioner.face(225);
			}
			movingWest = true;
			
		}
		if(coords[1] < minY){
			if(movingWest){
				player.positioner.face(225);
			} else {
				player.positioner.face(135);
			}
			movingNorth = false;
		}
		if(coords[1] > maxY){
			if(movingWest){
				player.positioner.face(315);
			} else {
				player.positioner.face(45);
			}
			movingNorth = true;
		}*/
			
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(player.getAnimationSprite(), (int)player.getCoordinates()[0],(int)player.getCoordinates()[1],player.getDimensions().getWidth(),player.getDimensions().getHeight(), null);//test code

	}

}
