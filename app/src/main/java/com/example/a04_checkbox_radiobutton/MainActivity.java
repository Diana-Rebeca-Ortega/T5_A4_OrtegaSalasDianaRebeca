package com.example.a04_checkbox_radiobutton;

import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "MainActivity";

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

    private EditText  cajaNumIngresado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cajaNumIngresado = findViewById(R.id.caja_num_ingresado);

        radioDecimal=findViewById(R.id.radio_decimal);
        radioBinario=findViewById(R.id.radio_binario);
        radioOctal=findViewById(R.id.radio_octal);
        radioHexadecimal=findViewById(R.id.radio_hexa);

        radioDecimal.setOnClickListener (this);
        radioBinario.setOnClickListener (this);
        radioOctal.setOnClickListener(this);
        radioHexadecimal.setOnClickListener(this);

        cbBinario= findViewById(R.id.cb_binario);
        cbOctal = findViewById(R.id.cb_octal);
        cbHexadecimal = findViewById(R.id.cb_hexadecimal);
//ponerle el escuchador on click
        cbBinario.setOnClickListener (this);
        cbOctal.setOnClickListener(this);
        cbHexadecimal.setOnClickListener(this);

        resBinario = findViewById(R.id.res_binario);
        resOctal = findViewById(R.id.res_octal);
        resHexa = findViewById(R.id.res_hexa);

        cbBinario.setEnabled(false);
        cbOctal.setEnabled(false);
        cbHexadecimal.setEnabled(false);

        cajaNumIngresado.setEnabled(false);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    public void onClick(View v) {
//habilitar los checkbox
        if (radioBinario.isChecked() || radioDecimal.isChecked()|| radioOctal.isChecked()
                || radioHexadecimal.isChecked()){
            cajaNumIngresado.setEnabled(true);
            cbBinario.setEnabled(true);
            cbOctal.setEnabled(true);
            cbHexadecimal.setEnabled(true);
        }
        validacionSistemaNumerico(radioDecimal,"D");
        validacionSistemaNumerico(radioBinario,"B");
        validacionSistemaNumerico(radioOctal,"O");
        validacionSistemaNumerico(radioHexadecimal,"H");
        //check box Binario***************************************
        if (cbBinario.isChecked()){
            //de binario a binario
            if (radioBinario.isChecked()){
                resBinario.setText(cajaNumIngresado.getText()+"" );
            }// de octal a binario
            if(radioOctal.isChecked()){
               String binario =String.valueOf(
                       Integer.toBinaryString (Integer.parseInt(String.valueOf(cajaNumIngresado.getText()),8))
               );
                resBinario.setText(binario);
            }//de hexadecimal a binario
            if(radioHexadecimal.isChecked()){
                String binario =String.valueOf(
                        Integer.toBinaryString (Integer.parseInt(String.valueOf(cajaNumIngresado.getText()),16))
                );
                resBinario.setText(binario);
            }//de decimal a binario
            if(radioDecimal.isChecked()){
                resBinario.setText(
                        Integer.toBinaryString(Integer.parseInt(cajaNumIngresado.getText()+"")) );
            }
        }//check box Binario
        else if (cbBinario.isChecked()==false ){
            resBinario.setText("" );
        }
//------------------------------checkbox octal-----------------------------------------
        if (cbOctal.isChecked()){
            //de binario a octal
            if (radioBinario.isChecked()){
                String octal =String.valueOf(
                        Integer.toOctalString (Integer.parseInt(String.valueOf(cajaNumIngresado.getText()),2))
                );
                resOctal.setText(octal );
            }
            // de octal a octal
            if(radioOctal.isChecked()){
                resOctal.setText(cajaNumIngresado.getText() );
            }
            // de hexadecimal a octal
            if(radioHexadecimal.isChecked()){
                String octal =String.valueOf(
                        Integer.toOctalString (Integer.parseInt(String.valueOf(cajaNumIngresado.getText()),16))
                );
                resOctal.setText(octal );
            }
            // de decimal a octal
            if(radioDecimal.isChecked()){
                resOctal.setText(
                        Integer.toOctalString(Integer.parseInt(cajaNumIngresado.getText()+"")) );
            }
        } else if (cbOctal.isChecked()==false ){
            resOctal.setText("" );
        }
//-------------------------------check Hexadecimal-----------------------------
        if (cbHexadecimal.isChecked()){
            //de binario a hexadecimal
            if (radioBinario.isChecked()){
                String hexadecimal =String.valueOf(
                        Integer.toHexString (Integer.parseInt(String.valueOf(cajaNumIngresado.getText()),2))
                );
                resHexa.setText(hexadecimal );
            }
            // de octal a hexadecimal
            if(radioOctal.isChecked()){
                String hexadecimal =String.valueOf(
                        Integer.toHexString (Integer.parseInt(String.valueOf(cajaNumIngresado.getText()),8))
                );
                resHexa.setText(hexadecimal );
            }
            //de hexadecimal a hexadecimal
            if(radioHexadecimal.isChecked()){
                resHexa.setText(cajaNumIngresado.getText() );
            }
            //de decimal a hexadecimal
            if(radioDecimal.isChecked()){
                resHexa.setText(
                        Integer.toHexString(Integer.parseInt(cajaNumIngresado.getText()+"")) );

            }
        }else if (cbHexadecimal.isChecked()==false ){
            resHexa.setText("" );
        }



    }

    public void validacionSistemaNumerico (RadioButton rad, String sd ){
        if(sd.equals("D")){
        if(rad.isChecked()){
           cajaNumIngresado.getText();
            String digito;
            for (int i =0; i < cajaNumIngresado.getText().length(); i++ ){
                digito=  String.valueOf(cajaNumIngresado.getText()).substring(i,i+1);
                switch (digito){
                    case "1": case"2":case"3":case"4":case"5":case"6":case"7":case"8":case"9":case"0":
                        break;
                    default:
                        cajaNumIngresado.setText("");
                        Toast.makeText(this, "NO es un numero decimal" , Toast.LENGTH_SHORT).show();
                        Log.e(TAG  ,"NOOO es un numero decimal");
                        cbBinario.setChecked(false);
                        cbOctal.setChecked(false);
                        cbHexadecimal.setChecked(false);
                }//switch
            }//for
        }//if
        }//if Si es decimal
        else if(sd.equals("B")){
            if(rad.isChecked()){
                cajaNumIngresado.getText();
                String digito;
                for (int i =0; i < cajaNumIngresado.getText().length(); i++ ){
                    digito=  String.valueOf(cajaNumIngresado.getText()).substring(i,i+1);
                    switch (digito){
                        case "1": case"0":
                            break;
                        default:
                            cajaNumIngresado.setText("");
                            Toast.makeText(this, "NO es un numero binario" , Toast.LENGTH_SHORT).show();
                            Log.e(TAG  ,"NOOO es un numero binario");
                            cbBinario.setChecked(false);
                            cbOctal.setChecked(false);
                            cbHexadecimal.setChecked(false);
                    }//switch
                }//for
            }//if
        }//if Si es binario
        else if(sd.equals("O")){
            if(rad.isChecked()){
                cajaNumIngresado.getText();
                String digito;
                for (int i =0; i < cajaNumIngresado.getText().length(); i++ ){
                    digito=  String.valueOf(cajaNumIngresado.getText()).substring(i,i+1);
                    switch (digito){
                        case "1": case"0":case"2":case"3":case"4":case"5":case"6":case"7":
                            break;
                        default:
                            cajaNumIngresado.setText("");
                            Toast.makeText(this, "NO es un numero octal" , Toast.LENGTH_SHORT).show();
                            Log.e(TAG  ,"NOOO es un numero octal");
                            cbBinario.setChecked(false);
                            cbOctal.setChecked(false);
                            cbHexadecimal.setChecked(false);
                    }//switch
                }//for
            }//if
        }//if Si es octal

        else if(sd.equals("H")){
            if(rad.isChecked()){
                cajaNumIngresado.getText();
                String digito;
                for (int i =0; i < cajaNumIngresado.getText().length(); i++ ){
                    digito=  String.valueOf(cajaNumIngresado.getText()).substring(i,i+1);
                    switch (digito){
                        case "0": case"1":case"2":case"3":case"4":case"5":case"6":case"7":case"8":case"9":
                        case"A":case"B":case"C":case"D":case"E":case"F":
                        case"a":case"b":case"c":case"d":case"e":case"f":
                            break;
                        default:
                            cajaNumIngresado.setText("");
                            Toast.makeText(this, "NO es un numero hexadecimal" , Toast.LENGTH_SHORT).show();
                            Log.e(TAG  ,"NOOO es un numero hexadecimal");
                            cbBinario.setChecked(false);
                            cbOctal.setChecked(false);
                            cbHexadecimal.setChecked(false);
                    }//switch
                }//for
            }//if
        }//if Si es hexadecimal

    }//metodo validacion datos
}//Class