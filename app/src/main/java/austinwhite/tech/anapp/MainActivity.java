package austinwhite.tech.anapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;


import android.os.Bundle;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    RadioButton euroToUSD;
    RadioButton usdToEuro;
    RadioButton customExchange;
    EditText input;
    EditText customInput;
    TextView output;
    ImageButton convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euroToUSD = findViewById(R.id.eurotousd);
        usdToEuro = findViewById(R.id.usdtoeuro);
        customExchange = findViewById(R.id.customrate);
        input = findViewById(R.id.input);
        customInput = findViewById(R.id.custominput);
        output = findViewById(R.id.output);
        convert = findViewById(R.id.convertbutton);


        convert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (euroToUSD.isChecked()) { //0.89
                    String sign = getString(R.string.dollarsign);
                    Double conversionRate = 0.89;
                    convert(sign, conversionRate);

                } else if (usdToEuro.isChecked()) { //1.13
                    String sign = getString(R.string.eurosign);
                    Double conversionRate = 1.13;
                    convert(sign, conversionRate);

                } else if (customExchange.isChecked()){
                    String customCheck = customInput.getText().toString();
                    if (customCheck.isEmpty()) {
                        output.setText(R.string.blank);
                    } else {
                        String sign = " ";
                        String custom = customInput.getText().toString();
                        Double conversionRate = Double.parseDouble(custom) * 0.01;
                        convert(sign, conversionRate);
                    }

                } else {
                    output.setText(getString(R.string.error));

                }
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void convert(String sign, Double conversionRate) {
        String pattern = "###,##0.00";
        final DecimalFormat decimalFormat = new DecimalFormat(pattern);

        String inputCheck = String.valueOf(input.getText());

        if (inputCheck.isEmpty()) {
            output.setText(getString(R.string.error));

        } else {
            double userinput = Double.parseDouble(inputCheck);
            double converted = userinput * conversionRate;
            String format = decimalFormat.format(converted);
            output.setText(sign + format);
        }

    }

}