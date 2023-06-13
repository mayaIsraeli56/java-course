import java.util.Scanner;

/**
 * This class represents a two-way linked-list of type int, arranged in ascending order. 
 * @author Etamar Cohen 
 * ID : 209451418
 * Date 03.06.19
 * Version 1.0
 */
public class IntListTwo {
	
	private IntNodeTwo _head, _tail;

	/**
     * Constructs and initializes an empty two-way linked-list (head and tail are set to null)
     * the time efficiency is O(1). the space efficiency is O(1).
     */
	public IntListTwo() {
		_head = null;
		_tail = null;
	}
	
	/**
     * Constructs and initializes a two-way linked-list. 
     * head and tail are set by a given nodes.
     * the time efficiency is O(1). the space efficiency is O(1).
     * @param h the head node.
     * @param t the tail node.
     */
	public IntListTwo(IntNodeTwo h, IntNodeTwo t) {
		_head = h;
		_tail = t;
	}
	
	/**
     * creates and adds to the list a new node with a given value
	 * the time efficiency is O(n). the space efficiency is O(1).
     * @param num value to set the new node
     */
	public void addNumber(int num) {
		IntNodeTwo nodeToAdd = new IntNodeTwo(num), temp = _head;
		boolean flag = false;
		
		//check if the list is empty, if so, set the new node as the head and tail.
		if(_head == null) {	
			_head = nodeToAdd;
			_tail = _head;
		}
		else {
			//check if the new node is smallest, if so, set it as the head and fix the link
			if(num <= _head.getNum()) {
				nodeToAdd.setNext(_head);
				_head.setPrev(nodeToAdd);
				_head = nodeToAdd;
			}
			else {
				while(temp.getNext() != null && !flag) {
					//check if the next node should be the new node
					if(num <= temp.getNext().getNum()) {
						nodeToAdd.setPrev(temp);
						nodeToAdd.setNext(temp.getNext());
						temp.setNext(nodeToAdd);
						temp.getNext().setPrev(nodeToAdd);
						flag = true;
					}
					else {
						//keep moving on
						temp = temp.getNext();
					}
				}
				if(!flag) {
					//if the new node is biggest put it in the end.
					temp.setNext(nodeToAdd);
					nodeToAdd.setPrev(temp);
					_tail = nodeToAdd;
				}
			}
		}
	}
	
	/**
     * search and removes a node with a given value from the list. if there isn't such node does nothing.
	 * the time efficiency is O(n). the space efficiency is O(1).
     * @param num value to search in list
     */
	public void removeNumber(int num) {
		IntNodeTwo temp = _head;
		boolean flag = false;
		//check if the list isn't empty
		if(_head != null) {
			//if the head is the node to remove
			if(_head.getNum() == num) {
				//if there's just one node in the list
				if(_tail == _head) {
					_tail = null;
					_head = null;
				}
				else {
					//remove the head and fix the link
					_head = _head.getNext();
					_head.setPrev(null);
				}
			}
			else {
				//search for the node and remove it if found
				while(temp.getNext() != null && !flag) {
					if(temp.getNext().getNum() == num) {
						temp.setNext(temp.getNext().getNext());
						if(temp.getNext() != null) {
							temp.getNext().setPrev(temp);
						}
						else {
							_tail = temp;
						}
						flag = true;
					}
					else {
						temp = temp.getNext();
					}
				}
			}
		}
	}
	
	/**
	 * Reads numbers from the user and adds them to the list. stop's when the user enters '-9999'.
	 * the time efficiency is O(nlogn). the space efficiency is O(n).
	 */
	public void readToList() {
		int userInput;
		Scanner scan = new Scanner(System.in);
		userInput = scan.nextInt();
		boolean isNew = (userInput != -9999);
		while(userInput != -9999) {
			this.addToEnd(userInput);
			userInput = scan.nextInt();
		}
		if(isNew) {
			_head = mergeSort(this._head);
			IntNodeTwo temp = _head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			_tail = temp;
		}
		
	}
	
	/**
	 * adds a number to the end of the list
	 * @param num the number to add
	 */
	private void addToEnd(int num) {
		if(_head == null) {
			_head = new IntNodeTwo(num);
			_tail = _head;
		}
		else if(this._head == this._tail) {
			_tail = new IntNodeTwo(num, null, _head);
			_head.setNext(_tail);
		}
		else {
			_tail.setNext(new IntNodeTwo(num, null, _tail));
			_tail = _tail.getNext();
		}
	}
	
	/**
	 * merges two sorted list that starts with a given first nodes
	 * @param list1 the first node in the first list
	 * @param list2 the first node in the second list
	 * @return the first node in the combined list
	 */
	private static IntNodeTwo merge(IntNodeTwo list1, IntNodeTwo list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		if(list1.getNum() < list2.getNum()) {
			list1.setNext(merge(list1.getNext(), list2));
			if(list1.getNext() != null) {
				list1.getNext().setPrev(list1);
			}
			return list1;
		}
		else {
			list2.setNext(merge(list1, list2.getNext()));
			if(list2.getNext() != null) {
				list2.getNext().setPrev(list2);
			}
			return list2;
		}
	}
	
