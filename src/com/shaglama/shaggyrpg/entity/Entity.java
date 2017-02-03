package com.shaglama.shaggyrpg.entity;

import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.location.Location;
import com.shaglama.shaggyrpg.location.position.Position;

public class Entity {
	private static final String DEFAULT_ID = "ENTITY";
	private static final String DEFAULT_AREA = "WORLD";
	private static final double DEFAULT_X = 0;
	private static final double DEFAULT_Y = 0;
	private static final double DEFAULT_Z = 0;
	private static final double DEFAULT_YAW = 0;
	private static final double DEFAULT_ROLL = 0;
	private static final double DEFAULT_PITCH = 0;
	private static final int DEFAULT_WIDTH = 1;
	private static final int DEFAULT_HEIGHT = 1;
	private static final int DEFAULT_DEPTH = 1;
	private static int NEXT_DEFAULT = 0;
	protected Position position;
	protected Dimensions dimensions;
	protected String id;
	
	//Constructors ------------------------------------------------------------
	public Entity() {
		setId(createDefaultId());
		setPosition(createDefaultPosition());
		setDimensions(createDefaultDimensions());
	}
	
	public Entity(String id){
		setId(id);
		setPosition(createDefaultPosition());
		setDimensions(createDefaultDimensions());
	}
	public Entity(Position position){
		setId(createDefaultId());
		setPosition(position);
		setDimensions(createDefaultDimensions());
	}
	public Entity(Dimensions dimensions){
		setId(createDefaultId());
		setPosition(createDefaultPosition());
		setDimensions(dimensions);
	}
	public Entity(String id, Position position){
		setId(id);
		setPosition(position);
		setDimensions(createDefaultDimensions());
	}
	public Entity(String id, Dimensions dimensions){
		setId(id);
		setPosition(createDefaultPosition());
		setDimensions(dimensions);
	}
	public Entity(Position position, Dimensions dimensions){
		setId(createDefaultId());
		setPosition(position);
		setDimensions(dimensions);
	}
	public Entity(String id, Position position, Dimensions dimensions){
		setId(id);
		setPosition(position);
		setDimensions(dimensions);
	}
	
	//Id Methods
	public String getId(){
		return id;
	}
	public boolean setId(String id){
		this.id = id;
		return true;
		
	}
	private String createDefaultId(){
		String idString = DEFAULT_ID + NEXT_DEFAULT;
		NEXT_DEFAULT++;
		return idString;
	}
	
	//Location Methods
	public Position getPosition(){
		return position;
	}
	public boolean setPosition(Position position){
		this.position = position;
		return true;
	}
	public boolean setPosition(String area, double x, double y, double z,double yaw,double roll,double pitch){
		return setPosition(new Position(area,x,y,z, yaw, roll, pitch));
	}
	
	public Position createDefaultPosition(){
		return new Position(DEFAULT_AREA,DEFAULT_X,DEFAULT_Y,
				DEFAULT_Z,DEFAULT_YAW,DEFAULT_ROLL,DEFAULT_PITCH);
	}
	public double[] getCoordinates(){
		return new double[] { position.getX(), position.getY() };
	}
	public boolean[] setCoordinates(double x, double y, double z){
		return new boolean[] { position.setX(x), position.setY(y), position.setZ(z) };
	}
	public boolean setArea(String area){
		return position.setArea(area);
	}
	
	
	//Dimensions Methods
	public Dimensions getDimensions(){
		return dimensions;
	}
	public boolean setDimensions(Dimensions dimensions){
		this.dimensions = dimensions;
		return true;
	}
	public boolean setDimensions(int width, int height, int depth){
		return setDimensions(new Dimensions(width,height,depth));
	}
	public Dimensions createDefaultDimensions(){
		return new Dimensions(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_DEPTH);
	}
	public int[] getSize(){
		return dimensions.getDimensions();
	}
	public boolean[] setSize(int width, int height, int depth){
		return new boolean[] { dimensions.setWidth(width), dimensions.setHeight(height), dimensions.setDepth(depth) };
	}
}
