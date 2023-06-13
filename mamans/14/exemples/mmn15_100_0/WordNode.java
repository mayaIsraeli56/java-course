/**
 * WordNode.java - Represents a single node with a string.
 * Author: iDaN
 * Date: 05/06/2021
 */
public class WordNode {
    // Instance variables
    private String _word;
    private WordNode _next;

    /**
     * Constructs a node with a given word.
     * @param word The word to initialize the node with.
     */
    public WordNode(String word) {
        _word = word;
        _next = null;
    }

    /**
     * Constructs a node with a given word and sets its next to a given node.
     * @param word The word to initialize the node with.
     * @param next The next node to point.
     */
    public WordNode(String word, WordNode next) {
        _word = word;
        _next = next;
    }

    /**
     * Returns the word of the node.
     * @return The word of the node.
     */
    public String getWord() {
        return _word;
    }

    /**
     * Returns the next node which the current node is pointing to.
     * @return The next node.
     */
    public WordNode getNext() {
        return _next;
    }

    /**
     * Receives a word and sets it to the current node.
     * @param word The word to set.
     */
    public void setWord(String word) {
        _word = word;
    }

    /**
     * Receives a node to point next.
     * @param node The next node to set.
     */
    public void setNext(WordNode node) {
        _next = node;
    }

    /**
     * Checks if the given object is instance of WordNode and its word is identical to the current node's word.
     * @param other The other object to check equality with
     * @return true if the word is identical, false otherwise.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean equals(Object other) {
        // instanceof also checks if other is not null
        if (!(other instanceof WordNode))
            return false;
        return getWord().equals(((WordNode) other).getWord());
    }

    /**
     * Returns a string representation of the node (the word).
     * @return The word as a String.
     */
    public String toString() {
        return _word;
    }
}
