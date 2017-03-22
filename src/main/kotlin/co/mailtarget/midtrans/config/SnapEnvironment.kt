package co.mailtarget.midtrans.config

import java.net.URI

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
enum class SnapEnvironment {
    PRODUCTION{
        override val url: URI = URI.create("https://app.midtrans.com/snap/v1/transactions")
    },
    SANDBOX{
        override val url: URI = URI.create("https://app.sandbox.midtrans.com/snap/v1/transactions")
    };

    abstract val url: URI
}