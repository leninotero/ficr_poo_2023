package view;

public class Menus {

    public void mostrarMenu(){
        System.out.println("Menu de Opções Banco FICR");
        System.out.println("1. Cadastro de Usuario");
        System.out.println("2. Abrir Conta");
        System.out.println("3. Sair");
        System.out.print("Digite a sua opção: ");
    }

    public void subMenuConta (){
        System.out.println("1. Conta Poupança");
        System.out.println("2. Listar Contas");
        System.out.println("3. Realizar Deposito");
        System.out.println("4. Excluir Conta");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.print("Digite a sua opção: ");
    }

    public void subMenuUsuarios (){
        System.out.println("1. Cadastrar Usuario");
        System.out.println("2. Listar Usuario");
        System.out.println("3. Voltar ao Menu Principal");
        System.out.print("Digite a sua opção: ");
    }
}
