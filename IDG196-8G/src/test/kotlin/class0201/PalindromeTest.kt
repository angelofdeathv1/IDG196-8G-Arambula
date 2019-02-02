package class0201

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PalindromeTest {
    private val palindrome = Palindrome()

    @Test
    fun `returns false when number is negative`() {
        val number = -100

        assertFalse(palindrome.isPalindrome(number))
    }

    @Test
    fun `returns false when number ends with zero and is not zero`() {
        val number = 1000

        assertFalse(palindrome.isPalindrome(number))
    }

    @Test
    fun `returns true when number is zero`() {
        assertTrue(palindrome.isPalindrome(0))
    }

    @Test
    fun `returns true when number is palindrome and odd number of digits`() {
        val number = 12321
        assertTrue(palindrome.isPalindrome(number))
    }

    @Test
    fun `returns true when number is palindrome and pair number of digits`() {
        val number = 122221
        assertTrue(palindrome.isPalindrome(number))
    }

    @Test
    fun `returns false when number is not palindrome and odd number of digits`() {
        val number = 12322
        assertFalse(palindrome.isPalindrome(number))
    }

    @Test
    fun `returns false when number is not palindrome and pair number of digits`() {
        val number = 122222
        assertFalse(palindrome.isPalindrome(number))
    }
}