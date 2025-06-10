
public class LinkedListDeque <T> implements Deque<T> {
    private class Node {
        T item;
        Node prev;
        Node next;

        public Node(T t, Node p, Node n) {
            item = t;
            prev = p;
            next = n;
        }
    }
    private Node Sentinel_Node;
    private int size;

    /** 链表初始化，哨兵节点设为null，且哨兵节点的next和previous都设置为哨兵节点**/
    public LinkedListDeque() {
        Sentinel_Node = new Node(null, null, null);
        Sentinel_Node.prev = Sentinel_Node;
        Sentinel_Node.next = Sentinel_Node;
        size = 0;
    }

    /** 判断链表是否是空值，这是错误的，因为哨兵节点永远都不会是空值 **/
//    public boolean isEmpty() {
//        if (Sentinel_Node.next == null) {
//            return true;
//        }
//        return false;
//    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /* 返回链表的长度 */
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item,Sentinel_Node,Sentinel_Node.next);
        Sentinel_Node.next.prev = newNode;
        Sentinel_Node.next = newNode;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item,Sentinel_Node.prev,Sentinel_Node);
        Sentinel_Node.prev.next = newNode;
        Sentinel_Node.prev = newNode;
        size = size + 1;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node nodeToRemove = Sentinel_Node.next;
        T itemToRemove = nodeToRemove.item;
        Sentinel_Node.next = Sentinel_Node.next.next;
        Sentinel_Node.next.prev = Sentinel_Node;
        size = size - 1;
        //显式断开被移除节点对其item和其他节点的引用
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.item = null;
        return itemToRemove;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node nodeToRemove = Sentinel_Node.prev;
        T itemToRemove = nodeToRemove.item;
        Sentinel_Node.prev = Sentinel_Node.prev.prev;
        Sentinel_Node.prev.next = Sentinel_Node;
        size = size - 1;
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.item = null;
        return itemToRemove;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Node currentNode = Sentinel_Node.next;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    @Override
    public void printDeque() {
        if (this.size == 0) {

        }
        else {
            for (int i = 0 ; i < this.size; i++) {
                System.out.print(this.Sentinel_Node.next);
            }
        }
    }
}
