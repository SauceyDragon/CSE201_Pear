import java.util.NoSuchElementException;

public class LinkedList {
	
	private Node head;
	private int size;	
	
	/*
	 * Creates an empty list.
	 */
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	/*
	 * Returns a space-separated list of the elements in the list.
	 * If the list contains no elements, return an empty string ""
	 */
	public String toString() {
		String result = "";
		Node curr = head;
		while(curr != null) {
			result += curr.data + " ";
			curr = curr.next;
		}
		return result;
	}
	
	/**
	 * Removes an element from a particular location. If the location is valid,
	 * return the word that is removed. If the location is not valid, throw an
	 * OutOfBoundsException.
	 * @param index the index of the word to be removed
	 * @return the word at the specified index
	 * @throws IndexOutOfBoundsException if < 0 or index >= size
	 */
	public String remove(int index) {
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		String result ="";
		if(index == size - 1) {
			result = head.data;
			head = head.next;
		}
		else {
			Node temp = head;
			int count = 0;
			while(count != (size - index)-2) {
				temp = temp.next;
				count++;
			}
			result = temp.next.data;
			temp.next = temp.next.next;
			size--;
		}
		return result;
	}
	/*
	 * Returns the first item in the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public String getFirst() {
		return head.data;
	}
	
	/*
	 * Returns the last item in the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public String getLast() {
		String result = null;
		if(head == null)
			throw new NoSuchElementException();
		if(head.next == null) {
			result = head.data;
		}
		else {
			Node curr = head;
			while(curr.next != null) 
				curr = curr.next;
			result = curr.data;
		}

		return result;
	}
	
	/*
	 * Returns the item at the specified index. If the index
	 * is not valid, throw an IndexOutOfBoundsException.
	 */
	public String getAt(int index) {
		if(index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		String result = null;
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		result = curr.data;
		return result;
	}
	
	/*
	 * Inserts an item at the beginning of the list.
	 */
	public void insertFirst(String str) {
		Node temp = new Node(str);
		temp.next = head;
		head = temp;
		size++;
	}
	
	/*
	 * Inserts an item at the end of the list.
	 */
	public void insertLast(String str) {
		Node temp = new Node(str);
		if(head == null)
			head = temp;
		else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = temp;	
		}
		size++;
	}
	
	/*
	 * Removes and returns the first element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public String removeFirst() {
		if(head == null)
			throw new NoSuchElementException();
		String result = head.data;
		head = head.next;
		size--;
		return result;
	}
	
	/*
	 * Removes and returns the last element from the list.  If the 
	 * list is empty, throw a NoSuchElementException.
	 */
	public String removeLast() {
		String result = null;
		if(head == null)
			throw new NoSuchElementException();
		if(head.next == null) {
			result = head.data;
			head = null;
		}
		else {
			Node curr = head;
			while(curr.next.next != null) 
				curr = curr.next;
			result = curr.next.data;
			curr.next = null;
		}
		size--;
		return result;
	}
	
	/*
	 * Returns the index of the first occurrence of the specified value,
	 * or -1 if the value is not in the list.
	 */
	public int indexOf(String value) {
		int result = -1;
		Node curr = head;
		int currIndex = 0; 
		while(curr != null) {
			if(curr.data == value) {
				result = currIndex;
			}
			curr = curr.next;
			currIndex++;
		}
		return result;
	}
	
	/*
	 * Returns the number of elements in the list.
	 */
	public int getSize() {
		return size;
	}
	
	/*
	 * Returns true if the list is empty, and false otherwise.
	 */
	public boolean isEmpty() {
		boolean ans = false;
		if(head == null)
			ans = true;
		return ans;
	}
	
	
	// A private Node class.  By making it an inner class, 
	// the outer class can access it easily, but the client cannot.	
	private class Node {
		private String data;
		private Node next;

		// Constructs a new node with the specified data
		private Node(String data) {
			this.data = data;
			this.next = null;
		}
	}
}
