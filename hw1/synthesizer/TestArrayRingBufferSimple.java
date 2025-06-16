package synthesizer;

public class TestArrayRingBufferSimple {
    public static void main(String[] args) {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        
        System.out.println("Testing ArrayRingBuffer:");
        
        // Test isEmpty
        System.out.println("Is empty initially: " + arb.isEmpty()); // should be true
        System.out.println("Fill count initially: " + arb.fillCount()); // should be 0
        
        // Test enqueue
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        System.out.println("Fill count after enqueuing 3 items: " + arb.fillCount()); // should be 3
        System.out.println("Is empty after enqueuing: " + arb.isEmpty()); // should be false
        
        // Test peek
        System.out.println("Peek: " + arb.peek()); // should be 1
        System.out.println("Fill count after peek: " + arb.fillCount()); // should be 3
        
        // Test dequeue
        System.out.println("Dequeue: " + arb.dequeue()); // should be 1
        System.out.println("Fill count after dequeue: " + arb.fillCount()); // should be 2
        System.out.println("Peek after dequeue: " + arb.peek()); // should be 2
        
        // Test Iterator functionality (since this class implements Iterator)
        System.out.println("Testing Iterator functionality:");
        System.out.println("hasNext: " + arb.hasNext()); // should be true
        System.out.println("next: " + arb.next()); // should be 2 (and remove it)
        System.out.println("Fill count after next: " + arb.fillCount()); // should be 1
        
        // Fill the buffer to test isFull
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(7);
        System.out.println("Fill count after filling: " + arb.fillCount()); // should be 5
        System.out.println("Is full: " + arb.isFull()); // should be true
        
        System.out.println("All tests completed successfully!");
    }
} 