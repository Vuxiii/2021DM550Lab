public interface MyCollection<E> {
    /**
     * Ensures that this collection contains e
     * @param e the element that should be present in this collection.
     */
    public void add( E e );
    /**
     * Clears this collection
     */
    public void clear();
    /**
     * Checks whether this collection contains e
     * @param e the element to check
     * @return true if this collection contains the given element
     */
    public boolean contains( E e );
    /**
     * Checks if this collection is empty.
     * @return true if this collection is empty
     */
    public boolean isEmpty();
    /**
     * Returns the number of elements in this collection
     * @return the amount of elements in this collection.
     */
    public int size();
}
