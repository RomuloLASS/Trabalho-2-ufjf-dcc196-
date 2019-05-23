package br.ufjf.dcc196.trabalho01;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisciplinasAdapter extends RecyclerView.Adapter<DisciplinasAdapter.DisciplinaViewHolder> {
    private Cursor cursor;
    public PlanejamentoAdapter.OnPlanejamentoClickListener listener;


    public DisciplinasAdapter(Cursor c){
        this.cursor = c;
    }

    public void setCursor(Cursor cursor){
        this.cursor = cursor;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DisciplinasAdapter.DisciplinaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.planejamento_layout, viewGroup, false);
        DisciplinasAdapter.DisciplinaViewHolder viewHolder =  new DisciplinasAdapter.DisciplinaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaViewHolder holder, int position) {
        int idAno = cursor.getColumnIndex(PlanejamentosContract.Planejamentos.COLLUMN_ANO);
        int idSemestre = cursor.getColumnIndex(PlanejamentosContract.Planejamentos.COLLUMN_SEMESTRE);
        int idHoras = cursor.getColumnIndex(PlanejamentosContract.Planejamentos.COLLUMN_HORAS);
        int idLinguas = cursor.getColumnIndex(PlanejamentosContract.Planejamentos.COLLUMN_LINGUAS);
        int idHumanas = cursor.getColumnIndex(PlanejamentosContract.Planejamentos.COLLUMN_HUMANAS);
        int idExatas = cursor.getColumnIndex(PlanejamentosContract.Planejamentos.COLLUMN_EXATAS);
        int idSaude = cursor.getColumnIndex(PlanejamentosContract.Planejamentos.COLLUMN_SAUDE);
        cursor.moveToPosition(position);
        holder.txtAno.setText(cursor.getString(idAno));
        holder.txtSemestre.setText(cursor.getString(idSemestre));
        holder.txtHoras.setText(cursor.getString(idHoras));
        holder.txtLinguas.setText(cursor.getString(idLinguas));
        holder.txtHumanas.setText(cursor.getString(idHumanas));
        holder.txtExatas.setText(cursor.getString(idExatas));
        holder.txtSaude.setText(cursor.getString(idSaude));
    }

    @Override
    public int getItemCount() {
        return this.cursor.getCount();
    }


    public class DisciplinaViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAno;
        public TextView txtSemestre;
        public TextView txtHoras;
        public TextView txtLinguas;
        public TextView txtHumanas;
        public TextView txtExatas;
        public TextView txtSaude;

        public DisciplinaViewHolder(final View itemView) {
            super(itemView);
            txtAno = itemView.findViewById(R.id.txtAno);
            txtSemestre = itemView.findViewById(R.id.txtSemestre);
            txtHoras = itemView.findViewById(R.id.txtTotalHoras);
            txtLinguas = itemView.findViewById(R.id.txtLingua);
            txtHumanas = itemView.findViewById(R.id.txtHumanas);
            txtExatas = itemView.findViewById(R.id.txtExatas);
            txtSaude = itemView.findViewById(R.id.txtSaude);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onPlanejamentoClick(itemView, position);
                        }
                    }
                }
            });
        }
    }

    public interface OnDisciplinaClickListener {
        void onDisciplinaClick(View livroView, int position);
    }

    public void setOnDisciplinaClickListener(PlanejamentoAdapter.OnPlanejamentoClickListener listener){
        this.listener = listener;
    }
}
