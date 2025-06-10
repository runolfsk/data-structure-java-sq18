import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestPalindrome() {
        String word_0 = "racecar";
        String word_1 = "cat";
        String word_2 = "Noon";
        String word_3 = "a";
        String word_4 = "";
        assertTrue(palindrome.isPalindrome(word_0));
        assertFalse(palindrome.isPalindrome(word_1));
        assertFalse(palindrome.isPalindrome(word_2));
        assertTrue(palindrome.isPalindrome(word_3));
        assertTrue(palindrome.isPalindrome(word_4));
    }
}
