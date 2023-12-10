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
                case 1: mainSubMenuClientes(controlerCliente);
                    break;

                case 2: mainSUbMenuContas(controlerConta);
                    break;

                case 3: System.exit(0);
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
                case 2:
                    controlerConta.listarTodasContas(repositorioContas);
                    break;
                case 3: controlerConta.depositar(repositorioContas);
                    break;
                case 4: controlerConta.excluirConta(repositorioContas);
                    break;
                case 5: main(null);
                    break;
                default: System.out.println("Opção inválida!");
            }

            System.out.println("Deseja Continuar?");
            resposta = leia.next();

            if (resposta.equalsIgnoreCase("não")){
                System.out.println("Voltando ao menu principal...\n\n");
            }
        } while (resposta.equalsIgnoreCase("sim"));

    }

    public static void mainSubMenuClientes(ControlerCliente controlerCliente) throws Exception {
        Scanner leia = new Scanner(System.in);
        String resposta;
        int op;
        do {
            controlerCliente.mostrarSubMenuClientes();
            op = leia.nextInt();
            switch (op){
                case 1: controlerCliente.cadastrarCliente();
                    break;

                case 2: controlerCliente.listarUsuarios();
                    break;

                case 3: main(null);
                    break;

                default: System.out.println("Opção inválida. Verifique as opções do menu!");
            }
            System.out.println("Deseja Continuar?: ");
            resposta = leia.next();
            if (resposta.equalsIgnoreCase("não")){
                System.out.println("Voltando ao menu principal...\n\n");
            }
        }while(resposta.equalsIgnoreCase("SIM"));
    }

}