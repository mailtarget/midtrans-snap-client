package co.mailtarget.midtrans.config

/**
 * Proxy config constructor.
 * @param host the proxy server host address.
 * *
 * @param port the proxy server listening port.
 * *
 * @param username the username used to authenticate against the proxy server.
 * *
 * @param password the password used to authenticate against the proxy server.
 */
class ProxyConfig(
        /**
         * Get merchant proxy host configuration.
         * @return Merchant proxy host config.
         */
        val host: String?,
        /**
         * Get merchant proxy port configuration
         * @return Merchant proxy port config
         */
        val port: Int,
        /**
         * Get proxy username to connect to Veritrans API
         * @return Merchant proxy username config
         */
        val username: String?,
        /**
         * Get proxy password to connect to Veritrans API
         * @return Merchant proxy password config
         */
        val password: String?) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as ProxyConfig?

        if (port != that!!.port) return false
        if (if (host != null) host != that.host else that.host != null) return false
        if (if (password != null) password != that.password else that.password != null) return false
        if (if (username != null) username != that.username else that.username != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = host?.hashCode() ?: 0
        result = 31 * result + port
        result = 31 * result + (username?.hashCode() ?: 0)
        result = 31 * result + (password?.hashCode() ?: 0)
        return result
    }
}