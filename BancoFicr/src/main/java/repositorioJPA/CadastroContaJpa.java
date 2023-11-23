package repositorioJPA;

import factory.ContaFactory;
import gestaoBanco.Conta;
import jakarta.persistence.EntityManager;

public class CadastroContaJpa {

    public static void salvarConta(Conta conta){
        EntityManager entityManager;

        entityManager = ContaFactory.configfactoryConta();
        entityManager.persist(conta);
        ContaFactory.commitAndClose(entityManager);
    }
}
