package com.shaglama.shaggyrpg.maps;

import java.util.ArrayList;

import com.shaglama.shaggyrpg.dimensions.Dimensions;
import com.shaglama.shaggyrpg.entity.Entity;

public class Map {
	private Dimensions dimensions;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	public Map() {
		setDimensions(new Dimensions());
	}
	public Map(Dimensions dimensions){
		setDimensions(dimensions);
	}
	public Map(Dimensions dimensions, Entity[] entities){
		setDimensions(dimensions);
		setEntities(entities);
	}
	public Dimensions getDimensions(){
		return dimensions;
	}
	public boolean setDimensions(Dimensions dimensions){
		this.dimensions = dimensions;
		return true;
	}
	public Entity[] getEntities(){
		Entity[] ents = new Entity[entities.size()];
		return entities.toArray(ents);
	}
	public boolean setEntities(Entity[] entities){
		this.entities = new ArrayList<Entity>();
		int limit = entities.length;
		for(int i = 0; i < limit; i++){
			this.entities.add(entities[i]);
		}
		return true;
	}
	public boolean addEntitiy(Entity entity){
		if(! this.entities.contains(entity)){
			entities.add(entity);
			return true;
		} else {
			return false;
		}
	}
	public boolean removeEntity(Entity entity){
		return this.entities.remove(entity);
	}
}
