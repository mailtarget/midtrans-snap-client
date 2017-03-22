package co.mailtarget.midtrans.model

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
class CustomerDetails(firstName: String, lastName: String, email: String, phone: String) {
    var firstName: String? = firstName
    var lastName: String? = lastName
    var email: String? = email
    var phone: String? = phone
    var billingAddress: Address? = null
    var shippingAddress: Address? = null

    class Address(firstName: String, lastName: String, email: String, phone: String) {
        var firstName: String? = firstName
        var lastName: String? = lastName
        var email: String? = email
        var phone: String? = phone
        var city: String? = null
        var postalCode: String? = null
        var countryCode: String? = null
    }

    init {
        this.billingAddress = Address(firstName, lastName, email, phone)
        this.shippingAddress = Address(firstName, lastName, email, phone)
    }
}