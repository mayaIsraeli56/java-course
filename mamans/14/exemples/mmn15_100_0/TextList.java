/**
 * TextList.java - Represents a lexicographically sorted list of words.
 * Author: iDaN
 * Date: 05/06/2021
 */
public class TextList {
    private WordNode _head;

    /**
     * Initializing an empty list.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public TextList() {
        _head = null;
    }

    /**
     * Constructs the list with a given text and sorting it.
     * @param text The text to initialize the list with.
     *
     * Time complexity: O(nlogn * S). (because we use mergesort and String.compareTo)
     * Space complexity: O(n).
     *              S is the length of the longest word in the text.
     *              n is the amount of words.
     */
    public TextList(String text) {
        this();
        if (text.length() == 0)
            return;

        // At first, adding each word to the list (without sorting)
        int i = 0, nextSpaceIdx = text.indexOf(' ', i);
        while (nextSpaceIdx != -1) {
            String word = text.substring(i, nextSpaceIdx);
            if (word.length() > 0)
                addToHead(new WordNode(word));

            i = nextSpaceIdx + 1;
            if (i == text.length())
                break;
            nextSpaceIdx = text.indexOf(' ', i);
        }

        // last word
        String last = text.substring(i);
        if (last.length() > 0)
            addToHead(new WordNode(last));

        // sorting the list
        _head = mergeSort(_head);
    }

    /**
     * Receives a word and adds it to the list.
     * @param word The given word to add.
     * Time complexity: O(n*S). S is the length of the word (because of the method String.compareTo).
     * Space complexity: O(1).
     */
    public void addToData(String word) {
        if (word.length() == 0)
            return;
        // if the list is empty or the given word is lexicographically smaller than the first word, we set it as the first word.
        if (isEmpty() || word.compareTo(_head.getWord()) <= 0) {
            addToHead(new WordNode(word));
            return;
        }

        WordNode prev = _head, current = _head.getNext();
        while (current != null && word.compareTo(current.getWord()) > 0) {
            prev = current;
            current = current.getNext();
        }

        // here, current is null or its word "greater" (lexicographically) than the given word
        // so the given word should be put between prev and current.
        WordNode newWord = new WordNode(word, current);
        prev.setNext(newWord);
    }

    /**
     * Counts the number of words in the list.
     * @return The number of words in the list.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int howManyWords() {
        if (isEmpty())
            return 0;

        int count = 0;
        WordNode node = _head;

        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    /**
     * Counts the number of distinct words in the list.
     * @return The amount of distinct words in the list.
     *
     * Time complexity: O(n*S) . S it the length of the longest word (because of the method String.equals)
     * Space complexity: O(1)
     */
    public int howManyDifferentWords() {
        if (isEmpty())
            return 0;

        WordNode prev = null, current = _head;
        int count = 0;

        while (current != null) {
            // The list is sorted, so if current word is different we add 1 to the count.
            if (!current.equals(prev))
                count++;

            prev = current;
            current = current.getNext();
        }
        return count;
    }

    /**
     * Finds the most frequent word in the list.
     * @return The most frequent word in the list.
     *
     * Time complexity: O(n*S) . S it the length of the longest word (because of the method String.equals)
     * Space complexity: O(1)
     */
    public String mostFrequentWord() {
        if (isEmpty())
            return "";
        if (_head.getNext() == null)
            return _head.getWord();

        WordNode prev = _head, current = _head.getNext();
        int count = 1, max = 1;
        String mostFreq = _head.getWord();

        while (current != null) {
            // if the current word is different, checking if it's more frequent and resets the count.
            if (!prev.equals(current)) {
                if (count > max) {
                    max = count;
                    mostFreq = prev.getWord();
                }
                count = 0;
            }
            count++;
            prev = current;
            current = current.getNext();
        }

        if (count > max)
            return prev.getWord();
        return mostFreq;
    }

