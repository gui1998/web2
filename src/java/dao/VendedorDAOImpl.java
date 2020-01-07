package dao;

import entidades.Vendedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VendedorDAOImpl implements VendedorDAO {

    private final EntityManagerFactory fabrica;

    public VendedorDAOImpl() {
        this.fabrica = Persistence
                .createEntityManagerFactory("jarewebMeuPU");
    }

    public void save(Vendedor vendedor) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if (vendedor.getId() > 0) {
            em.merge(vendedor);
        } else {
            em.persist(vendedor);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public void delete(Vendedor vendedor){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(!em.contains(vendedor)){
            vendedor = em.merge(vendedor);
        }
        em.remove(vendedor);
        em.getTransaction().commit();
        em.close();
    }
    
    public Vendedor find(int id){
        EntityManager em = fabrica.createEntityManager();
        return em.find(Vendedor.class, id);
    }
    
    public List<Vendedor> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Vendedor c");
        return q.getResultList();
    }

}
