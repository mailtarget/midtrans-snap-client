package co.mailtarget.midtrans.model

import java.util.*

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class SnapRequest(var transactionDetails: TransactionDetails) {
    var itemDetails: List<TransactionItem>? = null
    var enabledPayments: List<EnablePayment>? = null
    var customerDetails: CustomerDetails? = null
    var creditCard: CreditCard? = null
    var expiry: Expiry? = null
    var customField1: String? = null
    var customField2: String? = null
    var customField3: String? = null

    class Expiry {
        var startTime: Date? = null
        var unit: String? = null
        var duration = 1
    }
}