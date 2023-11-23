package controler;

import gestaoPessoas.Pessoa;

import java.util.Scanner;

public class ControlerCliente {
    Scanner input = new Scanner(System.in);
    Pessoa cliente;
    String cpf, nome, username, pwd, sexo, email;
    int idade;
    double rendaMensal;

    public void cadastrarCliente() {
        cliente = new Pessoa();
        System.out.println("Digite o CPF: ");
        cpf = input.next();
//        cliente.setCpf(cpf);

        System.out.println("Digite o nome: ");
        nome = input.next();
        cliente.setNome(nome);

        System.out.println("Digite a sua idade: ");
        idade = input.nextInt();
        cliente.setIdade(idade);

        System.out.println("Digite o seu sexo: ");
        sexo = input.next();
        cliente.setSexo(sexo.charAt(0));

        System.out.println("Digite o seu e-mail: ");
        email = input.next();
        cliente.setEmail(email);

        System.out.println("Digite o seu usuario: ");
        username = input.next();
        cliente.setUsername(username);

        System.out.println("Digite a sua senha: ");
        pwd = input.next();
        cliente.setPwd(pwd);

        System.out.println("Digite a sua renda mensal ");
        rendaMensal = input.nextDouble();
        cliente.setRendaMensal(rendaMensal);
    }

    public void listarUsuarios(){
        System.out.println(cliente.toString());
    }

}
