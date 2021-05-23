# CurrencyEditText
[![](https://jitpack.io/v/SWRevo/CurrencyEditText.svg)](https://jitpack.io/#SWRevo/CurrencyEditText)

## Implementation in Android Studio or Sketchware
## Gradle
Add the following to your `build.gradle` to use:
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.SWRevo:CurrencyEditText:v1.1.0'
}
```

## Usage

```xml

    <id.indosw.edittextmatauang.lib.CustomEditTextMataUang
        android:id="@+id/etInput"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Input Amount"
        android:inputType="number"
        android:textSize="24sp"
        tools:ignore="HardcodedText" />

```

## KOTLIN

```java

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

```

## JAVA

```java

public class JavaSampleActivity extends AppCompatActivity {

    CustomEditTextMataUang etInput;
    Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnProcess = findViewById(R.id.btnProcess);

        etInput.setCurrency(SimbolMataUang.INDONESIA);
        etInput.setDelimiter(false);
        etInput.setSpacing(false);
        etInput.setDecimals(true);
        etInput.setSeparator(".");

        btnProcess.setOnClickListener(view -> {
            if(etInput.length() != 0) {
                double cleanDoubleOutput = etInput.getCleanDoubleValue();
                int cleanIntOutput = etInput.getCleanIntValue();

                Toast.makeText(JavaSampleActivity.this, "Clean Double: " + cleanDoubleOutput, Toast.LENGTH_LONG).show();
                Toast.makeText(JavaSampleActivity.this, "Clean Integer: " + cleanIntOutput, Toast.LENGTH_LONG).show();
            }
        });
    }
}

```

## License

MIT License

Copyright (c) [2021] [IndoSW]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
