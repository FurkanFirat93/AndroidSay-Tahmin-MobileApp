package com.example.sayitahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private ImageView imageView_sonuc;
    private TextView textView_Kaybettin;
    private Button button_tekrarOyna;
    private boolean sonuc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        imageView_sonuc = findViewById(R.id.imageView_sonuc);
        textView_Kaybettin = findViewById(R.id.textView_Kaybettin);
        button_tekrarOyna = findViewById(R.id.button_tekrarOyna);
        sonuc = getIntent().getBooleanExtra("sonuç", false);

        if (sonuc){
            textView_Kaybettin.setText("KAZANDINIZ !");
            imageView_sonuc.setImageResource(R.drawable.mutlu_resim);
        }
        else{
            textView_Kaybettin.setText("KAYBETTİNİZ !");
            imageView_sonuc.setImageResource(R.drawable.mutsuz_resim);
        }
        button_tekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SonucActivity.this,TahminActivity.class));
                finish();
            }
        });
    }
}