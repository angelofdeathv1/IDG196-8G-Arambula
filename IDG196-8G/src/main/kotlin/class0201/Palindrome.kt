package class0201

class Palindrome {


    fun isPalindrome(number: Int): Boolean {
        if (number < 0) {
            return false
        }

        if (number % 10 == 0 && number != 0) {
            return false
        }

        var tmp1: Int = number
        var reverse = 0

        while (tmp1 > reverse) {
            reverse = reverse * 10 + tmp1 % 10

            tmp1 /= 10
        }

        return (tmp1 == reverse || tmp1 == reverse / 10)
    }
}