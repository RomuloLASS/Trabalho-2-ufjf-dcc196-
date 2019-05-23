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

public class NovaDisciplinaCursadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina_cursada);

        Toast.makeText(getApplicationContext(),"NovaDisciplinaCursadaActivity criada", Toast.LENGTH_SHORT).show();

        Button btnCadastra = findViewById(R.id.btnCadastraMateria);

        btnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisciplinasDBHelper helper = new DisciplinasDBHelper(getApplicationContext());
                SQLiteDatabase db = helper.getWritableDatabase();

                EditText etNome = findViewById(R.id.etNomeMateria);
                EditText etTotalHoras = findViewById(R.id.etTotalHoras);
                EditText etArea = findViewById(R.id.etArea);
                EditText etAno = findViewById(R.id.etAno);
                EditText etSemestre = findViewById(R.id.etSemestre);

                ContentValues values =  new ContentValues();
                values.put(DisciplinasContract.Disciplinas.COLLUMN_NOME, String.valueOf(etNome.getText()));
                values.put(DisciplinasContract.Disciplinas.COLLUMN_AREA, String.valueOf(etArea.getText()));
                values.put(DisciplinasContract.Disciplinas.COLLUMN_HORA, String.valueOf(etTotalHoras.getText()));
                values.put(DisciplinasContract.Disciplinas.COLLUMN_ANO, String.valueOf(etAno.getText()));
                values.put(DisciplinasContract.Disciplinas.COLLUMN_SEMESTRE, String.valueOf(etSemestre.getText()));

                db.insert(DisciplinasContract.Disciplinas.TABLE_NAME, null, values);

                finish();
            }
        });
    }
}
