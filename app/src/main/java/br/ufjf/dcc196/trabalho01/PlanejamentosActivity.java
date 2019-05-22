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

        //ArrayList<Planejamentos> planejamentos = new ArrayList<>();

        RecyclerView rv;
        //PlanejamentosAdapter pAdapter;

        private void rvAtt (){

        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.planejamentos_activity);

            Button btnPlanejamento = findViewById(R.id.btnPlanejamento);
            Button btnMateria = findViewById(R.id.btnMateria);

            PlanejamentosDBHelper helper = new PlanejamentosDBHelper(getApplicationContext());
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values =  new ContentValues();
            values.put(PlanejamentosContract.Planejamentos.COLLUMN_ANO, "2016");
            values.put(PlanejamentosContract.Planejamentos.COLLUMN_SEMESTRE, "1");
            values.put(PlanejamentosContract.Planejamentos.COLLUMN_HORAS, "20");
            values.put(PlanejamentosContract.Planejamentos.COLLUMN_LINGUAS, "5");
            values.put(PlanejamentosContract.Planejamentos.COLLUMN_HUMANAS, "5");
            values.put(PlanejamentosContract.Planejamentos.COLLUMN_EXATAS, "5");
            values.put(PlanejamentosContract.Planejamentos.COLLUMN_SAUDE, "5");

            long id = db.insert(PlanejamentosContract.Planejamentos.TABLE_NAME, null, values);

            Toast.makeText(this, "Novo registro criado com id: " + id, Toast.LENGTH_LONG).show();

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

            Cursor cursorPlanrjamento = db.query(PlanejamentosContract.Planejamentos.TABLE_NAME, camposPlanejamento, null, null, null, null, null);

            final PlanejamentoAdapter adapter = new PlanejamentoAdapter(cursorPlanrjamento);
            RecyclerView rv = findViewById(R.id.rvPlanejamentos);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(this));

            /*
            pAdapter.setListener(new PlanejamentosAdapter.OnPlanejamentoClickListener() {
                @Override
                public void onPlanejamentoClick(View v, int position) {
                    Intent intent = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                    intent.putExtra("dados", planejamentos.get(position).getDisciplinas());
                    startActivity(intent);
                }
            });
            */

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

        /*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if (data != null) {
                if (requestCode == PlanejamentosActivity.REQUEST_PLANEJAMENTO && resultCode == PlanejamentosActivity.RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    Planejamentos t = new Planejamentos();
                    t.setAno((Integer) bundle.get("ano"));
                    t.setSemestre((Integer) bundle.get("semestre"));
                    t.setHorasLinguas((Float) bundle.get("hLinguas"));
                    t.setHorasHumanas((Float) bundle.get("hHumanas"));
                    t.setHorasExatas((Float) bundle.get("hExatas"));
                    t.setHorasSaude((Float) bundle.get("hSaude"));
                    t.calculaHoras();
                    this.planejamentos.add(t);
                }
                else if (requestCode == PlanejamentosActivity.REQUEST_MATERIA && resultCode == PlanejamentosActivity.RESULT_OK){
                    Bundle bundle = data.getExtras();
                    Disciplinas tempD = new Disciplinas();
                    int ano, semestre;
                    tempD.setNome((String) bundle.get("nome"));
                    tempD.setThoras((Float) bundle.get("tHora"));
                    tempD.setArea((String) bundle.get("area"));

                    ano = (int) bundle.get("ano");
                    semestre = (int) bundle.get("semestre");

                    for (int i=0; i<planejamentos.size(); i++){
                        if(planejamentos.get(i).getAno() == ano && planejamentos.get(i).getSemestre() == semestre){
                            planejamentos.get(i).setDisciplinas(tempD);
                        }
                    }
                }
            }
        }*/
    }
