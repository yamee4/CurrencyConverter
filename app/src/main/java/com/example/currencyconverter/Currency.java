package com.example.currencyconverter;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Currency extends Activity {
    //USA money format (12 digits, 2 decimals)
    DecimalFormat usaDF = new DecimalFormat("###,###,###,###.##");

    private final double EuroToUSD = 1.35;
    private  final char EuroSym = '€';
    private final double ColonToUSD = 0.0019;
    private  final  char ColonSym = '₡';

    //GUI widgets
    Button btnCovert, btnClear;
    EditText txtUSDollars, txtEuros, txtColones;

    @Override
    public void onCreate(Bundle savedinstanceState){

        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_main);
        // bind local controls to GUI widgets
        txtUSDollars = (EditText)findViewById(R.id.textUSDollars);
        txtEuros = (EditText)findViewById(R.id.txtEuros);
        txtColones = (EditText)findViewById(R.id.txtColon);

        btnClear = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                txtColones.setText("");
                txtEuros.setText("");
                txtUSDollars.setText("");
            }
        });

        btnCovert = (Button)findViewById(R.id.btnConvert);
        btnCovert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    String usdStr = txtUSDollars.getText().toString();
                    double usd = Double.parseDouble(usdStr);
                    String euros = EuroSym + String.valueOf(usaDF.format(usd / EuroToUSD));
                    String colones = ColonSym + String.valueOf(usaDF.format(usd / ColonToUSD));
                    txtEuros.setText(euros);
                    txtColones.setText(colones);
                }
                catch (NumberFormatException e){}

            }
        });
    }
}