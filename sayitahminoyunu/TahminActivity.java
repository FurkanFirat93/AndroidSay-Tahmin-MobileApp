package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class TahminActivity extends AppCompatActivity {
    private TextView textView_kalanHak;
    private TextView textView_yardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;

    private int rastgeleSayi;
    private int sayac =5;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textView_kalanHak = findViewById(R.id.textView_kalanHak);
        textView_yardim = findViewById(R.id.textView_yardim);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonTahmin = findViewById(R.id.buttonTahmin);

        Random r = new Random();
        rastgeleSayi = r.nextInt(101);



        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayac = sayac -1;
                int tahmin = Integer.parseInt(editTextGirdi.getText().toString());

                if(tahmin == rastgeleSayi){
                    Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("Sonuc",true );
                    startActivity(i);
                    finish();
                    return;
                }
                if(tahmin > rastgeleSayi){
                textView_yardim.setText("AZALT!");
                textView_kalanHak.setText("Kalan Hakkınız: " + sayac);
                }
                if(tahmin < rastgeleSayi){
                    textView_yardim.setText("ARTTIR!");
                    textView_kalanHak.setText("Kalan Hakkınız:" + sayac);
                }
                if(sayac==0){Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("Sonuc",false );
                    startActivity(i);
                    finish();
                    return;
                }

                editTextGirdi.setText("");

                //startActivity(new Intent(TahminActivity.this,SonucActivity.class));
                //finish();
            }
        });
    }
}