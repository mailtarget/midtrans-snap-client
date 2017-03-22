package co.mailtarget.midtrans.model

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
enum class TransactionStatus(val type: String) {
    AUTHORIZED("authorize"),
    CAPTURED("capture"),
    SETTLED("settlement"),
    PENDING("pending"),
    CANCELLED("cancel"),
    DENIED("deny"),
    EXPIRED("expire"),
    FAILED("failure"),
    SETTLEMENT("settlement");

    override fun toString(): String {
        return type
    }
}
