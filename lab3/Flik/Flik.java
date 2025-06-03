import org.junit.Test;
import static org.junit.Assert.*;

/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a == b;
    }

    @Test
    public void SameNumber() {
        Integer a_0 = 1;
        Integer b_0 = 1;
        assertEquals(true,isSameNumber(a_0,b_0));
        Integer a_1 = 128;
        Integer b_1 = 128;
        assertEquals(true,isSameNumber(a_1,b_1));
    }
}
