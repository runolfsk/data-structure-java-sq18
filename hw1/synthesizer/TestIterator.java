package synthesizer;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<>(5);
        
        System.out.println("Testing iterator() method implementation:");
        
        // Add some elements
        arb.enqueue("First");
        arb.enqueue("Second");
        arb.enqueue("Third");
        
        System.out.println("Added 3 elements: First, Second, Third");
        System.out.println("Fill count: " + arb.fillCount());
        
        // Test iterator using enhanced for loop (which uses iterator() internally)
        System.out.println("\nTesting with enhanced for loop:");
        for (String item : arb) {
            System.out.println("Item: " + item);
        }
        
        // Test iterator manually
        System.out.println("\nTesting iterator manually:");
        Iterator<String> it = arb.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator item: " + it.next());
        }
        
        // Verify original buffer is unchanged
        System.out.println("\nVerifying original buffer is unchanged:");
        System.out.println("Fill count after iteration: " + arb.fillCount());
        System.out.println("Peek (should still be 'First'): " + arb.peek());
        
        // Test multiple iterators
        System.out.println("\nTesting multiple independent iterators:");
        Iterator<String> it1 = arb.iterator();
        Iterator<String> it2 = arb.iterator();
        
        System.out.println("Iterator 1 first item: " + it1.next());
        System.out.println("Iterator 2 first item: " + it2.next());
        System.out.println("Iterator 1 second item: " + it1.next());
        System.out.println("Iterator 2 second item: " + it2.next());
        
        System.out.println("\nAll iterator tests completed successfully!");
    }
} 