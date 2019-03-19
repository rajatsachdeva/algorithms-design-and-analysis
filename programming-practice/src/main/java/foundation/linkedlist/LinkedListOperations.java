package foundation.linkedlist;

public interface LinkedListOperations<T> {

    /**
     * Returns number of data elements in list
     */
    int size();

    /**
     * Returns true if empty
     */
    boolean empty();

    /**
     * Returns the value of the nth item (starting at 0 for first)
     */
    T valueAt(int index);

    /**
     * Adds an item to the front of the list
     */
    void pushFront(T value);

    /**
     * Adds an item at the end
     */
    void pushBack(T value);

    /**
     * Removes front item and return its value
     */
    T popFront();

    /**
     * Removes end item and returns its value
     */
    T popBack();

    /**
     * Get value of front item
     */
    T front();

    /**
     * Get value of end item
     */
    T back();

    /**
     * Insert value at index, so current item at that index is pointed to by new item at index
     */
    void insert(int index, T value);

    /**
     * Removes node at given index
     */
    void erase(int index);

    /**
     * Removes the first item in the list with this value
     */
    void removeValue(T value);

    /**
     * Prints the list
     */
    void printList();

    /**
     * Clear list
     */
    void clear();

    /**
     * Reverses the list
     */
    void reverse();

    /**
     * Reverses the list using recursion
     */
    void reverseUsingRecursion();

    /**
     * Returns the value of the node at nth position from the end of the list
     */
    T nthValueFromEnd(int n);

}
