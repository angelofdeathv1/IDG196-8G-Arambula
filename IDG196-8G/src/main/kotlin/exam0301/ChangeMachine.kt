package exam0301

class ChangeMachine(val coins: Array<Int>) {
    private val sortedCoins = coins.sortedDescending()

    fun getChange(amount: Int): Map<Int, Int> {
        val changeCoins = getChangeMap(sortedCoins)
        val emptyCoins = changeCoins.toMap()

        var remaining = amount

        if (remaining <= 0) {
            return emptyCoins
        }

        if (sortedCoins.isEmpty()) {
            return emptyCoins
        }

        val negativeCoins = sortedCoins.filter { it <= 0 }
        if (negativeCoins.isNotEmpty()) {
            return emptyCoins
        }

        val higherCoins = sortedCoins.filter { it < remaining }
        if (higherCoins.isEmpty()) {
            return emptyCoins
        }

        val lowerSortedCoins = sortedCoins.filter { it <= remaining }
        val highCoin = lowerSortedCoins[0]

        changeCoins[highCoin] = remaining / highCoin
        remaining %= highCoin

        lowerSortedCoins.listIterator(1).forEach {
            changeCoins[it] = remaining / it
            remaining %= it
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