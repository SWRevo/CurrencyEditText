package id.indosw.edittextmatauang.lib

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

@Suppress("PrivatePropertyName")
class CustomEditTextMataUang : AppCompatEditText {
    private var current = ""
    private val editText = this@CustomEditTextMataUang

    //properties
    private var Currency = ""
    private var Separator = ","
    private var Spacing = false
    private var Delimiter = false
    private var Decimals = true

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context!!, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
                if (s.toString() != current) {
                    editText.removeTextChangedListener(this)
                    val cleanString = s.toString().replace("[$,.]".toRegex(), "").replace(Currency.toRegex(), "").replace("\\s+".toRegex(), "")
                    if (cleanString.isNotEmpty()) {
                        try {
                            val currencyFormat: String = if (Spacing) {
                                if (Delimiter) {
                                    "$Currency. "
                                } else {
                                    "$Currency "
                                }
                            } else {
                                if (Delimiter) {
                                    "$Currency."
                                } else {
                                    Currency
                                }
                            }
                            val parsed: Double
                            val parsedInt: Int
                            val formatted: String
                            if (Decimals) {
                                parsed = cleanString.toDouble()
                                formatted = NumberFormat.getCurrencyInstance().format(parsed / 100).replace(NumberFormat.getCurrencyInstance().currency!!.symbol, currencyFormat)
                            } else {
                                parsedInt = cleanString.toInt()
                                formatted = currencyFormat + NumberFormat.getNumberInstance(Locale.US).format(parsedInt.toLong())
                            }
                            current = formatted

                            //if decimals are turned off and Separator is set as anything other than commas..
                            if (Separator != "," && !Decimals) {
                                //..replace the commas with the new separator
                                editText.setText(formatted.replace(",".toRegex(), Separator))
                            } else {
                                //since no custom separators were set, proceed with comma separation
                                editText.setText(formatted)
                            }
                            editText.setSelection(formatted.length)
                        } catch (ignored: NumberFormatException) {
                        }
                    }
                    editText.addTextChangedListener(this)
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }

    /*
    *
    */
    val cleanDoubleValue: Double
        get() {
            var value = 0.0
            if (Decimals) {
                value = editText.text.toString().trim { it <= ' ' }.replace("[$,]".toRegex(), "").replace(Currency.toRegex(), "").toDouble()
            } else {
                val cleanString = editText.text.toString().trim { it <= ' ' }.replace("[$,.]".toRegex(), "").replace(Currency.toRegex(), "").replace("\\s+".toRegex(), "")
                try {
                    value = cleanString.toDouble()
                } catch (ignored: NumberFormatException) {
                }
            }
            return value
        }
    val cleanIntValue: Int
        get() {
            var value = 0
            if (Decimals) {
                val doubleValue = editText.text.toString().trim { it <= ' ' }.replace("[$,]".toRegex(), "").replace(Currency.toRegex(), "").toDouble()
                value = doubleValue.roundToInt()
            } else {
                val cleanString = editText.text.toString().trim { it <= ' ' }.replace("[$,.]".toRegex(), "").replace(Currency.toRegex(), "").replace("\\s+".toRegex(), "")
                try {
                    value = cleanString.toInt()
                } catch (ignored: NumberFormatException) {
                }
            }
            return value
        }

    fun setDecimals(value: Boolean) {
        Decimals = value
    }

    fun setCurrency(currencySymbol: String) {
        Currency = currencySymbol
    }

    fun setSpacing(value: Boolean) {
        Spacing = value
    }

    fun setDelimiter(value: Boolean) {
        Delimiter = value
    }

    /**
     * Separator allows a custom symbol to be used as the thousand separator. Default is set as comma (e.g: 20,000)
     *
     *
     * Custom Separator cannot be set when Decimals is set as `true`. Set Decimals as `false` to continue setting up custom separator
     *
     * @value is the custom symbol sent in place of the default comma
     */
    fun setSeparator(value: String) {
        Separator = value
    }
}