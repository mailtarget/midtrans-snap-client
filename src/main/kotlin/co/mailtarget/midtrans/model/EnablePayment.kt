package co.mailtarget.midtrans.model

/**
 *
 * @author masasdani
 * @since 3/22/17
 */
enum class EnablePayment(val type: String) {
    CREDIT_CARD("credit_card"),
    MANDIRI_CLICKPAY("mandiri_clickpay"),
    CIMB_CLICKS("cimb_clicks"),
    BCA_KLIKBCA("bca_klikbca"),
    BCA_KLIKPAY("bca_klikpay"),
    BRI_EPAY("bri_epay"),
    TELKOMSEL_CASH("telkomsel_cash"),
    ECHANNEL("echannel"),
    BBM_MONEY("bbm_money"),
    XL_TUNAI("xl_tunai"),
    INDOSAT_DOMPETKU("indosat_dompetku"),
    MANDIRI_ECASH("mandiri_ecash"),
    PERMATA_VA("permata_va"),
    BCA_VA("bca_va"),
    OTHER_VA("other_va"),
    KIOSON("kioson"),
    INDOMARET("indomaret"),
    GCI("gci");

    override fun toString(): String {
        return type
    }
}