package com.shaglama.shaggyrpg.display.viewPort;

import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.entity.Entity;
import com.shaglama.shaggyrpg.location.Location;
import com.shaglama.shaggyrpg.location.position.Position;
import com.shaglama.shaggyrpg.maps.GameMap;

public class ViewPort {
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	private static final int DEFAULT_DEPTH = 1;
	private static final int DEFAULT_X =  0;
	private static final int DEFAULT_Y = 0;
	private static final int DEFAULT_Z = 0;
	private static final String DEFAULT_AREA = "World";
	private GameMap map;
	private Dimensions dimensions;
	private Location location;
	
	public ViewPort(GameMap map) {
		this(	map,
				new Dimensions(DEFAULT_WIDTH,DEFAULT_HEIGHT,DEFAULT_DEPTH), 
				new Location(DEFAULT_AREA,DEFAULT_X, DEFAULT_Y, DEFAULT_Z));
	}
	public ViewPort(GameMap map, Dimensions dimensions){
		this(	map,
				dimensions,
				new Location(DEFAULT_AREA,DEFAULT_X, DEFAULT_Y, DEFAULT_Z));
	}
	public ViewPort(GameMap map, Location location){
		this(	map,
				new Dimensions(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_DEPTH),
				location);
	}
	public ViewPort(GameMap map, Dimensions dimensions, Location location){
		setMap(map);
		setDimensions(dimensions);
		setLocation(location);
	}
	public GameMap getMap(){
		return map;
	}
	public boolean setMap(GameMap map){
		this.map = map;
		return true;
	}
	
	public Dimensions getDimensions(){
		return dimensions;
	}
	public boolean setDimensions(Dimensions dimensions){
		this.dimensions = dimensions;
		return true;
	}
	public Location getLocation(){
		return location;
	}
	public boolean setLocation(Location location){
		this.location= location;
		return true;
	}
	
	public boolean isInViewPort(Entity entity){
		Dimensions dim = entity.getDimensions();
		Position loc = entity.getPosition();
		if((loc.getX()+dim.getWidth() >= location.getX()) 
				&& (loc.getX() <= location.getX() + dimensions.getWidth())
				&& (loc.getY() + dim.getHeight() >= location.getY())
				&& (loc.getY() <= location.getY() + dimensions.getHeight()) ) {
			
			return true;
		} else {
			return false;
		}
		
	}
	public double moveLeft(double distance){
		double x = location.getX();
		if(x == 0){
			return 0;
		} else {
			if(x - distance < 0){
				location.setX(0);
				return x;
			} else {
				location.setX(x - distance);
				return distance;
			}
		}
	}
	public double moveRight(double distance){
		double rightEdgePort = location.getX() + dimensions.getWidth();
		double rightEdgeMap = map.getDimensions().getWidth();
		if( rightEdgePort == rightEdgeMap){
			return 0;
		} else {
			if(rightEdgePort + distance > rightEdgeMap){
				location.setX(rightEdgeMap - dimensions.getWidth());
				return rightEdgeMap - rightEdgePort;
			} else {
				location.setX(location.getX() + distance);
				return distance;
			}
		}
	}
	public double moveUp(double distance){
		double y = location.getY();
		if(y == 0){
			return 0;
		} else {
			if(y - distance < 0){
				location.setY(0);
				return y;
			} else {
				location.setY(y - distance);
				return distance;
			}
		}
	}
	public double moveDown(double distance){
		double bottomEdgePort = location.getY() + dimensions.getHeight();
		double bottomEdgeMap = map.getDimensions().getHeight();
		if( bottomEdgePort == bottomEdgeMap){
			return 0;
		} else {
			if(bottomEdgePort + distance > bottomEdgeMap){
				location.setY(bottomEdgeMap - dimensions.getHeight());
				return bottomEdgeMap - bottomEdgePort;
			} else {
				location.setY(location.getY() + distance);
				return distance;
			}
		}
	}
	

}
