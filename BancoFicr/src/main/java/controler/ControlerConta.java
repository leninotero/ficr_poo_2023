package controler;

import gestaoBanco.Conta;
import gestaoBanco.ContaPoupanca;
import gestaoPessoas.Pessoa;
import gestaoPessoas.PessoaFisica;
import gestaoPessoas.PessoaJuridica;
import interfaces.RepositorioContas;
import repositorioBD.CadastroConta;
import repositorioJPA.CadastroContaJpa;
import view.Menus;

import java.util.Scanner;

public class ControlerConta {
    Scanner input = new Scanner(System.in);
    Conta cp;
    Menus menu = new Menus();
    String conta;
    int agencia, id;
    double saldo, valor;
    Pessoa pf = new PessoaFisica();
    Pessoa pj = new PessoaJuridica();

    public void mostrarSubMenuContas(){
        menu.subMenuConta();
    }

    public void criarContaPoupanca(RepositorioContas listaContas) throws Exception {
        cp = new ContaPoupanca();
        System.out.println("Digite o numero da conta: ");
        conta = input.next();
        cp.setConta(conta);
        System.out.println("Digite o numero da agencia: ");
        agencia = input.nextInt();
        cp.setAgencia(agencia);
        cp.setLimiteConta(100.00);
//        listaContas.inserir(cp);          //Nesta linha usamos ArrayList
//        CadastroConta.salvarConta(cp);    //Nesta linha usamos JDBC
        CadastroContaJpa.salvarConta(cp);   //Nesta linha usamos JPA

    }

    public void listarTodasContas(RepositorioContas listaContas) throws Exception {
//        System.out.println(((RepositorioContasLista) listaContas).listar());  //Nesta linha usamos ArrayList
        CadastroConta.listarContas(cp);         //Nesta linha usamos JDBC
    }

    public void depositar(RepositorioContas listaContas) throws Exception{
//        cp = new ContaPoupanca();
        System.out.println("Digite o numero da conta: ");
        conta = input.next();
        cp.setConta(conta);
        System.out.println("Confirme o número da sua agencia: " + cp.getAgencia());
        agencia = input.nextInt();
        cp.setAgencia(agencia);
        System.out.println("Digite o valor a ser depositado: ");
        valor = input.nextDouble();
        cp.depositar(valor);
        saldo = cp.getSaldo();
        cp.setSaldo(saldo);
        cp.setLimiteConta(100.00);
        CadastroConta.alterarConta(cp);     //Nesta linha usamos JDBC
    }

    public void excluirConta(RepositorioContas listaContas) throws Exception{
        System.out.println("Digite o numero da conta a ser excluida: ");
        conta = input.next();
        cp.setConta(conta);
//        listaContas.remover(cp.getConta());   //Nesta linha usamos ArrayList
        CadastroConta.excluirConta(cp);         //Nesta linha usamos JDBC
    }
}
