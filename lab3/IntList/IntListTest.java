import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList1 one = new IntList1(1, null);
        IntList1 twoOne = new IntList1(2, one);
        IntList1 threeTwoOne = new IntList1(3, twoOne);

        IntList1 x = IntList1.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList1 L = IntList1.of(1, 2, 3);
        IntList1.dSquareList(L);
        assertEquals(IntList1.of(1, 4, 9), L);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty list, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList1 L = IntList1.of(1, 2, 3);
        IntList1 res = IntList1.squareListRecursive(L);
        assertEquals(IntList1.of(1, 2, 3), L);
        assertEquals(IntList1.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList1 A = IntList1.of(1, 2, 3);
        IntList1 B = IntList1.of(4, 5, 6);
        IntList1 exp = IntList1.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList1.dcatenate(A, B));
        assertEquals(IntList1.of(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        IntList1 A = IntList1.of(1, 2, 3);
        IntList1 B = IntList1.of(4, 5, 6);
        IntList1 exp = IntList1.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList1.catenate(A, B));
        assertEquals(IntList1.of(1, 2, 3), A);
    }

    /** If you're running this from the command line, you'll need
      * to add a main method. See ArithmeticTest.java for an
      * example. */
    @Test(timeout = 1000)
    public void reverse(){
        IntList1 list = IntList1.of(1,1,2,3,4);
        IntList1 origin = IntList1.of(1,1,2,3,4);
        IntList1 exp = IntList1.of(4,3,2,1,1);
        assertEquals(exp, IntList1.reverse(list));
        assertNotEquals(list,origin);
        IntList1 list_1 = IntList1.of();
        IntList1 exp_1 = IntList1.reverse(list_1);
        assertEquals(exp_1, IntList1.reverse(list_1));
    }
}
