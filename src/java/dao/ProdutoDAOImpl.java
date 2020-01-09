package dao;

import cdi.DAOQualifier;
import entidades.Produto;
import java.util.List;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@DAOQualifier
public class ProdutoDAOImpl implements ProdutoDAO {

    @Inject
    private EntityManagerFactory fabrica;
    
    @Inject
    private Event<Produto> evento;

    public void save(Produto produto) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        System.out.println(produto.getClass().getSimpleName());
        if (produto.getId() > 0) {
            em.merge(produto);
        } else {
            em.persist(produto);
        }
        em.getTransaction().commit();
        em.close();
        evento.fire(produto);
    }
    
    public void delete(Produto produto){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(!em.contains(produto)){
            produto = em.merge(produto);
        }
        em.remove(produto);
        em.getTransaction().commit();
        em.close();
    }
    
    public Produto find(int id){
        EntityManager em = fabrica.createEntityManager();
        return em.find(Produto.class, id);
    }
    
    public List<Produto> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Produto c");
        return q.getResultList();
    }

}
