package controler;

import gestaoBanco.Conta;
import gestaoBanco.ContaPoupanca;
import gestaoPessoas.Pessoa;
import gestaoPessoas.PessoaFisica;
import gestaoPessoas.PessoaJuridica;
import interfaces.RepositorioContas;
import repositorioBD.CadastroConta;
import repositorioJPA.CadastroContaJpa;
import repositorios.RepositorioContasLista;
import view.Menus;

import java.util.Scanner;

public class ControlerConta {
    Scanner input = new Scanner(System.in);
    Conta cp;
    Menus menu = new Menus();
    String conta;
    int agencia;
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
//        listaContas.inserir(cp);
//        CadastroConta.salvarConta(cp);
        CadastroContaJpa.salvarConta(cp);

    }

    public void listarTodasContas(RepositorioContas listaContas){
        System.out.println(((RepositorioContasLista) listaContas).listar());
    }
}
