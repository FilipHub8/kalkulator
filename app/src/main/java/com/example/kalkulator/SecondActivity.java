package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView Result = findViewById(R.id.result);
        Button BtnOk = findViewById(R.id.btnOk);
        Button BtnAnuluj = findViewById(R.id.btnAnuluj);

        Intent intent = getIntent();
        String cel = intent.getStringExtra("cel");
        String kmStr = intent.getStringExtra("km");
        String noclegStr = intent.getStringExtra("nocleg");
        int paliwoId = intent.getIntExtra("paliwo_id", 0);


        double km = Double.parseDouble(kmStr);
        double kosztNoclegu = Double.parseDouble(noclegStr);
        double cenaPaliwa  = 0;

        if (paliwoId == 0) {
            cenaPaliwa = 5.70; //Benzyna
        } else if (paliwoId == 1) {
            cenaPaliwa = 6.00; //Diesel
        } else if (paliwoId == 2) {
            cenaPaliwa = 3.00; //LPG
        }

        //Przyjete srednie spalanie 8/100KM
        double suma = (km * 8 / 100 * cenaPaliwa) + kosztNoclegu;

        Result.setText("Cel: " + cel + "\nSuma: " + String.format("%.2f", suma) + " zł");

        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        BtnAnuluj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}