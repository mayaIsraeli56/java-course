/**
 * This class represents a node in a two-way linked-list of type int. 
 * @author Etamar Cohen 
 * ID : 209451418
 * Date 03.06.19
 * Version 1.0
 */
public class IntNodeTwo {
	
	private int _num;
	private IntNodeTwo _next, _prev;
	
	/**
     * Constructs and initializes a node with a given int value. 
     * next and prev are set to null.
     * @param n value to set the node.
     */
	public IntNodeTwo(int n) {
		_num = n;
		_next = null;
		_prev = null;
	}
	
	/**
     * Constructs and initializes a node with a given int value. 
     * next and prev are set to the given nodes.
     * @param num value to set the node.
     * @param n the next node.
     * @param p the previous node.
     */
	public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p) {
		_num = num;
		_next = n;
		_prev = p;
	}
	
	/**
     * returns the value the node keeps 
     * @return the node value
     */
	public int getNum() { 
		return _num;
	}
	
	/**
     * returns the next node 
     * @return the next node
     */
	public IntNodeTwo getNext() {
		return _next;
	}
	
	/**
     * returns the previous node 
     * @return the previous node
     */
	public IntNodeTwo getPrev() {
		return _prev;
	}
	
	/**
     * Sets the value the node keeps to a given value
     * @param n value to set the node
     */
	public void setNum (int n) {
		_num = n; 
	}
	
	/**
     * Sets the next node to a given node
     * @param node the next node
     */
	public void setNext (IntNodeTwo node) {
		_next = node; 
	}
	
	/**
     * Sets the previous node to a given node
     * @param node the previous node
     */
	public void setPrev (IntNodeTwo node) {
		_prev = node;
	}
}
