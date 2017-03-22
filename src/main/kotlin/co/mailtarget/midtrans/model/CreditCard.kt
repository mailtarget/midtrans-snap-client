package co.mailtarget.midtrans.model

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class CreditCard {
    var saveCard = true
    var secure = true
    var bank: String? = null
    var channel: String? = null
    var whitelistBins: List<String>? = null
    var installment: Installment? = null

    class Installment {
        var required = false
        var terms: Map<String, Array<Int>>? = null
    }
}