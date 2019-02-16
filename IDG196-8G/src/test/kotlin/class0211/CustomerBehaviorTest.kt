package class0211

import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CustomerBehaviorTest {
    private val cardDigits = "4901123412341234"
    private val cardCSV = "123"
    private val cardExpire = "12/20"

    private val payment = Payment(cardDigits, cardCSV, cardExpire)
    private var payments: ArrayList<Payment> = arrayListOf()

    private var customer = Customer(
        "John Wayne",
        "jwayne@example.com",
        payments,
        null
    )

    @Before
    fun setup() {
        println("its a me setup")
        payments = arrayListOf()

        customer = Customer(
            "John Wayne",
            "jwayne@example.com",
            payments,
            null
        )
    }

    @After
    fun teardown() {
        println("its a me teardown")
    }

    @Test
    fun `remove payment returns true if payments list is empty`() {
        val customerBehavior = CustomerBehavior(customer)
        assertTrue(customerBehavior.removePayment(payment))
    }

    @Test
    fun `can't remove a payment that does not exist`() {
        payments.add(payment)

        val customerBehavior = CustomerBehavior(customer)
        val nonExistingPayment = Payment("10291019202920292", "132", "10/10")
        assertFalse(customerBehavior.removePayment(nonExistingPayment))
    }

    @Test
    fun `remove a payment that exists`() {
        payments.add(payment)

        val customerBehavior = CustomerBehavior(customer)
        assertTrue(customerBehavior.removePayment(payment))
    }

    @Test
    fun `can add a new payment if it doesn't exist`() {

    }
}
