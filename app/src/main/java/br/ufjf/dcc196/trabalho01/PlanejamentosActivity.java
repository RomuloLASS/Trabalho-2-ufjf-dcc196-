    package br.ufjf.dcc196.trabalho01;

    import android.content.ContentValues;
    import android.content.Intent;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.media.Image;
    import android.os.Bundle;
    import android.os.Parcelable;
    import android.support.annotation.Nullable;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import java.io.Serializable;
    import java.util.ArrayList;

    public class PlanejamentosActivity extends AppCompatActivity {
        public static final int REQUEST_PLANEJAMENTO = 1;
        public static final int REQUEST_MATERIA = 2;
        Cursor cursorPlanrjamento;
        public PlanejamentoAdapter planejamentoAdapter;


        RecyclerView rv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.planejamentos_activity);

            Button btnPlanejamento = findViewById(R.id.btnPlanejamento);
            Button btnMateria = findViewById(R.id.btnMateria);

            PlanejamentosDBHelper helper = new PlanejamentosDBHelper(getApplicationContext());
            SQLiteDatabase db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DisciplinasContract.Disciplinas.COLLUMN_ANO, "2016");
            values.put(DisciplinasContract.Disciplinas.COLLUMN_SEMESTRE, "2");
            values.put(DisciplinasContract.Disciplinas.COLLUMN_NOME, "Matematica");
            values.put(DisciplinasContract.Disciplinas.COLLUMN_AREA, "Exatas");
            values.put(DisciplinasContract.Disciplinas.COLLUMN_HORA, "10");
            db.insert(DisciplinasContract.Disciplinas.TABLE_NAME, null, values);

            String[] camposPlanejamento = {
                    PlanejamentosContract.Planejamentos._ID,
                    PlanejamentosContract.Planejamentos.COLLUMN_ANO,
                    PlanejamentosContract.Planejamentos.COLLUMN_SEMESTRE,
                    PlanejamentosContract.Planejamentos.COLLUMN_HORAS,
                    PlanejamentosContract.Planejamentos.COLLUMN_LINGUAS,
                    PlanejamentosContract.Planejamentos.COLLUMN_HUMANAS,
                    PlanejamentosContract.Planejamentos.COLLUMN_EXATAS,
                    PlanejamentosContract.Planejamentos.COLLUMN_SAUDE,
            };

            cursorPlanrjamento = db.query(PlanejamentosContract.Planejamentos.TABLE_NAME, camposPlanejamento, null, null, null, null, null);


            planejamentoAdapter = new PlanejamentoAdapter(cursorPlanrjamento);
            RecyclerView rv = findViewById(R.id.rvPlanejamentos);
            rv.setAdapter(planejamentoAdapter);
            rv.setLayoutManager(new LinearLayoutManager(this));

            planejamentoAdapter.setOnPlanejamentoClickListener(new PlanejamentoAdapter.OnPlanejamentoClickListener() {
                @Override
                public void onPlanejamentoClick(View livroView, int position) {
                    Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                    startActivity(intent);
                }
            });

            btnPlanejamento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
                    startActivityForResult(intent, PlanejamentosActivity.REQUEST_PLANEJAMENTO);
                }
            });

            btnMateria.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PlanejamentosActivity.this, NovaDisciplinaCursadaActivity.class);
                    startActivityForResult(intent, PlanejamentosActivity.REQUEST_MATERIA);
                }
            });
        }
    }
