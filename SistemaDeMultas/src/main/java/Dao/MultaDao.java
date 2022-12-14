package Dao;


import Model.Multa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class MultaDao {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mildevs-multas");
    private static EntityManager manager = factory.createEntityManager();

    public boolean save(Multa multa) {
        manager = Persistence.createEntityManagerFactory("mildevs-multas").createEntityManager();
        manager.getTransaction().begin();
        manager.persist(multa);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    public List<Multa> ListaMultas(Long idVeiculo) {
        String sql = "select * from multa m where m.veiculo_id = " + idVeiculo + ";";
        List<Multa> listaRetorno =  manager.createNativeQuery(sql, Multa.class).getResultList();
        if (listaRetorno.isEmpty()) {
            throw new RuntimeException("Veiculo não contem multas");
        }

        manager.close();
        return listaRetorno;
    }
}
