package repositorios;

import gestaoBanco.Conta;
import interfaces.RepositorioContas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioContasLista implements RepositorioContas {
    private List<Conta> contas;

    public RepositorioContasLista() {
        contas = new ArrayList<Conta>();
    }

    @Override
    public void inserir(Conta conta) {
        contas.add(conta);
    }

    @Override
    public Conta procurar(String numeroConta) {
        Conta contaProcurada = null;
        for (Conta c: contas){
            if (c.getConta().equals(numeroConta)){
                contaProcurada = c;
            }
        }
        return contaProcurada;
    }

    @Override
    public void remover(String numeroConta) {
        int posicao = -1;
        for (Conta c: contas){
            if (c.getConta().equals(numeroConta)){
                posicao = contas.indexOf(c);
                break;
            }
        }
        if (posicao != -1){
            contas.remove(posicao);
        }
    }

    @Override
    public List<Conta> listar() {
        return this.contas;
    }
}
