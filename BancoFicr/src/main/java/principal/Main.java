package principal;

import controler.ControlerCliente;
import controler.ControlerConta;
import interfaces.RepositorioContas;
import repositorios.RepositorioContasLista;
import view.Menus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Menus menu = new Menus();
        ControlerCliente controlerCliente = new ControlerCliente();
        ControlerConta controlerConta = new ControlerConta();
        Scanner leia = new Scanner(System.in);
        String resposta;
        int op;

        do {
            menu.mostrarMenu();
            op = leia.nextInt();
            switch (op){
                case 1: controlerCliente.cadastrarCliente();
                    break;

                case 2: controlerCliente.listarUsuarios();
                    break;

                case 3: mainSUbMenuContas(controlerConta);
                    break;

                case 8: System.exit(0);
                    break;
                default: System.out.println("Opção inválida. Verifique as opções do menu!");
            }
            System.out.println("Deseja Continuar?: ");
            resposta = leia.next();
        }while(resposta.equalsIgnoreCase("SIM"));

    }

    public static void mainSUbMenuContas(ControlerConta controlerConta) throws Exception {
        RepositorioContas repositorioContas = new RepositorioContasLista();
        Scanner leia = new Scanner(System.in);
        String resposta;
        int op;
        do {
            controlerConta.mostrarSubMenuContas();
            op = leia.nextInt();
            switch (op) {
                case 1:
                    controlerConta.criarContaPoupanca(repositorioContas);
                    break;
                case 3:
                    controlerConta.listarTodasContas(repositorioContas);
                    break;
            }
            System.out.println("Deseja Continuar?");
            resposta = leia.next();
        } while (resposta.equalsIgnoreCase("sim"));

    }

}