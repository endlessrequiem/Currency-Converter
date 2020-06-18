package austinwhite.tech.anapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CheckBox usd;
    CheckBox euro;
    EditText input;
    TextView output;
    ImageButton convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usd = findViewById(R.id.usdcheck);
        euro = findViewById(R.id.eurocheck);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        convert = findViewById(R.id.convertbutton);



        convert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (usd.isChecked() && euro.isChecked()) {
                    output.setText(getString(R.string.checkone));

                } else if (usd.isChecked()) { //0.89
                    String inusd = input.getText().toString();
                    double userinputusd = Double.parseDouble(inusd);
                    double convertedusd = userinputusd * 0.89;
                    output.setText("€" + convertedusd);

                } else if (euro.isChecked()) { //1.13
                    String ineuro = input.getText().toString();
                    double userinputeuro = Double.parseDouble(ineuro);
                    double convertedeuro = userinputeuro * 1.13;
                    output.setText("$" + convertedeuro);

                }  else {
                    output.setText(getString(R.string.nonumber));

                }
            }
        });

    }

}