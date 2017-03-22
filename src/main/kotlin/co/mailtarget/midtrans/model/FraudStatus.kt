package co.mailtarget.midtrans.model

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
enum class FraudStatus(val type: String) {
    ACCEPTED("accept"),
    DENIED("deny"),
    CHALLENGE("challenge");

    override fun toString(): String {
        return type
    }
}
