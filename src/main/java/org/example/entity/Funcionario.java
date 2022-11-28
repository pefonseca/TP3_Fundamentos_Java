package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.auxiliar.Constante;

@Getter
@Setter
@ToString
public class Funcionario {

    private String nome;
    private int idade;
    private float salario;

    public Funcionario() {
        this.nome = Constante.NOME_PADRAO;
        this.idade = Constante.MAIOR_IDADE;
        this.salario = Constante.SALARIO_MINIMO;
    }

    public Funcionario(String nome, int idade) {
        this();
        this.nome = nome;
        this.idade = idade;
    }

    public Funcionario(String nome, int idade, float salario) {
        this(nome, idade);
        this.salario = salario;
    }

    public void imprimir(){
        float salarioLiquido = calcularSalarioLiquido();

        System.out.println("Funcionário: " + this);
        System.out.println("Salário Líquido = R$" + salarioLiquido);
        System.out.println("Situação = " + obterSituacao(salarioLiquido));
    }

    public float calcularSalarioLiquido(){
        return salario;
    }

    public String obterSituacao(float salarioLiquido){
        if(salarioLiquido >= Constante.SALARIO_LIQUIDO_MAXIMO) {
            return Constante.RICO;
        }
        return Constante.POBRE;
    }
}
