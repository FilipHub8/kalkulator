package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText Cel, KM, Nocleg;
    Spinner Paliwo;
    TextView Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cel = findViewById(R.id.Cel);
        KM = findViewById(R.id.KM);
        Nocleg = findViewById(R.id.Nocleg);
        Paliwo = findViewById(R.id.Paliwo);
        Status = findViewById(R.id.Status);
        Button PrzyciskOblicz = findViewById(R.id.PrzyciskOblicz);

        PrzyciskOblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celValue = Cel.getText().toString();
                String kmValue = KM.getText().toString();
                String noclegValue = Nocleg.getText().toString();
                int paliwoId = Paliwo.getSelectedItemPosition();


                if (celValue.isEmpty() || kmValue.isEmpty() || noclegValue.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Podaj cel, dystans i koszt noclegu!", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("cel", celValue);
                    intent.putExtra("km", kmValue);
                    intent.putExtra("nocleg", noclegValue);
                    intent.putExtra("paliwo_id", paliwoId);

                    startActivityForResult(intent, 1);
                }
            }
        });
    }


}