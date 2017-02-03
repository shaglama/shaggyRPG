package com.shaglama.shaggyrpg.lists;

public class ListElement<T> {
	private T t;
	private ListElement next;
	private ListElement prev;
	
	public ListElement(T t) {
		set(t);
	}
	
	public T get(){
		return t;
	}
	public void set(T t){
		this.t= t;
	}
	public ListElement<T> next(){
		return next;
	}
	public ListElement<T> prev(){
		return prev;
	}
	public void setNext(ListElement<T> next){
		this.next = next;
	}
	public void setPrev(ListElement<T> prev){
		this.prev = prev;
	}
	
	

}
