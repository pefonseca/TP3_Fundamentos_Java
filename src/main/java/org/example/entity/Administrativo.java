package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Administrativo extends Funcionario {

    private float bonus;
    private float desconto;

    public Administrativo() {
        this.setNome("Admin");
    }

    public Administrativo(String nome, int idade) {
        super(nome, idade);
    }

    public Administrativo(String nome, int idade, float salario, float bonus, float desconto) {
        super(nome, idade, salario);
        this.bonus = bonus;
        this.desconto = desconto;
    }
}
