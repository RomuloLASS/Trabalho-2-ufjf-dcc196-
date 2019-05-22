package br.ufjf.dcc196.trabalho01;

import android.provider.BaseColumns;

public class PlanejamentosContract {
    public static class Planejamentos implements BaseColumns{
        //Colunas da tabela
        public static final String TABLE_ANO = "ano";
        public static final String COLLUMN_SEMESTRE = "semestre";
        public static final String COLLUMN_HORAS = "horas";
        public static final String COLLUMN_LINGUAS = "linguas";
        public static final String COLLUMN_HUMANAS = "humanas";
        public static final String COLLUMN_EXATAS = "exatas";
        public static final String COLLUMN_SAUDE = "saude";


    }

}
