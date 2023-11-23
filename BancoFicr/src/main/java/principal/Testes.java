package principal;

import connect.Conexao;
import gestaoBanco.Conta;
import gestaoBanco.ContaPoupanca;
import jakarta.persistence.*;

import java.sql.Connection;

public class Testes {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Banco-FICR");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Conta conta = new ContaPoupanca();
        conta.setConta("333-3");
        conta.setAgencia(234);
        entityManager.persist(conta);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

}
