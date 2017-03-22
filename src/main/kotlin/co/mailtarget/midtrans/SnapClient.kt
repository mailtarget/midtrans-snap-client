package co.mailtarget.midtrans

import co.mailtarget.midtrans.config.GatewayConfig
import co.mailtarget.midtrans.exception.MidtransException
import co.mailtarget.midtrans.model.SnapRequest
import co.mailtarget.midtrans.model.SnapResponse
import co.mailtarget.midtrans.util.JsonUtil
import org.apache.commons.codec.binary.Base64
import org.apache.http.Header
import org.apache.http.HttpHost
import org.apache.http.auth.AuthScope
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.apache.http.message.BasicHeader
import java.util.*

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class SnapClient {

    private val gatewayConfig: GatewayConfig
    private val connectionManager: PoolingHttpClientConnectionManager
    private val httpClient: CloseableHttpClient

    constructor(gatewayConfig: GatewayConfig){
        this.gatewayConfig = gatewayConfig
        this.connectionManager = PoolingHttpClientConnectionManager()

        if (connectionManager.maxTotal < gatewayConfig.maxConnectionPoolSize) {
            connectionManager.maxTotal = gatewayConfig.maxConnectionPoolSize
        }
        connectionManager.defaultMaxPerRoute = gatewayConfig.maxConnectionPoolSize

        httpClient = buildHttpClient()
    }

    fun requestToken(snapRequest: SnapRequest): SnapResponse {
        try {
            val data = JsonUtil.toJson(snapRequest)
            val entity = StringEntity(data)
            entity.setContentType("application/json")
            val httpPost = HttpPost(gatewayConfig.environment.url)
            httpPost.config = getRequestConfig()
            httpPost.entity = entity
            val response = httpClient.execute(httpPost)
            response.use { httpResponse ->
                return JsonUtil.fromJson(httpResponse, SnapResponse::class.java)
            }
        } catch (e: Exception) {
            throw MidtransException(e)
        }

    }

    private fun buildHttpClient(): CloseableHttpClient {
        val authHeaderVal = gatewayConfig.serverKey + ":"
        val authBase64 = Base64.encodeBase64String(authHeaderVal.toByteArray())
        val defaultHeaders = Arrays.asList(
                BasicHeader("Accept", "application/json") as Header,
                BasicHeader("Authorization", "Basic $authBase64") as Header
        )
        return configureProxy(HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultHeaders(defaultHeaders)).build()
    }

    private fun configureProxy(httpClientBuilder: HttpClientBuilder): HttpClientBuilder {
        if (gatewayConfig.proxyConfig == null) {
            return httpClientBuilder
        }

        val proxyConfig = gatewayConfig.proxyConfig
        val proxyHost = HttpHost(proxyConfig.host, proxyConfig.port)
        val credentialsProvider = BasicCredentialsProvider()

        if (proxyConfig.username != null) {
            credentialsProvider.setCredentials(AuthScope(proxyHost), UsernamePasswordCredentials(
                    proxyConfig.username,
                    proxyConfig.password))
        }
        return httpClientBuilder
                .setProxy(proxyHost)
                .setDefaultCredentialsProvider(credentialsProvider)
    }

    private fun getRequestConfig(): RequestConfig {
        val requestConfig = RequestConfig.copy(RequestConfig.DEFAULT)
                .setConnectTimeout(gatewayConfig.connectTimeout)
                .setSocketTimeout(gatewayConfig.socketTimeout)
                .build()
        return requestConfig
    }

}
