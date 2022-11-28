package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Estagiario extends Funcionario {

    private String faculdade;
    private int periodo;

    public Estagiario() {
        this.setNome("Estag");
        this.setPeriodo(1);
    }

    public Estagiario(String nome, int idade, float salario) {
        super(nome, idade, salario);
    }

    public Estagiario(String nome, int idade, float salario, String faculdade) {
        super(nome, idade, salario);
        this.faculdade = faculdade;
    }

    @Override
    public float calcularSalarioLiquido() {
        return super.calcularSalarioLiquido() + periodo * 100;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + faculdade + ";" + periodo;
    }

}
