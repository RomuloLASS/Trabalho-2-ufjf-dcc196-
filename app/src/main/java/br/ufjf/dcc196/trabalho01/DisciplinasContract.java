package br.ufjf.dcc196.trabalho01;

import android.provider.BaseColumns;

public class DisciplinasContract {

    public static class Disciplinas implements BaseColumns {
        //Colunas da tabela
        public static final String TABLE_NAME = "disciplinas";
        public static final String COLLUMN_ANO = "ano";
        public static final String COLLUMN_SEMESTRE = "semestre";
        public static final String COLLUMN_NOME = "nome";
        public static final String COLLUMN_HORA = "hora";
        public static final String COLLUMN_AREA = "area";
        //SQL para a criação da tabela
        public static final String CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT , %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, _ID, COLLUMN_NOME, COLLUMN_AREA, COLLUMN_HORA, COLLUMN_ANO, COLLUMN_SEMESTRE);
        //SQL para deletar a tabela
        public static final String DROP_TABLE = String.format("DROP TABLE %s", TABLE_NAME);
    }
}
