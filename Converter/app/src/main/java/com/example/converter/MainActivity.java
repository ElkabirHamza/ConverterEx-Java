package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText ed;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("MAD");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.sp1);
        sItems.setAdapter(adapter);
        List<String> spinnerArray2 =  new ArrayList<String>();
        spinnerArray2.add("USD");
        spinnerArray2.add("EUR");
        spinnerArray2.add("CAD");
        spinnerArray2.add("EUR");
        spinnerArray2.add("GBP");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems2 = (Spinner) findViewById(R.id.sp2);
        sItems2.setAdapter(adapter2);

        ed=findViewById(R.id.input);
        b=findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;
                Double amount = Double.parseDouble(ed.getText().toString());
                if(sItems2.getSelectedItem().toString() =="USD"){
                    tot= amount * 0.097;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sItems2.getSelectedItem().toString() =="EUR"){
                    tot= amount * 0.091;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sItems2.getSelectedItem().toString() =="CAD"){
                    tot= amount * 0.13;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sItems2.getSelectedItem().toString() =="GBP"){
                    tot= amount * 0.080;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}