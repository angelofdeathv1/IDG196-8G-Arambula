package exam0301

class ChangeMachine(val coins: Array<Int>) {
    private val sortedCoins = coins.sortedDescending()

    fun getChange(amount: Int): Map<Int, Int> {
        val changeCoins = getChangeMap(sortedCoins)
        val emptyCoins = changeCoins.toMap()

        var offsetIndex = 0
        var remaining = amount

        if (remaining <= 0) {
            return emptyCoins
        }

        if (sortedCoins.isEmpty()) {
            return emptyCoins
        }

        val negativeCoins = sortedCoins.filter { it < 0 }
        if (negativeCoins.isNotEmpty()) {
            return emptyCoins
        }

        val higherCoins = sortedCoins.filter { it < remaining }
        if (higherCoins.isEmpty()) {
            return emptyCoins
        }

        for ((index, value) in sortedCoins.withIndex()) {
            if (remaining > value) {
                remaining = amount % value
                changeCoins[value] = amount / value
                offsetIndex = index
                break
            }
        }

        for (i in offsetIndex + 1 until sortedCoins.size) {
            val value = sortedCoins[i]

            changeCoins[value] = remaining / value
            remaining = amount % value
        }

        if (remaining > 0) {
            return emptyCoins
        }

        return changeCoins
    }

    private fun getChangeMap(coins: List<Int>): HashMap<Int, Int> {
        val changeCoins = HashMap<Int, Int>()

        coins.forEach {
            changeCoins[it] = 0
        }

        return changeCoins
    }
}