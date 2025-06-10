import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void TestisPalindrome() {
        OffByN OffBy5 = new OffByN(5);
        char word_0 = 'a';
        char word_1 = 'b';
        char word_2 = 'f';
        assertTrue(OffBy5.equalChars(word_0,word_2));
        assertFalse(OffBy5.equalChars(word_0,word_1));
    }
}
