package br.ufjf.dcc196.trabalho01;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class NovoPlanejamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);

        Bundle bundle = getIntent().getExtras();

        Button btnCadastraPlanejamento = findViewById(R.id.btnCadastraPlanejamento);

        btnCadastraPlanejamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        PlanejamentosDBHelper helper = new PlanejamentosDBHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        EditText etAno = findViewById(R.id.etAno);
        EditText etLinguas = findViewById(R.id.etLingua);
        EditText etHumanas = findViewById(R.id.etHumanas);
        EditText etExatas = findViewById(R.id.etExatas);
        EditText etSaude = findViewById(R.id.etSaude);
        EditText etSemestre = findViewById((R.id.etSemestre));

        int countHoras = Integer.valueOf(etLinguas.getText().toString())+Integer.valueOf(etHumanas.getText().toString())+Integer.valueOf(etExatas.getText().toString())+Integer.valueOf(etSaude.getText().toString());


        ContentValues values =  new ContentValues();
        values.put(PlanejamentosContract.Planejamentos.COLLUMN_ANO, String.valueOf(etAno.getText()));
        values.put(PlanejamentosContract.Planejamentos.COLLUMN_SEMESTRE, String.valueOf(etSemestre.getText()));
        values.put(PlanejamentosContract.Planejamentos.COLLUMN_HORAS, String.valueOf(countHoras));
        values.put(PlanejamentosContract.Planejamentos.COLLUMN_LINGUAS, String.valueOf(etLinguas.getText()));
        values.put(PlanejamentosContract.Planejamentos.COLLUMN_HUMANAS, String.valueOf(etHumanas.getText()));
        values.put(PlanejamentosContract.Planejamentos.COLLUMN_EXATAS, String.valueOf(etExatas.getText()));
        values.put(PlanejamentosContract.Planejamentos.COLLUMN_SAUDE, String.valueOf(etSaude.getText()));

        db.insert(PlanejamentosContract.Planejamentos.TABLE_NAME, null, values);

        setResult(Activity.RESULT_OK);
        finish();
            }
        });
    }
}
