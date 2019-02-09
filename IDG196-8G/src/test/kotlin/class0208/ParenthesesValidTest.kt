package class0208

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ParenthesesValidTest {
    private val parentheses = ParenthesesValid()

    @Test
    fun `returns false when an empty string is in the input`() {
        val string = ""
        assertFalse(parentheses.isValid(string))
    }

    @Test
    fun `returns false when a blank string is in the input`() {
        val string = "         "
        assertFalse(parentheses.isValid(string))
    }

    @Test
    fun `returns false when an invalid character is in the input`() {
        val string = "*@()"
        assertFalse(parentheses.isValid(string))
    }

    @Test
    fun `returns false when starts with RP`() {
        val string = ")]}()("
        assertFalse(parentheses.isValid(string))
    }

    @Test
    fun `returns true when elements are only LP or RP and are balanced`() {
        val string = "((()))"
        assertTrue(parentheses.isValid(string))
    }

    @Test
    fun `returns false when elements are only LP or RP and are unbalanced`() {
        val string = "()(()))"
        assertFalse(parentheses.isValid(string))
    }

    @Test
    fun `returns true when elements are only LB or RB and are balanced`() {
        val string = "[[[]]]"
        assertTrue(parentheses.isValid(string))
    }

    @Test
    fun `returns false when elements are only LB or RB and are unbalanced`() {
        val string = "[][[]]]"
        assertFalse(parentheses.isValid(string))
    }

    @Test
    fun `returns true when elements are only LCB or RCB and are balanced`() {
        val string = "{{{}}}"
        assertTrue(parentheses.isValid(string))
    }

    @Test
    fun `returns false when elements are only LCB or RCB and are unbalanced`() {
        val string = "{}{{}}}"
        assertFalse(parentheses.isValid(string))
    }

    @Test
    fun `returns true when elements are combined and are balanced`() {
        val string = "{[(){}]}"
        assertTrue(parentheses.isValid(string))
    }
}