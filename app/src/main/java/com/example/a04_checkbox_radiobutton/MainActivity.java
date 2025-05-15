package com.example.a04_checkbox_radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  RadioButton radioDecimal;
    private RadioButton radioBinario;
    private RadioButton radioOctal;
    private  RadioButton radioHexadecimal;

    private  CheckBox cbBinario ;
    private  CheckBox cbOctal;
    private  CheckBox cbHexadecimal;

    private TextView resBinario;
    private TextView resOctal;
    private  TextView resHexa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioDecimal=findViewById(R.id.radio_decimal);
        radioBinario=findViewById(R.id.radio_binario);
        radioOctal=findViewById(R.id.radio_octal);
        radioHexadecimal=findViewById(R.id.radio_hexa);

        radioDecimal.setOnClickListener (this);
        radioBinario.setOnClickListener (this);

        cbBinario= findViewById(R.id.cb_binario);
        cbOctal = findViewById(R.id.cb_octal);
        cbHexadecimal = findViewById(R.id.cb_hexadecimal);
//ponerle el escuchador on click
        cbBinario.setOnClickListener (this);

        resBinario = findViewById(R.id.res_binario);
        resOctal = findViewById(R.id.res_octal);
        resHexa = findViewById(R.id.res_hexa);

        cbBinario.setEnabled(false);
        cbOctal.setEnabled(false);
        cbHexadecimal.setEnabled(false);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    public void onClick(View v) {

        if (radioBinario.isChecked() || radioDecimal.isChecked()|| radioOctal.isChecked()
                || radioHexadecimal.isChecked()){
            cbBinario.setEnabled(true);
            cbOctal.setEnabled(true);
            cbHexadecimal.setEnabled(true);
        }
        //check box Binario***************************************
        if (cbBinario.isChecked()){
            if (radioBinario.isChecked()){
                resBinario.setText("Binario" );
            } if(radioOctal.isChecked()){
                resBinario.setText("octal" );
            } if(radioHexadecimal.isChecked()){
                resBinario.setText("RHhexadecimal" );
            }if(radioDecimal.isChecked()){
                resBinario.setText("RDdecimal" );
            }
        }//check box Binario*******************************
        else if (cbBinario.isChecked()==false ){
            resBinario.setText("" );
        }

        if (cbOctal.isChecked()){
            if (radioBinario.isChecked()){
                resOctal.setText("Binario" );
            } if(radioOctal.isChecked()){
                resOctal.setText("Octal" );
            } if(radioHexadecimal.isChecked()){
                resOctal.setText("Hexadecimal" );
            }if(radioDecimal.isChecked()){
                resOctal.setText("Decimal" );
            }
        } else if (cbOctal.isChecked()==false ){
            resOctal.setText("" );
        }

        if (cbHexadecimal.isChecked()){
            if (radioBinario.isChecked()){
                resHexa.setText("Binario" );
            } if(radioOctal.isChecked()){
                resHexa.setText("Octal" );
            } if(radioHexadecimal.isChecked()){
                resHexa.setText("Hexadecimal" );
            }if(radioDecimal.isChecked()){
                resHexa.setText("Decimal" );
            }
        }else if (cbHexadecimal.isChecked()==false ){
            resHexa.setText("" );
        }



    }
}//Class