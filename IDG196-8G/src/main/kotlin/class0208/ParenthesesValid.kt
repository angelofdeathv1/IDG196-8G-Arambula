package class0208

import java.util.*

class ParenthesesValid {
    private val allowedChars: HashSet<Char> = hashSetOf('(', ')', '[', ']', '{', '}')
    private val leftChars: HashSet<Char> = hashSetOf('(', '[', '{')
    private val rightChars: HashSet<Char> = hashSetOf(')', ']', '}')

    fun isValid(string: String): Boolean {
        var st: Stack<Char> = Stack()

        if (string.isEmpty() || string.isBlank()) {
            return true
        }

        for (index in string.indices) {
            if (!allowedChars.contains(string[index])) {
                return false
            }
        }

        for (index in string.indices) {
            val current = string[index]

            if (leftChars.contains(current)) {
                st.push(string[index])
            } else if (rightChars.contains(current)) {
                if (st.empty()) {
                    return false
                }

                val openChar = st.pop()

                if (openChar == '(' && current != ')') {
                    return false
                } else if (openChar == '[' && current != ']') {
                    return false
                } else if (openChar == '{' && current != '}') {
                    return false
                }
            }
        }

        return st.empty()
    }
}