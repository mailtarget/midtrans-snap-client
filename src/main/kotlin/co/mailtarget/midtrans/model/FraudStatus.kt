package co.mailtarget.midtrans.model

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
enum class FraudStatus(name: String) {
    ACCEPTED("accept"),
    DENIED("deny"),
    CHALLENGE("challenge")
}
