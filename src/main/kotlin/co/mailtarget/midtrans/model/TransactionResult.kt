package co.mailtarget.midtrans.model

import co.mailtarget.midtrans.util.JsonUtil
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.InputStream
import java.math.BigDecimal
import java.util.*

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class TransactionResult {
    var statusCode: String? = null
    var statusMessage: String? = null
    var transactionId: String? = null
    var orderId: String? = null
    @JsonProperty("payment_type")
    var paymentMethod: String? = null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+07")
    var transactionTime: Date? = null
    var transactionStatus: TransactionStatus? = null
    var approvalCode: String? = null
    var grossAmount: BigDecimal? = null
    var fraudStatus: FraudStatus? = null
    @JsonProperty("masked_card")
    var maskedCardNumber: String? = null
    var bank: String? = null

    companion object {
        fun fromJson(inputStream: InputStream): TransactionResult {
            return JsonUtil.fromJson(inputStream, TransactionResult::class.java)
        }
    }

}