package com.jorgenicolas.android.imc1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText campoPeso;
    private EditText campoEstatura;
    private Button botonCalcular;
    private Button botonLimpiar;
    private TextView textoImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoPeso = (EditText) findViewById(R.id.campo_peso);
        campoEstatura = (EditText) findViewById(R.id.campo_estatura);
        botonCalcular = (Button) findViewById(R.id.boton_calcular);
        botonLimpiar = (Button) findViewById(R.id.boton_limpiar);
        textoImc = (TextView) findViewById(R.id.texto_imc);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = campoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = campoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / Math.pow(estatura, 2);
                s = Double.toString(imc);
                textoImc.setText(s);
            }
        });

        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campoPeso.setText("");
                campoEstatura.setText("");
                textoImc.setText("0.0");
            }
        });
    }
}
