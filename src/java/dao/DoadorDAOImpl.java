package dao;

import entidades.Doador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DoadorDAOImpl implements DoadorDAO {

    private final EntityManagerFactory fabrica;

    public DoadorDAOImpl() {
        this.fabrica = Persistence
                .createEntityManagerFactory("jarewebMeuPU");
    }

    public void save(Doador doador) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if (doador.getId() > 0) {
            em.merge(doador);
        } else {
            em.persist(doador);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Doador doador){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(!em.contains(doador)){
            doador = em.merge(doador);
        }
        em.remove(doador);
        em.getTransaction().commit();
        em.close();
    }
    
    public Doador find(int id){
        EntityManager em = fabrica.createEntityManager();
        return em.find(Doador.class, id);
    }
    
    public List<Doador> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Doador c");
        return q.getResultList();
    }

}
