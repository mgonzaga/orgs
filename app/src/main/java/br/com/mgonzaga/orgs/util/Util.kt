package br.com.mgonzaga.orgs.util

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class Util {
    private val language: String = "pt"
    private val country: String = "br"
    fun getCurrencyValue(value: BigDecimal): String
    {
        val currencyInstance = NumberFormat.getCurrencyInstance(
            Locale(language, country)
        )
        return currencyInstance.format(value)
    }
}