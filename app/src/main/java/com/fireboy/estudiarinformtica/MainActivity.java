package com.fireboy.estudiarinformtica;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spCiclo, spPoblacion, spTipo;
    TextView lblInfo;
    Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCiclo = findViewById(R.id.spCiclo);
        spPoblacion = findViewById(R.id.spPoblacion);
        spTipo = findViewById(R.id.spTipo);
        lblInfo = findViewById(R.id.lblInfo);
        btnBorrar = findViewById(R.id.btnBorrar);

        ArrayAdapter<CharSequence> adapterCiclo = ArrayAdapter.createFromResource(this, R.array.ciclos, android.R.layout.simple_spinner_item);
        adapterCiclo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiclo.setAdapter(adapterCiclo);

        ArrayAdapter<CharSequence> adapterPoblacion = ArrayAdapter.createFromResource(this, R.array.pueblos, android.R.layout.simple_spinner_item);
        adapterPoblacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPoblacion.setAdapter(adapterPoblacion);

        ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(this, R.array.tipos, android.R.layout.simple_spinner_item);
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adapterTipo);

        itemSelectedListener();

        btnBorrar.setOnClickListener(v -> borrar());
    }

    private void actualizarInfo() {
        String ciclo = spCiclo.getSelectedItem().toString();
        String poblacion = spPoblacion.getSelectedItem().toString();
        String tipo = spTipo.getSelectedItem().toString();

        lblInfo.setText(String.format("%s en %s de forma %s", ciclo, poblacion, tipo));
    }

    private void borrar() {
        lblInfo.setText("");
    }

    private void itemSelectedListener() {
        spCiclo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                actualizarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spPoblacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                actualizarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                actualizarInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }
}