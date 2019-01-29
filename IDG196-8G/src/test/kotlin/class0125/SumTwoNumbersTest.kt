package class0125

import org.junit.Assert
import org.junit.Test

class SumTwoNumbersTest {
    private val dummy = SumTwoNumbers()

    @Test
    fun testTwoSumReturns2and3IfTarget12() {
        val arr: IntArray = intArrayOf(9, 6, 4, 8, 1)
        val target = 12
        val expected: IntArray = intArrayOf(2, 4)

        val actual = dummy.twoSum(arr, target)

        Assert.assertEquals(expected[0], actual[0])
        Assert.assertEquals(expected[1], actual[1])
    }
}