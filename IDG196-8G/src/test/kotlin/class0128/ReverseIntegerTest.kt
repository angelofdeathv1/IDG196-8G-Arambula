package class0128

import org.junit.Assert.assertEquals
import org.junit.Test

class ReverseIntegerTest {
    private val reverseInteger = ReverseInteger()

    @Test
    fun testIfReversesPositiveNumber() {
        val value = 1534236469
        val expected = 9646324351

        val actual = reverseInteger.reverseInteger(value)

        assertEquals(expected, actual)
    }

    @Test
    fun testIfReversesNegativeNumber(){
        val value = -1234
        val expected = -4321

        val actual = reverseInteger.reverseInteger(value)

        assertEquals(expected, actual)
    }

    @Test
    fun testIfReversesLongNumber(){
        val value = -999095991
        val expected = -199590999

        val actual = reverseInteger.reverseInteger(value)

        assertEquals(expected, actual)
    }
}