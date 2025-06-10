public class ArrayDeque < T > {
    private T[] items;
    private int size;
    private int nextFisrt;
    private int nextLast;

    private static final int INITIAL_CAPACITY = 8;
    private static final double MIN_USE_RATIO = 0.25;
    private static final int RESIZE_FACTOR_UP = 2;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFisrt = 0;
        nextLast = 1;
    }

    // 用来更新尾
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    // 用来更新头
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * RESIZE_FACTOR_UP);
        }
        items[nextFisrt] = item;
        nextFisrt = minusOne(nextFisrt);
        size = size + 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * RESIZE_FACTOR_UP);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size = size + 1;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        int currentOld = plusOne(nextFisrt);
        for (int i = 0; i < size ; i++) {
            newArray[i] = items[currentOld];
            currentOld = plusOne(currentOld);
        }
        items = newArray;
        // 重置nextFirst和nextLast
        nextFisrt = items.length - 1;//现在的第一个元素在0，理论上下一个元素在0 - 1，就是末尾元素
        nextLast = size;//现在最后一个元素在位置size - 1;所以理论上下一个元素应该在size
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFisrt = plusOne(nextFisrt);
        T removedItem = items[nextFisrt];
        items[nextFisrt] = null;
        size = size - 1;
        if (items.length > 16 && (double) size / items.length <= MIN_USE_RATIO) {
            resize(items.length / 2);
        }
        return removedItem;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        T removedItem = items[nextLast];
        size = size - 1;
        if (items.length > 16 && (double) size / items.length <= MIN_USE_RATIO) {
            resize(items.length / 2);
        }
        return removedItem;
    }

    //自己写的，正确但是性能不好
//    public T get(int index) {
//        if (index < 0 || index >= size) {
//            return null;
//        }
//        int currentOld = plusOne(nextFisrt);
//        for (int i = 0; i < index; i++) {
//            currentOld = plusOne(currentOld);
//        }
//        return items[currentOld];
//    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int firstItemIndex = plusOne(nextFisrt);
        int actualIndex = (firstItemIndex + index) % items.length;
        return items[actualIndex];
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println();
        }
        int currentIndex = plusOne(nextFisrt);
        for (int i = 0; i < size; i++) {
            System.out.print(items[currentIndex]);
            currentIndex = plusOne(currentIndex);
        }
    }
}
