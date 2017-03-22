package co.mailtarget.midtrans.exception

import java.lang.Exception

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class MidtransException : Exception {
    constructor() : super() {}

    constructor(message: String) : super(message) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}

    constructor(cause: Throwable) : super(cause) {}

    protected constructor(message: String, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean) : super(message, cause, enableSuppression, writableStackTrace) {}
}