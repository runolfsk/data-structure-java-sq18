import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();

    // Your tests go here.
    @Test
    public void TestisPalindrome() {
        String word_0 = "flake";
        String word_1 = "flame";
        assertTrue(palindrome.isPalindrome(word_0,offByOne));
        assertFalse(palindrome.isPalindrome(word_1,offByOne));
    }
}