	/**
	 * splits a given list to two.
	 * @param node the first node in the list
	 * @return the first node in the second list
	 */
	private static IntNodeTwo split(IntNodeTwo node) {
		if(node == null || node.getNext() == null) {
			return null;
		}
		IntNodeTwo list2 = node.getNext();
		node.setNext(list2.getNext());
		if(node.getNext() != null) {
			node.getNext().setPrev(node);
		}
		list2.setNext(split(list2.getNext()));
		if(list2.getNext() != null) {
			list2.getNext().setPrev(list2);
		}
		return list2;
	}
	
	/**
	 * sorts list that stars with a given node.
	 * @param node the first node in the list
	 * @return the first node in the sorted list
	 */
	private static IntNodeTwo mergeSort(IntNodeTwo node) {
		if(node == null || node.getNext() == null) {
			return node;
		}
		IntNodeTwo list2 = split(node);
		list2.setPrev(null);
		node = mergeSort(node);
		list2 = mergeSort(list2);
		
		return merge(node, list2);
	}
	
	/**
     * Returns a string representation of this list object.
     * the time efficiency is O(n). the space efficiency is O(n).
     * @return string representation of the Two-Way Linked-List
     */
	public String toString() {
		String retValue = "{";
		IntNodeTwo temp = _head;
		
		if(temp != null) {
			retValue += temp.getNum();
			temp = temp.getNext();
			while(temp != null) {
				retValue += ", " + temp.getNum();
				temp = temp.getNext();
			}
		}
		retValue += "}";
		return retValue;
	}
	
	/**
     * Returns the length of the list.
     * the time efficiency is O(n). the space efficiency is O(1).
     * @return length of list
     */
	public int length() {
		int retValue = 0;
		IntNodeTwo temp = _head;
		
		while(temp != null) {
			retValue++;
			temp = temp.getNext();
		}
		
		return retValue;
	}
	
	/**
     * Returns the sum of numbers in the list.
     * the time efficiency is O(n). the space efficiency is O(1).
     * @return sum of numbers in the list.
     */
	public int sum() {
		int retValue = 0;
		IntNodeTwo temp = _head;
		while(temp != null) {
			retValue += temp.getNum();
			temp = temp.getNext();
		}
		return retValue;
	}
	
	/**
	 * Returns number of the biggest sequence the list with even sum.
	 * The time efficiency is O(n). the space efficiency is O(1).
	 * @return number of the biggest sequence with odd sum
	 */
	public int maxLength() {
		IntNodeTwo temp = _head;
		boolean oddFound = false;
		int firstOddIndex = 0, numOfOdds = 0, lastOddIndex = 0, listLength = this.length();
		//check how much odd numbers there is in the array and where is the first one
		for(int i = 0; i < listLength; i++) {
			if(temp.getNum() % 2 != 0) {
				if(!oddFound) {
					oddFound = true;
					firstOddIndex = i;
				}
				numOfOdds++;
				lastOddIndex = i;
			}
			temp = temp.getNext();
		}
		
		//if no odd number is found or num of odds is even than the sum of the entire list is even.
		if(!oddFound || numOfOdds % 2 == 0) {
			return listLength;
		}
		
		/*
		 * because there is odd number of odd numbers, we need to take the higher sequence:
		 * the first sequence starts at 0 to the last odd number (not included).
		 * the second starts at the end of the array and stops at the first odd number (not included). 
		 */
		return (lastOddIndex > (listLength - firstOddIndex - 1)) ? lastOddIndex : (listLength - firstOddIndex - 1);
	}
	
	/**
	 * Returns whether or not there's a sub-linked-list with a given average
	 * The time efficiency is O(n). the space efficiency is O(1).
	 * @return number of the biggest sequence with odd sum
	 */
	public boolean isAverage(double num) {
		IntNodeTwo tempHead = _head, tempTail = _tail;
		int listLength = this.length(), listSum = this.sum();
		double tempAvg;
		
		if(_head == null) {
			return false;
		}
		//there's only one node
		if(tempHead == tempTail && ((double) listSum) == num) {
			return true;
		}
		while(tempHead != null && tempTail != null && listLength != 0) {
			tempAvg = ((double) listSum) / listLength;
			if(tempAvg == num) {
				return true;
			}
			if(tempAvg < num) {
				//the average is less than num so we need to remove a node from the left so the average will get bigger
				listSum -= tempHead.getNum();
				listLength--;
				tempHead = tempHead.getNext();
			}
			else {
				//the average is more than num so we need to remove a node from the right so the average will be less
				listSum -= tempTail.getNum();
				listLength--;
				tempTail = tempTail.getPrev();
			}
		}
		return false;
	}

}
