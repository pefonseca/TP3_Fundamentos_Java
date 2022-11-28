package org.example;

import org.example.auxiliar.Constante;
import org.example.entity.Administrativo;
import org.example.entity.Empresa;
import org.example.entity.Estagiario;
import org.example.entity.Funcionario;
import org.example.entity.Programador;
import org.example.exceptions.FaturamentoInvalidoException;
import org.example.exceptions.NomeIncompletoException;

import java.util.Scanner;

public class Main {

    private static Funcionario[] funcionarios;

    private static void imprimir() {
        for (int i = 0; i < Constante.TAMANHO; i++) {
            if(funcionarios[i] != null) {
                funcionarios[i].imprimir();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        try {

            try {

                Empresa empresa = new Empresa();
                empresa.setNome("xpto corporation");
                empresa.setFaturamento(1000000);

                funcionarios = new Funcionario[Constante.TAMANHO];

                Scanner in = new Scanner(System.in);

                String option;
                int pos = 0;

                do {
                    System.out.print("Bem vindo a empresa: " + empresa.getNome() + "!\n");

                    System.out.println("[1] Cadastrar Administrativo!");
                    System.out.println("[2] Cadastrar Programador!");
                    System.out.println("[3] Cadastrar Estagiário!");
                    System.out.println("[4] Consultar todos funcionários!");
                    System.out.println("[5] Sair");

                    System.out.print("Informe a opção desejada: ");
                    option = in.next();

                    switch (option) {
                        case "1":
                            if(pos < Constante.TAMANHO) {
                                Administrativo adm = new Administrativo();

                                System.out.print("Informe o nome: ");
                                adm.setNome(in.next());

                                System.out.print("Informe a idade: ");
                                adm.setIdade(in.nextInt());

                                System.out.print("Informe o salário: ");
                                adm.setSalario(in.nextFloat());

                                System.out.print("Informe o bônus: ");
                                adm.setBonus(in.nextFloat());

                                System.out.print("Informe o seu desconto: ");
                                adm.setDesconto(in.nextFloat());

                                funcionarios[pos] = adm;

                                funcionarios[pos].imprimir();

                                pos++;

                                empresa.setFuncionarios(funcionarios);
                            } else {
                                System.out.println("Impossível realizar um novo cadastro!");
                            }
                            break;
                        case "2":
                            if(pos < Constante.TAMANHO) {
                                System.out.print("Informe o seu nome: ");
                                String nome = in.next();

                                System.out.print("Informe a sua idade: ");
                                int idade = in.nextInt();

                                Programador prog = new Programador(nome, idade);

                                System.out.print("Informe o seu salário: ");
                                prog.setSalario(in.nextFloat());

                                System.out.print("Informe se é fullstack: ");
                                prog.setDevFull(in.nextBoolean());

                                System.out.print("Informe o sua linguagem principal: ");
                                prog.setLinguagem(in.next());

                                funcionarios[pos] = prog;

                                funcionarios[pos].imprimir();

                                pos++;

                                empresa.setFuncionarios(funcionarios);
                            } else {
                                System.out.println("Impossível realizar um novo cadastro!");
                            }
                            break;
                        case "3":
                            if(pos < Constante.TAMANHO) {
                                System.out.print("Informe o seu nome: ");
                                String nome = in.next();

                                System.out.print("Informe a sua idade: ");
                                int idade = in.nextInt();

                                System.out.print("Informe seu salário: ");
                                float salario = in.nextFloat();

                                Estagiario estag = new Estagiario(nome, idade, salario);

                                System.out.print("Informe o nome da sua faculdade: ");
                                estag.setFaculdade(in.next());

                                System.out.print("Informe o período que está na faculdade: ");
                                estag.setPeriodo(in.nextInt());

                                funcionarios[pos] = estag;

                                funcionarios[pos].imprimir();

                                pos++;

                                empresa.setFuncionarios(funcionarios);
                            } else {
                                System.out.println("Impossível realizar um novo cadastro!");
                            }
                            break;
                        case "4":
                            imprimir();
                            break;
                        case "5":
                            System.out.println("\nSaindo...\n");
                            Thread.sleep(1000);
                            System.out.print("3...");
                            Thread.sleep(1000);
                            System.out.print(" 2...");
                            Thread.sleep(1000);
                            System.out.print(" 1...\n");
                            break;
                        default:
                            System.out.println("A opção [" + option + "] é inválida!");
                            break;
                    }
                } while (!"5".equalsIgnoreCase(option));
            } catch (NomeIncompletoException | FaturamentoInvalidoException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }

        } finally {
            System.out.println("\nProcessamento realizado com sucesso!!!");
        }
    }
}