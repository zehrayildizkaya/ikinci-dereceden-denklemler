package com.example.ikinciderecedendenklemler;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity{
    EditText a_giris;
    EditText b_giris;
    EditText c_giris;
    TextView sonucv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a_giris = findViewById(R.id.a_giris);
        b_giris = findViewById(R.id.b_giris);
        c_giris = findViewById(R.id.c_giris);
        sonucv = findViewById(R.id.sonuctxt);
        al();
        tiklama();
    }
    public void al(){
        btn = findViewById(R.id.gecis);
    }
    public void gecisYap(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void tiklama(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gecisYap();
            }
        });
    }
    public void hesapla(View view){
        int a2= Integer.parseInt(a_giris.getText().toString());
        int b2= Integer.parseInt(b_giris.getText().toString());
        int c2= Integer.parseInt(c_giris.getText().toString());
        int delta= (b2*b2)-(4*a2*c2);
        if(delta>0){
            double sonuc1 = (((-1*b2)-Math.sqrt(delta))/(2*a2));
            double sonuc2 = (((-1*b2)+Math.sqrt(delta))/(2*a2));
            if(sonuc1>0 && sonuc2>0){
                sonucv.setText("KÖK 1: " + sonuc1+ " KÖK 2: " + sonuc2);
            }
            else if(sonuc1>0){
                sonucv.setText("POZİTİF KÖK: " + sonuc1);
            }
            else if(sonuc2>0){
                sonucv.setText("POZİTİF KÖK: " + sonuc2);
            }
            else{
                sonucv.setText("POZİTİF KÖK YOK");
            }

        }
        if(delta<0){
            sonucv.setText("Denklemin gerçel kökü yok.");
        }
        if(delta ==0 ){
            double sonuc3 =((-1*b2)/ (2*a2));
            if(sonuc3>0){
                sonucv.setText("kok " + sonuc3);
            }
            else{
                sonucv.setText("POZİTİF KÖK YOK");
            }


        }


    }

}