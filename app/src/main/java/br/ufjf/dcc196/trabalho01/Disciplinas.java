package br.ufjf.dcc196.trabalho01;

public class Disciplinas {
    private long id;
    private String ano;
    private String semestre;
    private String nome;
    private String area;
    private String hora;

    public Disciplinas(){}

    public Disciplinas(long id, String ano, String semestre, String nome, String area, String hora){
        this.id = id;
        this.ano = ano;
        this.area = area;
        this.hora = hora;
        this.ano = ano;
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Planejamento{"+ "id: " + this.id + " ano: " + this.ano + " area: " + this.area + " horas: " + this.hora + " ano: " + this.ano + " semestre: " + this.semestre + "}";
    }
}
