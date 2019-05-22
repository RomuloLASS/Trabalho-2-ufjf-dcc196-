package br.ufjf.dcc196.trabalho01;

import android.provider.BaseColumns;

public class PlanejamentosContract {
    public static class Planejamentos implements BaseColumns{
        //Colunas da tabela
        public static final String TABLE_NAME = "planejamento";
        public static final String COLLUMN_ANO = "ano";
        public static final String COLLUMN_SEMESTRE = "semestre";
        public static final String COLLUMN_HORAS = "horas";
        public static final String COLLUMN_LINGUAS = "linguas";
        public static final String COLLUMN_HUMANAS = "humanas";
        public static final String COLLUMN_EXATAS = "exatas";
        public static final String COLLUMN_SAUDE = "saude";
        //SQL para a criação da tabela
        public static final String CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT , %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, _ID, COLLUMN_ANO, COLLUMN_SEMESTRE, COLLUMN_HORAS, COLLUMN_LINGUAS, COLLUMN_HUMANAS, COLLUMN_EXATAS, COLLUMN_SAUDE);
        //SQL para deletar a tabela
        public static final String DROP_TABLE = String.format("DROP TABLE %s", TABLE_NAME);
    }

}
