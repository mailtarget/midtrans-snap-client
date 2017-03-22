package co.mailtarget.midtrans

import co.mailtarget.midtrans.model.EnablePayment
import co.mailtarget.midtrans.util.JsonUtil
import org.junit.Test

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
open class JsonTest {

    @Test
    fun testSerializationJsonEnum(){
        assert(JsonUtil.toJson(EnablePayment.BCA_KLIKBCA) == JsonUtil.toJson(EnablePayment.BCA_KLIKBCA.type))
    }

}