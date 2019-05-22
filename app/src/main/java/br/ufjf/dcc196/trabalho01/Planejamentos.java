package br.ufjf.dcc196.trabalho01;

public class Planejamentos {
    private long id;
    private String ano;
    private String semestre;
    private String horas;
    private String linguas;
    private String humanas;
    private String exatas;
    private String saude;

    public Planejamentos(){}

    public Planejamentos(long id, String ano, String semestre, String horas, String linguas, String humanas, String exatas, String saude){
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.horas = horas;
        this.linguas = linguas;
        this.humanas = humanas;
        this.exatas = exatas;
        this.saude = saude;
    }

    @Override
    public String toString() {
        return "Planejamento{"+ "id: " + this.id + " ano: " + this.ano + " semestre: " + this.semestre + " horas: " + this.horas + " linguas: " + this.linguas + " humanas: " + this.humanas + " exatas: " + this.exatas + " saude: " + this.saude + "}";
    }
}
