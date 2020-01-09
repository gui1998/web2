package dao;

import cdi.DAOQualifier;
import entidades.Veiculo;
import java.util.List;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@DAOQualifier
public class VeiculoDAOImpl implements VeiculoDAO {

    @Inject
    private EntityManagerFactory fabrica;
    
    @Inject
    private Event<Veiculo> evento;

    public void save(Veiculo veiculo) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        System.out.println(veiculo.getClass().getSimpleName());
        if (veiculo.getId() > 0) {
            em.merge(veiculo);
        } else {
            em.persist(veiculo);
        }
        em.getTransaction().commit();
        em.close();
        evento.fire(veiculo);
    }
    
    public void delete(Veiculo veiculo){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(!em.contains(veiculo)){
            veiculo = em.merge(veiculo);
        }
        em.remove(veiculo);
        em.getTransaction().commit();
        em.close();
    }
    
    public Veiculo find(int id){
        EntityManager em = fabrica.createEntityManager();
        return em.find(Veiculo.class, id);
    }
    
    public List<Veiculo> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Veiculo c");
        return q.getResultList();
    }

}
