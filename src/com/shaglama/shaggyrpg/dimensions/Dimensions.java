package com.shaglama.shaggyrpg.dimensions;

public class Dimensions {
	private Dimension width;
	private Dimension height;
	private Dimension depth;
	
	public Dimensions() {
		this(1,1,1);
	}
	
	public Dimensions(int width, int height, int depth) throws IllegalArgumentException {
			this.width = new Dimension(width);
			this.height = new Dimension(height);
			this.depth = new Dimension(depth);
	}
	
	public int getWidth(){
		return width.getSize();
	}
	
	public boolean setWidth(int width){
		return this.width.setSize(width);
	}
	
	public int getHeight(){
		return height.getSize();
	}
	
	public boolean setHeight(int height){
		return this.height.setSize(height);
	}
	
	public int getDepth(){
		return depth.getSize();
	}
	
	public boolean setDepth(int depth){
		return this.depth.setSize(depth);
	}
	
	public int[] getDimensions(){
		return  new int[]{width.getSize(),height.getSize(),depth.getSize()};
	}
	
	public boolean[] setDimensions(int width, int height, int depth){
		return new boolean[] { this.width.setSize(width), this.height.setSize(height), this.depth.setSize(depth) };
	}

}