    /**
     * Calculates the number of words starting with a given letter.
     * @param letter The letter to count the words starting with it.
     * @return The amount of words starting with the letter.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int howManyStarting(char letter) {
        if (isEmpty())
            return 0;

        int count = 0;
        WordNode current = _head;

        while (current != null) {
            char currentChar = current.getWord().charAt(0);
            if (currentChar == letter)
                count++;
            //  The list is sorted, so if the current word starting with a "bigger" char, we can break the loop.
            else if (currentChar > letter)
                break;
            current = current.getNext();
        }
        return count;
    }

    /**
     * A recursive method which finds the most frequent letter that the words starting with.
     * @return The most frequent starting letter.
     */
    public char mostFrequentStartingLetter() {
        if (isEmpty())
            return ' ';
        char firstChar = _head.getWord().charAt(0);
        return mostFrequentStartingLetter(_head, 1, 1, firstChar);
    }

    private char mostFrequentStartingLetter(WordNode node, int count, int maxCount, char mostFreq) {
        // base case
        if (node == null || node.getNext() == null)
            return mostFreq;

        char currentChar = node.getWord().charAt(0);
        char nextChar = node.getNext().getWord().charAt(0);

        // if the next char is different, we need to check if the current count is greater than max and reset the current count.
        if (currentChar != nextChar) {
            if (count > maxCount) {
                maxCount = count;
                mostFreq = currentChar;
            }
            count = 0;
        }

        // checking if it's the last word and the current count equals to the max count
        if (count == maxCount && node.getNext().getNext() == null)
            mostFreq = currentChar;

        return mostFrequentStartingLetter(node.getNext(), count + 1, maxCount, mostFreq);
    }

    /**
     * Returns a string representation of the list with the amount of each unique word in the list.
     * for example, the string representation of the text: "hello world"
     * hello    1
     * world    1
     *
     * @return A string representation of the list.
     *
     * Time complexity: O(n*S).  (because of String.equals)
     * Space complexity: O(n*S). because the final string length is the number of words multiplied by the length of each one (in the worst case).
     * S is the length of the longest word.
     */
    public String toString() {
        if (isEmpty())
            return "";

        WordNode prev = _head, current = _head;
        int count = 0;
        String str = "";

        while (current != null) {
            if (current.equals(prev))
                count++;
            else {
                // concatenating a WordNode with a string will automatically call to the toString method.
                str += prev + "\t" + count + "\n";
                count = 1;
            }
            prev = current;
            current = current.getNext();
        }

        // the last word
        str += prev + "\t" + count + "\n";

        return str;
    }

    private boolean isEmpty() {
        return _head == null;
    }

    private void addToHead(WordNode node) {
        if (!isEmpty())
            node.setNext(_head);
        _head = node;
    }

    // private methods for sorting the list
    private WordNode mergeSort(WordNode node) {
        if (node == null || node.getNext() == null)
            return node;

        // splits the list to 2 halves and sorting them.
        WordNode list2 = split(node);
        node = mergeSort(node);
        list2 = mergeSort(list2);

        // merging the sorted lists
        return merge(node, list2);
    }

    // merges 2 sorted list without using recursion and without extra space.
    private WordNode merge(WordNode list1, WordNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        WordNode temp;
        if (list1.getWord().compareTo(list2.getWord()) > 0) {
            temp = list2;
            list2 = list2.getNext();
        } else {
            temp = list1;
            list1 = list1.getNext();
        }

        WordNode merged = temp;
        while (list1 != null && list2 != null) {
            if (list1.getWord().compareTo(list2.getWord()) > 0) {
                temp.setNext(list2);
                list2 = list2.getNext();
            } else {
                temp.setNext(list1);
                list1 = list1.getNext();
            }
            temp = temp.getNext();
        }

        if (list1 == null)
            temp.setNext(list2);
        if (list2 == null)
            temp.setNext(list1);

        return merged;
    }

    // splits the list to 2 halves without using recursion and without extra space.
    private WordNode split(WordNode node) {
        if (node == null || node.getNext() == null)
            return null;

        // finds the mid node
        WordNode fast = node, list2 = node, prev = node;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            prev = list2;
            list2 = list2.getNext();
        }

        prev.setNext(null);
        return list2;
    }
}
