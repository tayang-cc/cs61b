import org.junit.Test;

import java.util.HashSet;

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
    public void testPalindrome1(){
        String str = "wow";
        boolean flag = true;
        assertEquals(flag,palindrome.isPalindrome(str));
    }

    @Test
    public void testPalindrome2(){
        String str = "USA";
        boolean flag = false;
        assertEquals(flag,palindrome.isPalindrome(str));
    }

    @Test
    public void testPalindrome3() {
        String str = "drawoward";
        assertEquals(true, palindrome.isPalindrome(str));
    }

    @Test
    public void testPalindrome4(){
        String str = "abcb";
        assertEquals(true,palindrome.isPalindrome(str,new OffByOne()));
    }

    @Test
    public void testPalindrome(){
        String str = "draw!coward";
        assertEquals(false,palindrome.isPalindrome(str,new OffByOne()));
    }

}
