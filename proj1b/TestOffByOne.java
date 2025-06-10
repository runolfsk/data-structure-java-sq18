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
        String word_0 = "detrude";
        String word_1 = "flame";
        String word_2 = "";
        String word_3 = "a";
        String word_4 = "ab";
        String word_5 = "ac";
        String word_6 = "&";
        assertTrue(palindrome.isPalindrome(word_0,offByOne));
        assertTrue(palindrome.isPalindrome(word_1,offByOne));
        assertTrue(palindrome.isPalindrome(word_2,offByOne));
        assertTrue(palindrome.isPalindrome(word_3,offByOne));
        assertTrue(palindrome.isPalindrome(word_4,offByOne));
        assertFalse(palindrome.isPalindrome(word_5,offByOne));
        assertTrue(palindrome.isPalindrome(word_6,offByOne));
    }
}
