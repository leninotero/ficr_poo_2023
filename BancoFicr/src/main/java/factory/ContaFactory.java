package factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ContaFactory {
    private static EntityManagerFactory efm;

    public static EntityManager configfactoryConta(){
        efm = Persistence.createEntityManagerFactory("Banco-FICR");
        EntityManager em = efm.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public static void commitAndClose(EntityManager em){

        em.getTransaction().commit();

        em.close();
        efm.close();

    }
}
