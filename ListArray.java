/* A functional clone of the existing Java ArrayList Utility class. Only some of methods
 * are recreated here.
 * @author Chad Gallati
 * @email cgallati@email.sc.edu
 * @version 2.0 / Last edited 3/19/14
 */
public class ListArray {

	Object data[];
	int current;
	
	/**
	 * Default (no arguments) constructor. Creates a ListArray of size 10;
	 */
	public ListArray(){
		data = new Object[10];
		current = 0;
	}
	
	/**
	 * Constructs a ListArray of a specific size.
	 * @param initialCapacity: initial size of ListArray
	 */
	public ListArray(int initialCapacity){
		data = new Object[initialCapacity];
		current = 0;
	}
	
	/**
	 * "Copy Constructor" that creates a ListArray out of an array.
	 * @param that: an Object array to be copied.
	 */
	public ListArray(Object[] that) {
		this(that.length);
		for(int i = 0; i < that.length; i++) {
			data[i] = that[i];
		}
	}
	
	/**
	 * Bonafide copy constructor. Creates a ListArray from another ListArray.
	 * @param that: a ListArray to be cloned.
	 */
	public ListArray(ListArray that) {
		this(that.size());
		for(int i = 0; i < that.size(); i++) {
			data[i] = that.get(i);
		}
	}
	
	/**
	 * Adds an object to the end of the ListArray. Resizes ListArray if necessary.
	 * @param obj: an Object to be added to the end of the ListArray
	 */
	public void add(Object obj){
		if(current<size()){
			if (data[current]==null){
				data[current]=obj;
				current++;
			}
			else{
				current++;
				add(obj);
			}
		}
		else{
			resize(size()*2);
			data[current]=obj;
			current++;
		}
	}
	
	/**
	 * Adds and object at the specified index. If index is occupied, shifts objects one index up before adding.
	 * @param index: the index of the new Object
	 * @param obj: an Object to be added
	 */
	public void add(int index, Object obj){
		if(index<size()){
			if(data[index]==null){
				data[index]=obj;
			}
			else{
				if(current>=size()){
					resize(index+current);
				}
				for(int i=current; i>index; i--){
					if(i>0){
						data[i] = data[i-1]; 
					}
				}
				data[index]=obj;
				current++;
			}
		}
		else{
			resize(index+10);
			data[index]=obj;
			current++;
		}
	}
	
	/**
	 * Resizes the ListArray. 
	 * @param newSize: the new size.
	 */
	public void resize(int newSize){
		Object[] temp = new Object[newSize];
		for(int i=0; i<size(); i++){
			temp[i] = data[i];
		}
		data = new Object[newSize];
		for(int i=0; i<size(); i++){
			data[i] = temp[i];
		}
	}
	
	
	/**
	 * Removes the Object at the specified index.
	 * @param index: the index of the Object to be removed
	 * @return: the removed Object
	 */
	public Object remove(int index){
		Object o = data[index];
		data[index] = null;
		return o;
	}
	
	/**
	 * Checks if a specific Object is present in the ListArray.
	 * @param obj: the object to be checked.
	 * @return: True if the ListArray contains the Object, False if otherwise
	 */
	public boolean contain(Object obj){
		boolean contains=false;
		for(int i=0; i<size(); i++){
			if(data[i].equals(obj)){
				contains=true;
			}
		}
		return contains;
	}
	
	/**
	 * Returns the Object at the specified index.
	 * @param index: the index to be returned.
	 * @return: the Object in the ListArray at index.
	 */
	public Object get(int index){
		return data[index];
	}
	
	/**
	 * Returns the index of the first appearance of a specific Object.
	 * @param obj: the Object to be searched for
	 * @return: the index of the first appearance of a specific Object. -1, if the Object is not in ListArray
	 */
	public int indexOf(Object obj){
		for(int i = 0; i<size(); i++){
			if(data[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns true if the ListArray is empty.
	 * @return: True if the ListArray is empty, false otherwise.
	 */
	public boolean isEmpty(){
		boolean empty = true;
		for(int i = 0; i<size(); i++){
			System.out.println(i);
			if(!(data[i] == null)){
				empty = false;
			}
		}
		return empty;
	}
	/**
	 * Returns the size of the ListArray.
	 * @return: size of ListArray
	 */
	public int size(){
		return data.length;
	}
	/**
	 * Returns the ListArray as a String.
	 */
	public String toString(){
		String out = "[ ";
		for(int i=0; i<size(); i++){
			if(data[i]!=null){
				out+= data[i]+" ";
			}
		}
		return out + "]";
	}
	
	/**
	 * An equals method designed for testing ListArray objects to see if they are equal.
	 * @param tada: the ListArray to be compared.
	 * @return: True if the ListArrays are equal, false otherwise
	 */
	public boolean equals(ListArray tada){
		boolean equal = true;
		for(int i = 0; i<size(); i++){
			System.out.println(tada.get(i));
			if(!data[i].equals(tada.get(i))){
				equal = false;
			}
		}
		return equal;
	}
	//Testing implementation
	/*
	public static void main(String[] args){
		ListArray a1 = new ListArray();
		a1.add("Stuff");
		a1.add("1.23");
		a1.add("12345");
		a1.add(true);
		System.out.println(a1.toString());
	}*/
	
}
