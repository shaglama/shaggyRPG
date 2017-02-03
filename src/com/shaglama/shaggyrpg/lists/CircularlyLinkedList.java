package com.shaglama.shaggyrpg.lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CircularlyLinkedList<T> {
	private ListElement<T> first = null;
	private ListElement<T> last = null;
	private ListElement<T> current = null;
	private int length = 0;

	
	public CircularlyLinkedList(){
	}
	public CircularlyLinkedList(Collection<T> elements){
		append(elements);
		current = first;		
	}
	public int getLength(){
		return length;
	}
	public T getElement(){
		if(current != null){
			return current.get();
		} else {
			return null;
		}
	}
	public T getElementAt(int index){
		int current;
		ListElement<T> element;
		if(length > 0 && length > index){
			if(length - index < index){
				element = last;
				current = length -1;
				while(current != index){
					element = element.prev();
					current--;
				}
			} else {
				element = first;
				current = 0;
				while(current != index){
					element = element.next();
					current++;
				}
			}
			return element.get();
		} else {
			return null;
		}
	}
	public T next(){
		if(current != null){
			current = current.next();
			return getElement();
		} else {
			return null;
		}
		
	}
	public T prev(){
		if(current != null){
			current = current.prev();
			return getElement();
		} else {
			return null;
		}
	}
	public T first(){
		if(current != null){
			current = first;
			return getElement();
		} else {
			return null;
		}
	}
	public T last(){
		if(current != null){
			current = last;
			return getElement();
		} else {
			return null;
		}
	}
	public void append(T t){
		ListElement<T> element = new ListElement<T>(t);
		if(length ==0){
			first = element;
			last = element;
			current = element;
			element.setNext(element);
			element.setPrev(element);
		} else {
			element.setPrev(last);
			element.setNext(first);
			last.setNext(element);
			last = element;
			first.setPrev(last);
		}
		length++;
		
	}
	public void append(Collection<T> elements){
		Iterator<T> it;
		if(!elements.isEmpty()){
			it = elements.iterator();
			while(it.hasNext()){
				append((T)it.next());
			}
		}
	}
	public void insert(T t, boolean before){
		ListElement<T> newElement;
		if(current != null){
			newElement = new ListElement<T>(t);
			if(before){
				newElement.setPrev(current.prev());
				newElement.setNext(current);
				current.prev().setNext(newElement);
				current.setPrev(newElement);
				if(current == first){
					first = newElement;
				}
			} else {
				newElement.setPrev(current);
				newElement.setNext(current.next());
				current.next().setPrev(newElement);
				current.setNext(newElement);
				if(current == last){
					last = newElement;
				}
			}
			length++;
		} else {
			append(t);
		}
		
	}
	public void insert(T t, boolean before, int index){
		ListElement<T> newElement;
		ListElement<T> target;
		int current=0;
		
		if(length > 0 && length > index){
			newElement = new ListElement<T>(t);
			if(length - index < index){
				current = length -1;
				target = last;
				while(current != index){
					target = target.prev();
					current--;
				}
				
			} else {
				current = 0;
				target = first;
				while(current != index){
					target = target.next();
					current++;
				}
			}
			if(before){
				newElement.setPrev(target.prev());
				newElement.setNext(target);
				target.prev().setNext(newElement);
				target.setPrev(newElement);
				if(target == first){
					first = newElement;
				}
			} else {
				newElement.setPrev(target);
				newElement.setNext(target.next());
				target.next().setPrev(newElement);
				target.setNext(newElement);
				if(target == last){
					last = newElement;
				}
			}
			length++;
		} else {
			append(t);
		}
	}
	public void insert(T t, boolean before, T position){
		ListElement<T> newElement;// = new ListElement<T>(t);
		ListElement<T> target = findElement(position);
		if(target == null){
			append(t);
		} else {
			newElement = new ListElement<T>(t);
			if(before){
				newElement.setPrev(target.prev());
				newElement.setNext(target);
				target.prev().setNext(newElement);
				target.setPrev(newElement);
				if(target == first){
					first = newElement;
				}
			} else {
				newElement.setPrev(target);
				newElement.setNext(target.next());
				target.next().setPrev(newElement);
				target.setNext(newElement);
				if(target == last){
					last = newElement;
				}
			}
			length++;
		}
	}
	public T remove(int index){
		ListElement<T> target;
		int current;
		if(length > 0 && length > index){
			if(length - index < index){
				current = length -1;
				target = last;
				while(index != current){
					target = target.prev();
					current--;
				}
			} else {
				current = 0;
				target = first;
				while(index != current){
					target = target.next();
					current++;
				}
			}
			if(target == first && target == last){
				first = null;
				last = null;
				this.current = null;
				return target.get();
				
			} else {
				target.prev().setNext(target.next());
				target.next().setPrev(target.prev());
				if(target == first){
					first = target.next();
					
				}
				if(target == last){
					last = target.prev();
				}
				if(target == this.current){
					this.current = target.next();
				}
			
				length--;
				return target.get();
			}
		} else {
			return null;
		}
		
	}
	public boolean remove(T t){
		ListElement<T> element = findElement(t);
		if(element != null){
			if(element == first && element == last){
				first = null;
				last = null;
				current = null;
			} else if(element == first){
				first = element.next();
				first.setPrev(last);
				last.setNext(first);
			} else if(element == last){
				last = element.prev();
				last.setNext(first);
				first.setPrev(last);
				
			} else {
				element.prev().setNext(element.next());
				element.next().setPrev(element.prev());
			}
			if(element == current){
				current = element.next();
			}
			length--;
			return true;
		} else {
			return false;
		}
		
	}
	public int removeAll(T t){
		int numRemoved = 0;
		boolean removed = true;
		boolean done = false;
		
		while(!done){
			removed = remove(t);
			if(removed){
				numRemoved++;
			} else {
				done = true;
			}
		}
		return numRemoved;
	}
	public int find(T target){
		ListElement<T> element;
		int index = 0;
		if(length > 0){
			element = first;
			do {
				if(element.get() == target){
					return index;
				} else {
					index++;
					element = element.next();
				}
			} while(element != first);
			return -1;
		} else {
			return -1;
		}
	}
	public Integer[] findAll(T target){
		ArrayList<Integer> results = new ArrayList<Integer>();
		int index = 0;
		ListElement<T> element = first;
		if(length > 0){
			do {
				if(element.get() == target){
					results.add(index);
				}
				index ++;
				element = element.next();
			} while (element != first);
		}
		
		return results.toArray(new Integer[results.size()]);
		
	}
	public boolean hasNext(){
		if(length > 0 && current != last){
			return true;
		} else {
			return false;
		}
	}
	public boolean hasPrev(){
		if(length > 0 && current != first){
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString(){
		boolean firstElement = true;
		ListElement<T> element;
		String out = "";
		if(length > 0){
			element = first;
			do {
				if(!firstElement){
					out += " , ";
				}
				out += element.get().toString();
				firstElement = false;
				element = element.next();
			} while (element != first);
		}
		return out;
	}
	public T[] toArray(T[] outArray){
		if(outArray.length < length){
			outArray = Arrays.copyOf(outArray, length);
		}
		int i = 0;
		ListElement<T> element = first;
		if(length > 0){
			do {
				outArray[i] = element.get();
				element = element.next();
				i++;
			} while(element != first);
		} 
		return outArray;
		
	}
	private ListElement<T> findElement(T target){
		ListElement<T> element;
		if(length > 0){
			element = first;
			do {
				if(element.get() == target){
					return element;
				} else {
					element = element.next();
				}
			} while(element != first);
			return null;
		} else {
			return null;
		}
	}

}
