package co.mailtarget.midtrans.model

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class TransactionItem(
        var id: String,
        var name: String,
        var price: Long = 0,
        var quantity: Int = 1
)