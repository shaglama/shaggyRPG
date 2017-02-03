package com.shaglama.shaggyrpg.assets.gfx;

import java.awt.image.BufferedImage;

import com.shaglama.shaggyrpg.exceptions.InvalidSizeException;

public class SpriteSheet {
	//Members
	private static final int DEFAULT_ROW_SIZE = 32;
	private static final int DEFAULT_COL_SIZE = 32;
	private BufferedImage sheet;
	private int rowSize;
	private int colSize;
	
	//Constructor
	public SpriteSheet(BufferedImage sheet) throws InvalidSizeException {
		this(sheet,DEFAULT_COL_SIZE,DEFAULT_ROW_SIZE);		
	}
	
	public SpriteSheet(BufferedImage sheet,	int colSize,int rowSize) throws InvalidSizeException {
		this.sheet = sheet;
		if(!setRowSize(rowSize)){//invalid value for rowSize
			throw new InvalidSizeException("invalid value for rowSize. Size must be 1 or greater");
		}
		if(!setColumnSize(colSize)){//invalid value for colSize
			throw new InvalidSizeException("invalid value for colSize. Size must be 1 or greater");
		}	
	}
	
	//methods
	public int getRowSize(){
		return rowSize;
	}
	public boolean setRowSize(int size){
		if(size >= 1){
			this.rowSize = size;
			return true;
		} else {
			return false;
		}
	}
	public int getColumnSize(){
		return colSize;
	}
	public boolean setColumnSize(int size){
		if(size >= 1){
			this.colSize = size;
			return true;
		} else {
			return false;
		}
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	public BufferedImage getSprite(int col, int row){
		return getSprite(col,row,1,1);
	}
	
	public BufferedImage getSprite(int col, int row, int numCols, int numRows){
		return getSprite(col, row,numCols,numRows,0,0);
		
	}
	public BufferedImage getSprite(int col, int row, int numCols, int numRows, int verticalOffset, int horizontalOffset){
		int x,
			y,
			width,
			height;
	
		x = (col * colSize) + horizontalOffset;
		y =( row * rowSize )+ verticalOffset;
		width = numCols * colSize;
		height = numRows * rowSize;
	
		return crop(x,y,width,height);
	}
	

}
