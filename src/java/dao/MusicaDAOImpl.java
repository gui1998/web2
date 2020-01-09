package dao;

import cdi.DAOQualifier;
import entidades.Musica;
import java.util.List;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@DAOQualifier
public class MusicaDAOImpl implements MusicaDAO {

    @Inject
    private EntityManagerFactory fabrica;
    
    @Inject
    private Event<Musica> evento;

    public void save(Musica musica) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        System.out.println(musica.getClass().getSimpleName());
        if (musica.getId() > 0) {
            em.merge(musica);
        } else {
            em.persist(musica);
        }
        em.getTransaction().commit();
        em.close();
        evento.fire(musica);
    }
    
    public void delete(Musica musica){
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if(!em.contains(musica)){
            musica = em.merge(musica);
        }
        em.remove(musica);
        em.getTransaction().commit();
        em.close();
    }
    
    public Musica find(int id){
        EntityManager em = fabrica.createEntityManager();
        return em.find(Musica.class, id);
    }
    
    public List<Musica> list(){
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Musica c");
        return q.getResultList();
    }

}
