package co.mailtarget.midtrans.config

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class GatewayConfig {

    val environment: SnapEnvironment
    val serverKey: String
    val clientKey: String
    val maxConnectionPoolSize: Int
    val proxyConfig: ProxyConfig?
    val connectTimeout: Int
    val socketTimeout: Int

    constructor(environment: String, serverKey: String, clientKey: String, maxConnectionPoolSize: Int) :
            this(environment, serverKey, clientKey, maxConnectionPoolSize, null)

    constructor(environment: String, serverKey: String, clientKey: String, maxConnectionPoolSize: Int, proxyConfig: ProxyConfig?) :
            this(environment, serverKey, clientKey, maxConnectionPoolSize, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT, proxyConfig)

    constructor(environment: String, serverKey: String, clientKey: String, maxConnectionPoolSize: Int,
                connectTimeout: Int, socketTimeout: Int, proxyConfig: ProxyConfig?) {
        this.environment = SnapEnvironment.valueOf(environment.toUpperCase())
        this.serverKey = serverKey
        this.clientKey = clientKey
        this.maxConnectionPoolSize = maxConnectionPoolSize
        this.proxyConfig = proxyConfig
        this.connectTimeout = connectTimeout
        this.socketTimeout = socketTimeout
    }

    companion object {
        val DEFAULT_CONNECT_TIMEOUT = 5000
        val DEFAULT_SOCKET_TIMEOUT = 30000
    }
}
