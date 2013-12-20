/**
 * A generic ADT for a stack of objects.
 * A stack provides last-in-first-out (LIFO) access to a collection of items.
 */
public interface Stack<T> {

	/**
	 * Push a new item onto this stack.
	 *
	 * Efficiency: this operation should complete in constant time - O(1)
	 * Postcondition: the pushed item is the new top value.
	 */
	void push(T item);

	/**
	 * Remove and return the current top of this stack.
	 * @throws EmptyStackException if there is no item to pop.
	 *
	 * Efficiency: this operation should complete in constant time - O(1)
	 */
	T pop() throws EmptyStackException;

	/**
	 * Return but do not remove the current top of this stack.
	 * @throws EmptyStackException if there is no item to retrieve.
	 *
	 * Efficiency: this operation should complete in constant time - O(1)
	 * Postcondition: the returned value remains at the top of this stack.
	 */
	T top() throws EmptyStackException;

	/**
	 * Does this stack have no items?
	 * If this method returns false, then a subsequent call to pop() or top() should succeed.
	 *
	 * Efficiency: this operation should complete in constant time - O(1)
	 */
	boolean isEmpty();

}
