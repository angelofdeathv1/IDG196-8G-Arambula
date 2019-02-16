package class0211

class CustomerBehavior(private val customer: Customer) {

    fun removePayment(payment: Payment): Boolean {
        if (customer.payments.isEmpty()) {
            return true
        }

        if (customer.payments.contains(payment)) {
            return customer.payments.remove(payment)
        }

        return false
    }
}