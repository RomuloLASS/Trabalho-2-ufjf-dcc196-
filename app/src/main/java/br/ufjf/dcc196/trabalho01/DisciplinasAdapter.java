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
        View view =inflater.inflate(R.layout.disciplina_layout, viewGroup, false);
        DisciplinasAdapter.DisciplinaViewHolder viewHolder =  new DisciplinasAdapter.DisciplinaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinaViewHolder holder, int position) {
        int idNome = cursor.getColumnIndex(DisciplinasContract.Disciplinas.COLLUMN_NOME);
        int idArea = cursor.getColumnIndex(DisciplinasContract.Disciplinas.COLLUMN_AREA);
        int idHora = cursor.getColumnIndex(DisciplinasContract.Disciplinas.COLLUMN_HORA);

        cursor.moveToPosition(position);
        holder.txtNome.setText(cursor.getString(idNome));
        holder.txtArea.setText(cursor.getString(idArea));
        holder.txtHora.setText(cursor.getString(idHora));
    }

    @Override
    public int getItemCount() {
        return this.cursor.getCount();
    }


    public class DisciplinaViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNome;
        public TextView txtArea;
        public TextView txtHora;

        public DisciplinaViewHolder(final View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtDisciplina);
            txtArea = itemView.findViewById(R.id.txtArea);
            txtHora = itemView.findViewById(R.id.txtHora);
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
