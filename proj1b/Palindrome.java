public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++ ) {
            char character = word.charAt(i);
            charDeque.addLast(character);
        }
        return charDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> charDeque = wordToDeque(word);
        int length = charDeque.size();
        if (charDeque.size() <= 1) {
            return true;
        }
        else {
            for (int i = 0; i < length / 2; i++) {
                char First_cur = charDeque.removeFirst();
                char Last_cur = charDeque.removeLast();
                if (First_cur != Last_cur) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String word,CharacterComparator cc) {
        Deque<Character> charDeque = wordToDeque(word);
        int length = charDeque.size();
        if (charDeque.size() <= 1) {
            return true;
        }
        else {
            for (int i = 0; i < length / 2; i++) {
                char First_cur = charDeque.removeFirst();
                char Last_cur = charDeque.removeLast();
                if (!cc.equalChars(First_cur, Last_cur)) {
                    return false;
                }
            }
        }
        return true;
    }
}
