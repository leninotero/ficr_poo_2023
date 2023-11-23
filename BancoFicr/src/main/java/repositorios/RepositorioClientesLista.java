package repositorios;

import gestaoBanco.Conta;
import gestaoPessoas.Pessoa;
import interfaces.RepositorioClientes;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClientesLista implements RepositorioClientes {
    private List<Pessoa> clientes;

    public RepositorioClientesLista(){
        clientes = new ArrayList<Pessoa>();
    }

    @Override
    public void inserir(Pessoa cliente){
        clientes.add(cliente);
    }

    @Override
    public Pessoa procurar(String username){
        Pessoa clienteProcurado = null;
        for (Pessoa p: clientes){
            if (p.getUsername().equals(username)){
                clienteProcurado = p;
            }
        }
        return clienteProcurado;
    }

    @Override
    public void remover(String username){
        int posicao = -1;
        for (Pessoa p: clientes){
            if (p.getUsername().equals(username)) {
                posicao = clientes.indexOf(p);
                break;
            }
        }
        if (posicao != -1){
            clientes.remove(posicao);
        }
    }

    @Override
    public List<Pessoa> listar(){
        return this.clientes;
    }

}
