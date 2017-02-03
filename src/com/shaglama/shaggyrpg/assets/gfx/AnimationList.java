package com.shaglama.shaggyrpg.assets.gfx;

import java.awt.image.BufferedImage;
import java.util.Collection;
import com.shaglama.shaggyrpg.lists.CircularlyLinkedList;
public class AnimationList {
	private CircularlyLinkedList<BufferedImage> list;
	
	public AnimationList() {
		list = new CircularlyLinkedList<BufferedImage>();
	}
	public AnimationList(Collection<BufferedImage> images){
		list = new CircularlyLinkedList<BufferedImage>(images);
	}
	public int getLength(){
		return list.getLength();
	}
	public BufferedImage getElement(){
		return list.getElement();
	}
	public BufferedImage getElementAt(int index){
		return list.getElementAt(index);
	}
	public boolean hasNext(){
		return list.hasNext();
	}
	public boolean hasPrev(){
		return list.hasPrev();
	}
	public BufferedImage next(){
		return list.next();
	}
	public BufferedImage prev(){
		return list.prev();
	}
	public BufferedImage first(){
		return list.first();
	}
	public BufferedImage last(){
		return list.last();
	}
	public void append(BufferedImage image){
		list.append(image);
	}
	public void append(Collection<BufferedImage> images){
		list.append(images);
	}
	public void insert(BufferedImage image, boolean before){
		list.insert(image, before);
	}
	public void insert(BufferedImage image, boolean before, int position){
		list.insert(image, before,position);
	}
	public void insert(BufferedImage image, boolean before, BufferedImage target){
		list.insert(image, before,target);
	}
	public boolean remove(BufferedImage image){
		return list.remove(image);
	}
	public BufferedImage remove(int index){
		return list.remove(index);
	}
	public int removeAll(BufferedImage image){
		return list.removeAll(image);
	}
	public int find(BufferedImage image){
		return list.find(image);
	}
	public Integer[] findAll(BufferedImage image){
		return list.findAll(image);
	}
	public String toString(){
		return list.toString();
	}
	public BufferedImage[] toArray(){
		return list.toArray(new BufferedImage[getLength()]);
	}

}