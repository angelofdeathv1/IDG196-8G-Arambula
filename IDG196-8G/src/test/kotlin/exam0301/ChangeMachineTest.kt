package exam0301

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

class ChangeMachineTest {
    private val coins = arrayOf(5, 10, 1)
    private val emptyMapWithCoins = hashMapOf(10 to 0, 5 to 0, 1 to 0)
    private val changeMachine3000 = ChangeMachine(coins)

    @Test
    fun `returns an empty map when coins are empty`() {
        val changeMachine3000 = ChangeMachine(emptyArray())
        val expected = emptyMap<Int, Int>()

        val actual = changeMachine3000.getChange((1..200).random())

        assertEquals(expected, actual)
    }

    @Test
    fun `returns a map with the same number configured coins`() {
        val expected = changeMachine3000.coins.size

        val actual = changeMachine3000.getChange((1..200).random()).size

        assertEquals(expected, actual)
    }

    @Test
    fun `returns an empty map when amount is negative or 0`() {
        val actual = changeMachine3000.getChange((-100..0).random())

        assertEquals(emptyMapWithCoins, actual)
    }

    @Test
    fun `returns an empty map when there is a configured coin with negative value `() {
        val coins = arrayOf(5, -10, 2)
        val changeMachine3000 = ChangeMachine(coins)
        val expected = hashMapOf(5 to 0, 2 to 0, -10 to 0)

        val actual = changeMachine3000.getChange((1..200).random())

        assertEquals(expected, actual)
    }

    @Test
    fun `returns an empty map when amount is lower than lowest configured coin`() {
        val coins = arrayOf(20, 19, 18)
        val changeMachine3000 = ChangeMachine(coins)
        val expected = hashMapOf(20 to 0, 19 to 0, 18 to 0).toSortedMap()

        val actual = changeMachine3000.getChange((1..17).random())

        assertEquals(expected, actual)
    }

    @Test
    fun `finds the highest coin available for the amount`() {
        val expected = hashMapOf(10 to 0, 5 to 1, 1 to 1).toSortedMap()

        val actual = changeMachine3000.getChange(6)

        assertEquals(expected, actual)
    }

    @Test
    fun `finds the next available coins for the amount until remains are 0`() {
        val expected = hashMapOf(10 to 5, 5 to 1, 1 to 2).toSortedMap()
        val actual = changeMachine3000.getChange(57)

        assertEquals(expected, actual)
    }

    @Test
    fun `returns empty map when no exact change is available (prime number)`() {
        val coins = arrayOf(5, 10, 2)
        val changeOMatic = ChangeMachine(coins)

        val expected = hashMapOf(10 to 0, 5 to 0, 2 to 0)
        val actual = changeOMatic.getChange(59)

        assertEquals(expected, actual)
    }

    @Ignore
    @Test
    fun `test if coins are ordered`() {
        val coins = arrayOf(8, 10, 5, 1)
        val coinsOrdered = coins.sortedDescending()
        val descending = coinsOrdered.zip(
            coinsOrdered.drop(1)
        ).all { (a, b) ->
            a > b
        }

        assertTrue(descending)
    }
}