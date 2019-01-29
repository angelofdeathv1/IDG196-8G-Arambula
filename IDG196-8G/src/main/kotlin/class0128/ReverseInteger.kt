package class0128

class ReverseInteger {
    fun reverseInteger(x: Int): Int {
        var tmp1: Int = x
        var digit: Int
        var reverse = 0

        while (tmp1 != 0) {
            digit = tmp1 % 10
            tmp1 /= 10

            reverse = reverse * 10 + digit
        }

        return reverse
    }
}