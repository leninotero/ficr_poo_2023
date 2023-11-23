package interfaces;


import gestaoPessoas.Pessoa;

import java.util.List;

public interface RepositorioClientes {
    void inserir (Pessoa cliente);
    Pessoa procurar (String username);
    void remover (String username);
    List<Pessoa> listar();
}
