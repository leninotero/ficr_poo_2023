package view;

public class Menus {

    public void mostrarMenu(){
        System.out.println("Menu de Opções Banco FICR");
        System.out.println("1. Cadastrar Usuario");
        System.out.println("2. Listar Usuario");
        System.out.println("3. Abrir Conta");
        System.out.println("4. Consultar Saldo");
        System.out.println("5. Depositar");
        System.out.println("6. Sacar");
        System.out.println("7. Pagar Boleto");
        System.out.println("8. Sair");
        System.out.print("Digite a sua opção: ");
    }

    public void subMenuConta (){
        System.out.println("1. Conta Poupança");
        System.out.println("2. Conta Corrente");
        System.out.println("3. Listar Contas");
        System.out.println("4. Voltar ao Menu Principal");
        System.out.print("Digite a sua opção: ");
    }
}
