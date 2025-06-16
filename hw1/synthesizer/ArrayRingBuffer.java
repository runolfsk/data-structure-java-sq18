package synthesizer;
import java.util.Iterator;
import java.util.NoSuchElementException;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek, points to the first element
    /* Index for the next enqueue. */
    private int last;             // points to the next position for insertion
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public boolean isFull() {
        if (fillCount == capacity) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        if (fillCount == 0) {
            return true;
        }
        return false;
    }
    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = (last + 1) % capacity;
        fillCount = fillCount + 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new NoSuchElementException("Buffer is empty");
        }
        T item = rb[first];
        first = (first + 1) % capacity;
        fillCount = fillCount - 1;
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new NoSuchElementException("Buffer is empty");
        }
        return rb[first];
    }

    @Override
    // Return the current array size, i.e., the number of elements it has
    public int fillCount() {
        return this.fillCount;
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    @Override
    public int capacity() {
        return this.capacity;
    }

    /**
     * Implement iterator() method required by Iterable<T> interface
     * Returns a new iterator that can iterate through the ring buffer
     */
    @Override
    public Iterator<T> iterator() {
        return new RingBufferIterator();
    }

    public boolean hasNext() {
        return fillCount == 0;
    }

    public T next() {
        if (! hasNext()) {
            throw new NoSuchElementException();
        }
        int currIndex = last;
        T item = rb[currIndex];
        currIndex = (currIndex + 1) % capacity;
        fillCount = fillCount - 1;
        return item;
    }

    private class RingBufferIterator implements Iterator<T> {
        private int currIndex;      // current index
        private int elementLeft;    // track how many elements are left in the iterator

        public RingBufferIterator() {
            this.currIndex = first;
            this.elementLeft = fillCount;
        }

        @Override
        // Check if there is a next element
        public boolean hasNext() {
            return elementLeft > 0;
        }

        @Override
        // Return the next element
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = rb[currIndex];
            currIndex = (currIndex + 1) % capacity;
            elementLeft = elementLeft - 1;
            return item;
        }

        @Override
        // For RingBuffer, remove is usually not supported because removing middle elements would break ring structure continuity
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported by this iterator.");
        }
    }

}
