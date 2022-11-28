package org.example.entity;

import org.example.exceptions.FaturamentoInvalidoException;
import org.example.exceptions.NomeIncompletoException;

public class Empresa {

    private String nome;
    private float faturamento;
    private Funcionario[] funcionarios;

    @Override
    public String toString() {
        return nome + ";" + faturamento;
    }

    private float calcularFolhaSalarial() {
        float folhaSalarial = 0;
        if(funcionarios != null) {
            for(Funcionario func : funcionarios) {
                folhaSalarial = folhaSalarial + func.calcularSalarioLiquido();
            }
        }
        return folhaSalarial;
    }

    private void impressaoFuncionarios() {
        if(funcionarios != null) {
            System.out.println("Funcionários:");

            for (Funcionario funcionario : funcionarios) {
                System.out.printf("%s - %d - %.2f\n",
                        funcionario.getNome(),
                        funcionario.getIdade(),
                        funcionario.getSalario()
                );
            }
        }
    }

    private int calcularQtdeFuncionarios() {
        return funcionarios != null ? funcionarios.length : 0;
    }

    public void imprimir() throws NomeIncompletoException {
        System.out.println("Empresa: " + getNome());

        System.out.println("Qtde Funcion�rios: " + calcularQtdeFuncionarios());

        System.out.println("Folha salarial: R$" + calcularFolhaSalarial());

        impressaoFuncionarios();
    }

    public String getNome() throws NomeIncompletoException {

        if(nome == null) {
            throw new NomeIncompletoException("O preenchimento do campo 'nome' est� incorreto");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nome.toUpperCase());
        return sb.toString();
    }

    public void setNome(String nome) throws NomeIncompletoException {
        if(nome == null) {
            throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto");
        }

        int posInicial = nome.indexOf(" ");
        int posFinal = nome.lastIndexOf(" ");

        if(posInicial < 0 || posFinal < 0) {
            throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto");
        }

        this.nome = nome.substring(0, posInicial);
    }
    public void setFaturamento(float faturamento) throws FaturamentoInvalidoException {

        if(faturamento < 0) {
            throw new FaturamentoInvalidoException("O valor do faturamento precisa positivo");
        }

        this.faturamento = faturamento;
    }
    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }
}