package br.ufjf.dcc196.trabalho01;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DisciplinasCursadasActivity extends AppCompatActivity {
    public DisciplinasAdapter disciplinasAdapter;
    Cursor cursorDisciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        DisciplinasDBHelper helper = new DisciplinasDBHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();



        String[] camposDisciplinas = {
                DisciplinasContract.Disciplinas._ID,
                DisciplinasContract.Disciplinas.COLLUMN_NOME,
                DisciplinasContract.Disciplinas.COLLUMN_AREA,
                DisciplinasContract.Disciplinas.COLLUMN_HORA,
                DisciplinasContract.Disciplinas.COLLUMN_ANO,
                DisciplinasContract.Disciplinas.COLLUMN_SEMESTRE,
        };

        cursorDisciplina = db.query(DisciplinasContract.Disciplinas.TABLE_NAME, camposDisciplinas, null, null, null, null, null);

        disciplinasAdapter = new DisciplinasAdapter(cursorDisciplina);
        RecyclerView rv = findViewById(R.id.rvDisciplina);
        rv.setAdapter(disciplinasAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
