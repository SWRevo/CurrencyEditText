package id.indosw.edittextmatauang.sample;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.indosw.edittextmatauang.lib.CustomEditTextMataUang;
import id.indosw.edittextmatauang.lib.SimbolMataUang;

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
