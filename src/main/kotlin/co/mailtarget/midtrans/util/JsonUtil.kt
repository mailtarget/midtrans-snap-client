package co.mailtarget.midtrans.util

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.apache.http.HttpResponse
import java.io.InputStream
import java.text.SimpleDateFormat

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
object JsonUtil {
    private val DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss Z"
    private val jsonMapper = MidtransObjectMapper()

    fun <T> fromJson(inputStream: InputStream, clazz: Class<T>): T {
        return jsonMapper.readValue(inputStream, clazz)
    }

    fun <T> fromJson(jsonString: String, clazz: Class<T>): T {
        return jsonMapper.readValue(jsonString, clazz)
    }

    fun <T> fromJson(httpResponse: HttpResponse, clazz: Class<T>): T {
        return fromJson(httpResponse.entity.content, clazz)
    }

    fun toJson(o: Any): String {
        try {
            return jsonMapper.writeValueAsString(o)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
            return o.toString()
        }
    }

    private class MidtransObjectMapper : ObjectMapper() {
        init {
            dateFormat = SimpleDateFormat(DEFAULT_DATE_FORMAT)
            propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
            configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
            configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false)
            configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
            configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true)
            setSerializationInclusion(JsonInclude.Include.NON_ABSENT)
            registerModule(Jdk8Module())
            registerModule(JavaTimeModule())
        }
    }
}