package id.indosw.edittextmatauang.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.indosw.edittextmatauang.lib.CustomEditTextMataUang
import id.indosw.edittextmatauang.lib.SimbolMataUang

class KotlinSampleActivity : AppCompatActivity() {
    private var etInput: CustomEditTextMataUang? = null
    private var btnProcess: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etInput = findViewById<View>(R.id.etInput) as CustomEditTextMataUang
        btnProcess = findViewById<View>(R.id.btnProcess) as Button
        etInput!!.setCurrency(SimbolMataUang.USA)
        etInput!!.setDelimiter(false)
        etInput!!.setSpacing(false)
        etInput!!.setDecimals(false)
        etInput!!.setSeparator(",")
        btnProcess!!.setOnClickListener {
            if (etInput!!.length() != 0) {
                val cleanDoubleOutput = etInput!!.cleanDoubleValue
                val cleanIntOutput = etInput!!.cleanIntValue
                Toast.makeText(this@KotlinSampleActivity, "Clean Double: $cleanDoubleOutput", Toast.LENGTH_LONG).show()
                Toast.makeText(this@KotlinSampleActivity, "Clean Integer: $cleanIntOutput", Toast.LENGTH_LONG).show()
            }
        }
    }
}