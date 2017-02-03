package com.shaglama.shaggyrpg.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import com.shaglama.shaggyrpg.assets.gfx.AnimationList;
import com.shaglama.shaggyrpg.assets.gfx.ImageLoader;
import com.shaglama.shaggyrpg.assets.gfx.SpriteSheet;
import com.shaglama.shaggyrpg.assets.snd.Sound;
import com.shaglama.shaggyrpg.exceptions.InvalidSizeException;

public class Assets {
	private HashMap<String,BufferedImage> imgMap = new HashMap<String,BufferedImage>();
	private HashMap<String,AnimationList> animationMap = new HashMap<String,AnimationList>();
	private HashMap<String,Sound> soundMap = new HashMap<String,Sound>();
	//private HashMap<String,BufferedSound> sndMap;
	//public BufferedImage[] imgs;
	
	public Assets() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	
	private void init(){
		//load assets here
		try{
			putSound("fart", new Sound("res/sounds/fart.wav"));
			putSound("i_farted", new Sound("res/sounds/i_farted.wav"));
			/*SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"),8,8);

			putImage("1", sheet.getSprite(1,0,3,5,3,0));
			putImage("2_1", sheet.getSprite(1, 5,3, 5, 3, 0));
			putImage("3_1",sheet.getSprite(1, 10,3,5,3,0));
			putImage("5",sheet.getSprite(5,0,3,5,3,0));
			putImage("2_5",sheet.getSprite(5, 5, 3, 5, 3, 0));			
			putImage("9",sheet.getSprite(9,0,3,5,3,0));
			putImage("2_9",sheet.getSprite(9,5,3,5,3,0));			
			putImage("13",sheet.getSprite(13, 0,3,5,3,0));
						
			putImage("17",sheet.getSprite(17, 0,3,5,3,0));
			
			putImage("21",sheet.getSprite(21, 0,3,5,3,0));*/
			
			SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/charactersheet.png"),16,16);
			putImage("walk_left_0",sheet.getSprite(1,37,2,3,-2,0));
			putImage("walk_left_1",sheet.getSprite(5,37,2,3,-2,0));
			putImage("walk_left_2",sheet.getSprite(9,37,2,3,-2,0));
			putImage("walk_left_3",sheet.getSprite(13,37,2,3,-2,0));
			putImage("walk_left_4",sheet.getSprite(17,37,2,3,-2,0));
			putImage("walk_left_5",sheet.getSprite(21,37,2,3,-2,0));
			putImage("walk_left_6",sheet.getSprite(25,37,2,3,-2,0));
			putImage("walk_left_7",sheet.getSprite(29,37,2,3,-2,0));
			putImage("walk_left_8",sheet.getSprite(33,37,2,3,-2,0));
			
			putImage("walk_right_0",sheet.getSprite(1,45,2,3,-2,0));
			putImage("walk_right_1",sheet.getSprite(5,45,2,3,-2,0));
			putImage("walk_right_2",sheet.getSprite(9,45,2,3,-2,0));
			putImage("walk_right_3",sheet.getSprite(13,45,2,3,-2,0));
			putImage("walk_right_4",sheet.getSprite(17,45,2,3,-2,0));
			putImage("walk_right_5",sheet.getSprite(21,45,2,3,-2,0));
			putImage("walk_right_6",sheet.getSprite(25,45,2,3,-2,0));
			putImage("walk_right_7",sheet.getSprite(29,45,2,3,-2,0));
			putImage("walk_right_8",sheet.getSprite(33,45,2,3,-2,0));
			
			putImage("walk_up_0",sheet.getSprite(1,33,2,3,-2,0));
			putImage("walk_up_1",sheet.getSprite(5,33,2,3,-2,0));
			putImage("walk_up_2",sheet.getSprite(9,33,2,3,-2,0));
			putImage("walk_up_3",sheet.getSprite(13,33,2,3,-2,0));
			putImage("walk_up_4",sheet.getSprite(17,33,2,3,-2,0));
			putImage("walk_up_5",sheet.getSprite(21,33,2,3,-2,0));
			putImage("walk_up_6",sheet.getSprite(25,33,2,3,-2,0));
			putImage("walk_up_7",sheet.getSprite(29,33,2,3,-2,0));
			putImage("walk_up_8",sheet.getSprite(33,33,2,3,-2,0));
			
			putImage("walk_down_0",sheet.getSprite(1,41,2,3,-2,0));
			putImage("walk_down_1",sheet.getSprite(5,41,2,3,-2,0));
			putImage("walk_down_2",sheet.getSprite(9,41,2,3,-2,0));
			putImage("walk_down_3",sheet.getSprite(13,41,2,3,-2,0));
			putImage("walk_down_4",sheet.getSprite(17,41,2,3,-2,0));
			putImage("walk_down_5",sheet.getSprite(21,41,2,3,-2,0));
			putImage("walk_down_6",sheet.getSprite(25,41,2,3,-2,0));
			putImage("walk_down_7",sheet.getSprite(29,41,2,3,-2,0));
			putImage("walk_down_8",sheet.getSprite(33,41,2,3,-2,0));
			
			AnimationList walk_left = new AnimationList();
			walk_left.append(getImage("walk_left_0"));
			walk_left.append(getImage("walk_left_1"));
			walk_left.append(getImage("walk_left_2"));
			walk_left.append(getImage("walk_left_3"));
			walk_left.append(getImage("walk_left_4"));
			walk_left.append(getImage("walk_left_5"));
			walk_left.append(getImage("walk_left_6"));
			walk_left.append(getImage("walk_left_7"));
			walk_left.append(getImage("walk_left_8"));			
			putAnimation("walk_left",walk_left);
			
			AnimationList walk_right = new AnimationList();
			walk_right.append(getImage("walk_right_0"));
			walk_right.append(getImage("walk_right_1"));
			walk_right.append(getImage("walk_right_2"));
			walk_right.append(getImage("walk_right_3"));
			walk_right.append(getImage("walk_right_4"));
			walk_right.append(getImage("walk_right_5"));
			walk_right.append(getImage("walk_right_6"));
			walk_right.append(getImage("walk_right_7"));
			walk_right.append(getImage("walk_right_8"));			
			putAnimation("walk_right",walk_right);
			
			AnimationList walk_up = new AnimationList();
			walk_up.append(getImage("walk_up_0"));
			walk_up.append(getImage("walk_up_1"));
			walk_up.append(getImage("walk_up_2"));
			walk_up.append(getImage("walk_up_3"));
			walk_up.append(getImage("walk_up_4"));
			walk_up.append(getImage("walk_up_5"));
			walk_up.append(getImage("walk_up_6"));
			walk_up.append(getImage("walk_up_7"));
			walk_up.append(getImage("walk_up_8"));			
			putAnimation("walk_up",walk_up);
			
			AnimationList walk_down = new AnimationList();
			walk_down.append(getImage("walk_down_0"));
			walk_down.append(getImage("walk_down_1"));
			walk_down.append(getImage("walk_down_2"));
			walk_down.append(getImage("walk_down_3"));
			walk_down.append(getImage("walk_down_4"));
			walk_down.append(getImage("walk_down_5"));
			walk_down.append(getImage("walk_down_6"));
			walk_down.append(getImage("walk_down_7"));
			walk_down.append(getImage("walk_down_8"));			
			putAnimation("walk_down",walk_down);
			
			
			
			putImage("thrust_left_0",sheet.getSprite(1,21,2,3,-2,0));
			putImage("thrust_left_1",sheet.getSprite(5,21,2,3,-2,0));
			putImage("thrust_left_2",sheet.getSprite(9,21,2,3,-2,0));
			putImage("thrust_left_3",sheet.getSprite(13,21,2,3,-2,0));
			putImage("thrust_left_4",sheet.getSprite(17,21,2,3,-2,0));
			putImage("thrust_left_5",sheet.getSprite(21,21,2,3,-2,0));
			putImage("thrust_left_6",sheet.getSprite(25,21,2,3,-2,0));
			putImage("thrust_left_7",sheet.getSprite(29,21,2,3,-2,0));
			putImage("thrust_left_8",sheet.getSprite(33,21,2,3,-2,0));
			
			putImage("thrust_right_0",sheet.getSprite(1,29,2,3,-2,0));
			putImage("thrust_right_1",sheet.getSprite(5,29,2,3,-2,0));
			putImage("thrust_right_2",sheet.getSprite(9,29,2,3,-2,0));
			putImage("thrust_right_3",sheet.getSprite(13,29,2,3,-2,0));
			putImage("thrust_right_4",sheet.getSprite(17,29,2,3,-2,0));
			putImage("thrust_right_5",sheet.getSprite(21,29,2,3,-2,0));
			putImage("thrust_right_6",sheet.getSprite(25,29,2,3,-2,0));
			putImage("thrust_right_7",sheet.getSprite(29,29,2,3,-2,0));
			putImage("thrust_right_8",sheet.getSprite(33,29,2,3,-2,0));
			
			putImage("thrust_up_0",sheet.getSprite(1,17,2,3,-2,0));
			putImage("thrust_up_1",sheet.getSprite(5,17,2,3,-2,0));
			putImage("thrust_up_2",sheet.getSprite(9,17,2,3,-2,0));
			putImage("thrust_up_3",sheet.getSprite(13,17,2,3,-2,0));
			putImage("thrust_up_4",sheet.getSprite(17,17,2,3,-2,0));
			putImage("thrust_up_5",sheet.getSprite(21,17,2,3,-2,0));
			putImage("thrust_up_6",sheet.getSprite(25,17,2,3,-2,0));
			putImage("thrust_up_7",sheet.getSprite(29,17,2,3,-2,0));
			putImage("thrust_up_8",sheet.getSprite(33,17,2,3,-2,0));
			
			putImage("thrust_down_0",sheet.getSprite(1,25,2,3,-2,0));
			putImage("thrust_down_1",sheet.getSprite(5,25,2,3,-2,0));
			putImage("thrust_down_2",sheet.getSprite(9,25,2,3,-2,0));
			putImage("thrust_down_3",sheet.getSprite(13,25,2,3,-2,0));
			putImage("thrust_down_4",sheet.getSprite(17,25,2,3,-2,0));
			putImage("thrust_down_5",sheet.getSprite(21,25,2,3,-2,0));
			putImage("thrust_down_6",sheet.getSprite(25,25,2,3,-2,0));
			putImage("thrust_down_7",sheet.getSprite(29,25,2,3,-2,0));
			putImage("thrust_down_8",sheet.getSprite(33,25,2,3,-2,0));
			
			AnimationList thrust_left = new AnimationList();
			thrust_left.append(getImage("thrust_left_0"));
			thrust_left.append(getImage("thrust_left_1"));
			thrust_left.append(getImage("thrust_left_2"));
			thrust_left.append(getImage("thrust_left_3"));
			thrust_left.append(getImage("thrust_left_4"));
			thrust_left.append(getImage("thrust_left_5"));
			thrust_left.append(getImage("thrust_left_6"));
			thrust_left.append(getImage("thrust_left_7"));
			thrust_left.append(getImage("thrust_left_8"));			
			putAnimation("thrust_left",thrust_left);
			
			AnimationList thrust_right = new AnimationList();
			thrust_right.append(getImage("thrust_right_0"));
			thrust_right.append(getImage("thrust_right_1"));
			thrust_right.append(getImage("thrust_right_2"));
			thrust_right.append(getImage("thrust_right_3"));
			thrust_right.append(getImage("thrust_right_4"));
			thrust_right.append(getImage("thrust_right_5"));
			thrust_right.append(getImage("thrust_right_6"));
			thrust_right.append(getImage("thrust_right_7"));
			thrust_right.append(getImage("thrust_right_8"));			
			putAnimation("thrust_right",thrust_right);
			
			AnimationList thrust_up = new AnimationList();
			thrust_up.append(getImage("thrust_up_0"));
			thrust_up.append(getImage("thrust_up_1"));
			thrust_up.append(getImage("thrust_up_2"));
			thrust_up.append(getImage("thrust_up_3"));
			thrust_up.append(getImage("thrust_up_4"));
			thrust_up.append(getImage("thrust_up_5"));
			thrust_up.append(getImage("thrust_up_6"));
			thrust_up.append(getImage("thrust_up_7"));
			thrust_up.append(getImage("thrust_up_8"));			
			putAnimation("thrust_up",thrust_up);
			
			AnimationList thrust_down = new AnimationList();
			thrust_down.append(getImage("thrust_down_0"));
			thrust_down.append(getImage("thrust_down_1"));
			thrust_down.append(getImage("thrust_down_2"));
			thrust_down.append(getImage("thrust_down_3"));
			thrust_down.append(getImage("thrust_down_4"));
			thrust_down.append(getImage("thrust_down_5"));
			thrust_down.append(getImage("thrust_down_6"));
			thrust_down.append(getImage("thrust_down_7"));
			thrust_down.append(getImage("thrust_down_8"));			
			putAnimation("thrust_down",thrust_down);
			
			putImage("cast_up_0", sheet.getSprite(1, 1,2,3,-2,0));
			putImage("cast_up_1",sheet.getSprite(5, 1,2,3,-2,0));
			putImage("cast_up_2",sheet.getSprite(9, 1,2,3,-2,0));
			putImage("cast_up_3",sheet.getSprite(13, 1,2,3,-2,0));
			putImage("cast_up_4",sheet.getSprite(17, 1,2,3,-2,0));
			putImage("cast_up_5",sheet.getSprite(21, 1,2,3,-2,0));
			putImage("cast_up_6",sheet.getSprite(25, 1,2,3,-2,0));
			
			putImage("cast_left_0", sheet.getSprite(1,5,2,3,-2,0));
			putImage("cast_left_1",sheet.getSprite(5,5,2,3,-2,0));
			putImage("cast_left_2",sheet.getSprite(9,5,2,3,-2,0));
			putImage("cast_left_3",sheet.getSprite(13,5,2,3,-2,0));
			putImage("cast_left_4",sheet.getSprite(17,5,2,3,-2,0));
			putImage("cast_left_5",sheet.getSprite(21,5,2,3,-2,0));
			putImage("cast_left_6",sheet.getSprite(25,5,2,3,-2,0));
			
			putImage("cast_down_0", sheet.getSprite(1,9,2,3,-2,0));
			putImage("cast_down_1",sheet.getSprite(5,9,2,3,-2,0));
			putImage("cast_down_2",sheet.getSprite(9,9,2,3,-2,0));
			putImage("cast_down_3",sheet.getSprite(13,9,2,3,-2,0));
			putImage("cast_down_4",sheet.getSprite(17,9,2,3,-2,0));
			putImage("cast_down_5",sheet.getSprite(21,9,2,3,-2,0));
			putImage("cast_down_6",sheet.getSprite(25,9,2,3,-2,0));
			
			putImage("cast_right_0", sheet.getSprite(1,13,2,3,-2,0));
			putImage("cast_right_1",sheet.getSprite(5,13,2,3,-2,0));
			putImage("cast_right_2",sheet.getSprite(9,13,2,3,-2,0));
			putImage("cast_right_3",sheet.getSprite(13,13,2,3,-2,0));
			putImage("cast_right_4",sheet.getSprite(17,13,2,3,-2,0));
			putImage("cast_right_5",sheet.getSprite(21,13,2,3,-2,0));
			putImage("cast_right_6",sheet.getSprite(25,13,2,3,-2,0));
			
			AnimationList cast_left = new AnimationList();
			cast_left.append(getImage("cast_left_0"));
			cast_left.append(getImage("cast_left_1"));
			cast_left.append(getImage("cast_left_2"));
			cast_left.append(getImage("cast_left_3"));
			cast_left.append(getImage("cast_left_4"));
			cast_left.append(getImage("cast_left_5"));
			cast_left.append(getImage("cast_left_6"));		
			putAnimation("cast_left",cast_left);
			
			AnimationList cast_right = new AnimationList();
			cast_right.append(getImage("cast_right_0"));
			cast_right.append(getImage("cast_right_1"));
			cast_right.append(getImage("cast_right_2"));
			cast_right.append(getImage("cast_right_3"));
			cast_right.append(getImage("cast_right_4"));
			cast_right.append(getImage("cast_right_5"));
			cast_right.append(getImage("cast_right_6"));		
			putAnimation("cast_right",cast_right);
			
			AnimationList cast_up = new AnimationList();
			cast_up.append(getImage("cast_up_0"));
			cast_up.append(getImage("cast_up_1"));
			cast_up.append(getImage("cast_up_2"));
			cast_up.append(getImage("cast_up_3"));
			cast_up.append(getImage("cast_up_4"));
			cast_up.append(getImage("cast_up_5"));
			cast_up.append(getImage("cast_up_6"));			
			putAnimation("cast_up",cast_up);
			
			AnimationList cast_down = new AnimationList();
			cast_down.append(getImage("cast_down_0"));
			cast_down.append(getImage("cast_down_1"));
			cast_down.append(getImage("cast_down_2"));
			cast_down.append(getImage("cast_down_3"));
			cast_down.append(getImage("cast_down_4"));
			cast_down.append(getImage("cast_down_5"));
			cast_down.append(getImage("cast_down_6"));		
			putAnimation("cast_down",cast_down);
		}
		catch(InvalidSizeException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		
		
	}
	public BufferedImage getImage(String key){
		return imgMap.get(key);
	}
	public void putImage(String key, BufferedImage img){
		imgMap.put(key, img);
	}
	public AnimationList getAnimation(String key){
		return animationMap.get(key);
	}
	public void putAnimation(String key, AnimationList animation){
		animationMap.put(key, animation);
	}
	public Sound getSound(String key){
		return soundMap.get(key);
	}
	public void putSound(String key, Sound sound){
		soundMap.put(key, sound);
	}
	
	
}
