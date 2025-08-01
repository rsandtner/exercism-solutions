import java.util.*

class BankAccount {

    private val transactions = Collections.synchronizedList(mutableListOf<Long>())

    private var closed = false

    val balance: Long
        get() {

            verifyValidAccount()
            return transactions.sum()
        }

    fun adjustBalance(amount: Long) {
        verifyValidAccount()
        transactions.add(amount)
    }

    fun close() {
        closed = true
    }

    private fun verifyValidAccount() {
        check(!closed) { "Account is closed" }
    }
}
