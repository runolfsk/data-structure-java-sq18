import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> StudentDeque = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> SolutionDeque = new ArrayDequeSolution<Integer>();
        StringBuilder failureSequence = new StringBuilder();

        for (int i = 0; i < 1000; i = i + 1) {
            int operationNumber = StdRandom.uniform(4);

            if (operationNumber == 0) {
                int ToFirstNum = StdRandom.uniform(99);
                StudentDeque.addFirst(ToFirstNum);
                SolutionDeque.addFirst(ToFirstNum);
                failureSequence.append("addFirst(").append(ToFirstNum).append(")\n");
            } else if (operationNumber == 1) {
                int ToLastNum = StdRandom.uniform(99);
                StudentDeque.addLast(ToLastNum);
                SolutionDeque.addLast(ToLastNum);
                failureSequence.append("addLast(").append(ToLastNum).append(")\n");
            } else if (operationNumber == 2) {
                if (StudentDeque.isEmpty()) {
                    failureSequence.append("NullPointerException\n");
                } else {
                    failureSequence.append("removeFirst\n");
                    Integer studentRemoved = StudentDeque.removeFirst();
                    Integer SolutionRemoved = SolutionDeque.removeFirst();
                    assertEquals(failureSequence.toString(), studentRemoved, SolutionRemoved);
                }
            } else {
                if (StudentDeque.isEmpty()) {
                    failureSequence.append("NullPointerException\n");
                } else {
                    failureSequence.append("removeLast()\n");
                    Integer studentRemoved = StudentDeque.removeLast();
                    Integer SolutionRemoved = SolutionDeque.removeLast();
                    assertEquals(failureSequence.toString(), studentRemoved, SolutionRemoved);
                }
            }
        }
    }
}
